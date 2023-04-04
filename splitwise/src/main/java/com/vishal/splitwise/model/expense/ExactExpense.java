package com.vishal.splitwise.model.expense;

import com.vishal.splitwise.model.ExpenseType;
import com.vishal.splitwise.model.User;

import java.time.OffsetDateTime;
import java.util.Set;

public class ExactExpense extends Expense{
    public ExactExpense(String title, ExpenseType expenseType, String expenseGroupId, OffsetDateTime createdAt, Double amount, String paidBy, Set<User> userSet) {
        super(title, expenseType, expenseGroupId, createdAt, amount, paidBy, userSet);
    }

    @Override
    public boolean validate() {
        if(getExpenseType() != ExpenseType.EXACT){
            return false;
        }
        double totalAmount = getAmount();
        double sumSplitAmount = 0;
//        for(Split split: getSplits()){
//            ExactSplit exactSplit = (ExactSplit) split;
//            sumSplitAmount += exactSplit.getAmount();
//        }
//        return totalAmount == sumSplitAmount;
        return true;
    }
}
