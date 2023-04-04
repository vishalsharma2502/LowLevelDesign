package com.vishal.splitwise;

import com.vishal.splitwise.model.ExpenseMetaData;
import com.vishal.splitwise.model.ExpenseType;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.expense.Expense;
import com.vishal.splitwise.model.split.Split;
import com.vishal.splitwise.service.ExpenseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    List<Expense> expenseList;
    Map<String, User> userMap;

    Map<String, Map<String, Double>> balanceSheetMap;

    public ExpenseManager() {
        expenseList = new ArrayList<>();
        userMap = new HashMap<>();
        balanceSheetMap = new HashMap<String, Map<String, Double>>();
    }

    public void addUser(User user){
        userMap.put(user.getId(), user);
        balanceSheetMap.put(user.getId(), new HashMap<String, Double>());
    }

    public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splitList, ExpenseMetaData expenseMetaData){
        Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(paidBy), splitList, expenseMetaData);
        expenseList.add(expense);
        for(Split split: splitList){
            String paidTo = split.getUser().getId();
            Map<String, Double> balances  = balanceSheetMap.get(paidBy);
            if(!balances.containsKey(paidTo)){
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo)+ split.getAmount());

            balances = balanceSheetMap.get(paidTo);

            if(!balances.containsKey(paidBy)){
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy,balances.get(paidBy) - split.getAmount());
        }
    }

    public void showBalance(String userId) {
        boolean isEmpty = true;
        for (Map.Entry<String, Double> userBalance : balanceSheetMap.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                isEmpty = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    public void showBalances() {
        boolean isEmpty = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheetMap.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    isEmpty = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (isEmpty) {
            System.out.println("No balances");
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        String user1Name = userMap.get(user1).getUsername();
        String user2Name = userMap.get(user2).getUsername();
        if (amount < 0) {
            System.out.println(user1Name + " owes " + user2Name + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(user2Name + " owes " + user1Name + ": " + Math.abs(amount));
        }
    }
}
