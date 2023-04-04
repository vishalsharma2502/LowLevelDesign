package com.vishal.splitwise.model.expense;

import com.vishal.splitwise.model.ExpenseMetaData;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.split.PercentageSplit;
import com.vishal.splitwise.model.split.Split;

import java.util.List;

public class PercentageExpense extends Expense {

    public PercentageExpense(Double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
        super(amount, paidBy, splits, metaData);
    }

    @Override
    public boolean validate() {
        for(Split split: getSplits()){
            if(!(split instanceof PercentageSplit)){
                return false;
            }
        }

        double totalPercentage = 100;
        double splitPercentage = 0;
        for(Split split: getSplits()){
            PercentageSplit percentageSplit = (PercentageSplit) split;
            splitPercentage += percentageSplit.getPercentage();
        }

        return totalPercentage == splitPercentage;
    }
}
