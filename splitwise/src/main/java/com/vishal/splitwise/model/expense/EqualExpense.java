package com.vishal.splitwise.model.expense;

import com.vishal.splitwise.model.ExpenseType;
import com.vishal.splitwise.model.User;

import java.time.OffsetDateTime;
import java.util.Set;

public class EqualExpense extends Expense {

    public EqualExpense(String title, ExpenseType expenseType, String expenseGroupId, OffsetDateTime createdAt, Double amount, String paidBy, Set<User> userSet) {
        super(title, expenseType, expenseGroupId, createdAt, amount, paidBy, userSet);
    }

    @Override
    public boolean validate() {
        if(ExpenseType.EQUAL != getExpenseType()){
            return false;
        }
        return true;
    }
}
