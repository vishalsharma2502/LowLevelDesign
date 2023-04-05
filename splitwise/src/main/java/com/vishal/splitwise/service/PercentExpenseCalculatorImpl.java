package com.vishal.splitwise.service;

import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.UserShare;
import com.vishal.splitwise.model.expense.Expense;
import com.vishal.splitwise.repository.UserRepository;

import java.util.Set;

public class PercentExpenseCalculatorImpl implements IExpenseCalculator{
    @Override
    public void calculateExpense(Expense expense) {

        Set<UserShare> userShareSet = expense.getUserShareSet();
        double totalPercent = 100.00;
        double splitPercent = expense.getAmount()/userShareSet.size();

        for(UserShare share: userShareSet){
            User user = UserRepository.userMap.values().stream().filter(u -> u.getName().equalsIgnoreCase(share.getUserName())).findFirst().get();
            user.getBalanceSheet().put(user, expense.getAmount() * (splitPercent/100.0));
        }

    }
}
