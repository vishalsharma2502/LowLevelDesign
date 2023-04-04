package com.vishal.splitwise.model.expense;

import com.vishal.splitwise.model.ExpenseMetaData;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.split.Split;
import lombok.Getter;

import java.util.List;


@Getter
public abstract class Expense {
    private Long id;
    private Double amount;
    private User paidBy;
    private List<Split> splits;
    private ExpenseMetaData metaData;

    public Expense(Double amount, User paidBy, List<Split> splits, ExpenseMetaData metaData) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.metaData = metaData;
    }

    public abstract boolean validate();
}
