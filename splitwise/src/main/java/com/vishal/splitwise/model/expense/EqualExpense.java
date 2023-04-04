package com.vishal.splitwise.model.expense;

import com.vishal.splitwise.model.ExpenseMetaData;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.split.EqualSplit;
import com.vishal.splitwise.model.split.Split;

import java.util.List;

public class EqualExpense extends Expense {

    public EqualExpense(Double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
        super(amount, paidBy, splits, metaData);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof EqualSplit)){
                return false;
            }
        }
        return true;
    }
}
