package com.vishal.splitwise.service;

import com.vishal.splitwise.exception.ExpenseAlreadyAddedException;
import com.vishal.splitwise.exception.GroupNotFoundException;
import com.vishal.splitwise.model.expense.Expense;
import com.vishal.splitwise.model.ExpenseGroup;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.repository.ExpenseGroupRepository;

import java.util.Set;

public class ExpenseGroupService {

    public void createExpenseGroup(ExpenseGroup expenseGroup){
        ExpenseGroupRepository.expenseGroupMap.putIfAbsent(expenseGroup.getId(), expenseGroup);
    }

    public void addExpense(ExpenseGroup group, Expense expense){
        ExpenseGroup expenseGroup = ExpenseGroupRepository.expenseGroupMap.get(group.getId());
        if(expenseGroup == null){
            throw new GroupNotFoundException("Group with "+ group.getName() + " not exist");
        }
        if(!expenseGroup.getExpenseSet().contains(expense)){
            expenseGroup.getExpenseSet().add(expense);
        } else{
            throw new ExpenseAlreadyAddedException(expense.getTitle() + " Expense is already added to this group");
        }
    }

    public void addUser(Set<User> users, ExpenseGroup group) {
        ExpenseGroup expenseGroup = ExpenseGroupRepository.expenseGroupMap.get(group.getId());
        if(expenseGroup == null){
            throw new GroupNotFoundException("Group with "+ group.getName() + " not exist");
        }
        for(User user: users){
            if(!expenseGroup.getGroupMembers().contains(user)){
                expenseGroup.getGroupMembers().add(user);
            } else{
                System.out.println(user.getName() + " user is already part of this group");
            }
        }
    }
}
