package com.vishal.splitwise.service;

import com.vishal.splitwise.model.expense.Expense;
import com.vishal.splitwise.repository.ExpenseRepository;

public class ExpenseService {

    public void createExpense(Expense expense){
        ExpenseRepository.expenseMap.putIfAbsent(expense.getId(), expense);

        switch (expense.getExpenseType()){

        }
    }


}
