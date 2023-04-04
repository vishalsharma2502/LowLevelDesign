package com.vishal.splitwise.service;

import com.vishal.splitwise.UnknownSplitException;
import com.vishal.splitwise.model.ExpenseMetaData;
import com.vishal.splitwise.model.ExpenseType;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.expense.EqualExpense;
import com.vishal.splitwise.model.expense.ExactExpense;
import com.vishal.splitwise.model.expense.Expense;
import com.vishal.splitwise.model.expense.PercentageExpense;
import com.vishal.splitwise.model.split.PercentageSplit;
import com.vishal.splitwise.model.split.Split;

import java.util.List;

public class ExpenseService {

    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splitList, ExpenseMetaData expenseMetaData){

        switch (expenseType){
            case EXACT -> {
                return new ExactExpense(amount, paidBy, splitList, expenseMetaData);
            }
            case PERCENTAGE -> {
                for(Split split: splitList){
                    PercentageSplit percentageSplit = (PercentageSplit) split;
                    split.setAmount((amount* percentageSplit.getPercentage())/100.0);
                }
                return new PercentageExpense(amount, paidBy, splitList, expenseMetaData);
            }
            case EQUAL -> {
                int totalSplit = splitList.size();
                double splitAmount = ((double)  Math.round(amount*100/totalSplit))/100.0;
                for(Split split: splitList){
                    split.setAmount(splitAmount);
                }
                splitList.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplit));
                return new EqualExpense(amount, paidBy, splitList, expenseMetaData);
            }
            default -> {
                throw new UnknownSplitException("Unknown Split, pleaes create this expense again");
            }
        }
    }
}
