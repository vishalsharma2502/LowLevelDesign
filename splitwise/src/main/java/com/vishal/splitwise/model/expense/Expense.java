package com.vishal.splitwise.model.expense;

import com.vishal.splitwise.model.ExpenseType;
import com.vishal.splitwise.model.User;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public abstract class Expense {
    private String Id;
    private String title;
    private ExpenseType expenseType;
    private String expenseGroupId;
    private OffsetDateTime createdAt;
    private Double amount;
    private String paidBy;
    Set<User> userSet;

    public Expense(String title, ExpenseType expenseType, String expenseGroupId, OffsetDateTime createdAt, Double amount, String paidBy, Set<User> userSet) {
        this.Id = UUID.randomUUID().toString();
        this.title = title;
        this.expenseType = expenseType;
        this.expenseGroupId = expenseGroupId;
        this.createdAt = createdAt;
        this.amount = amount;
        this.paidBy = paidBy;
        this.userSet = new HashSet<>(userSet);
//        if((expenseGroupId == null || expenseGroupId.isEmpty()) && !userSet.isEmpty()){
//            this.userSet = new HashSet<>(userSet);
//        }
    }

    public abstract boolean validate();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Expense expense = (Expense) o;

        if (!Id.equals(expense.Id)) return false;
        if (!createdAt.equals(expense.createdAt)) return false;
        if (!amount.equals(expense.amount)) return false;
        return paidBy.equals(expense.paidBy);
    }

    @Override
    public int hashCode() {
        int result = Id.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + paidBy.hashCode();
        return result;
    }


}
