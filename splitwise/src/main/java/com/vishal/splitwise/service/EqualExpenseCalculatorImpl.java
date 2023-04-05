package com.vishal.splitwise.service;

import com.vishal.splitwise.model.ExpenseGroup;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.expense.Expense;
import com.vishal.splitwise.repository.ExpenseGroupRepository;
import com.vishal.splitwise.repository.UserRepository;

import java.util.Set;

public class EqualExpenseCalculatorImpl implements IExpenseCalculator{

    @Override
    public void calculateExpense(Expense expense) {

        ExpenseGroup group = ExpenseGroupRepository.expenseGroupMap.get(expense.getExpenseGroupId());
        double splitAmount = expense.getAmount()/group.getGroupMembers().size();
        User paidBy = UserRepository.userMap.get(expense.getPaidBy());
        for(User user: group.getGroupMembers()){
            if(user.getName().equalsIgnoreCase(paidBy.getName())){
                continue;
            }
            user.getBalanceSheet().put(paidBy, splitAmount);
        }
    }
}
