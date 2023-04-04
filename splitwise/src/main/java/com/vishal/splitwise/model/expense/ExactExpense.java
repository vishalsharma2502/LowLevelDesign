package com.vishal.splitwise.model.expense;

import com.vishal.splitwise.model.ExpenseMetaData;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.split.ExactSplit;
import com.vishal.splitwise.model.split.Split;
import lombok.Getter;

import java.util.List;

@Getter
public class ExactExpense extends Expense {

    public ExactExpense(Double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
        super(amount, paidBy, splits, metaData);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof ExactSplit)){
                return false;
            }
        }
        double totalAmount = getAmount();
        double sumSplitAmount = 0;
        for(Split split: getSplits()){
            ExactSplit exactSplit = (ExactSplit) split;
            sumSplitAmount += exactSplit.getAmount();
        }
        return totalAmount == sumSplitAmount;
    }
}
