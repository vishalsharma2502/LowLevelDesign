package com.vishal.splitwise.model;

import com.vishal.splitwise.model.expense.Expense;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class ExpenseGroup {

    private String Id;
    private String name;
    private Set<User> groupMembers;
    private Set<Expense> expenseSet;

    public ExpenseGroup(String name, Set<User> users) {
        this.Id = UUID.randomUUID().toString();
        this.name = name;
        this.groupMembers = new HashSet<>(users);
        this.expenseSet = new HashSet<>();

        System.out.println("**************** User Group Created "+ this.name + " +***************");
        groupMembers.forEach(user -> System.out.println(user.getName()));
        System.out.println("****************************************************");
    }




}
