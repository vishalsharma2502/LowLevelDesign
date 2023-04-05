package com.vishal.splitwise.service;

import com.vishal.splitwise.model.ExpenseType;
import org.springframework.lang.NonNull;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ExpenseCalculatorFactory {

    private static Map<ExpenseType, IExpenseCalculator> expenseCalculator = new HashMap<>();

    public IExpenseCalculator getExpenseCalculator(@NonNull ExpenseType expenseType){
        return expenseCalculator.get(expenseType);
    }

    public void addExpenseStrategy(){
        expenseCalculator.put(ExpenseType.EXACT, new ExactExpenseCalculatorImpl());
        expenseCalculator.put(ExpenseType.EQUAL, new EqualExpenseCalculatorImpl());
        expenseCalculator.put(ExpenseType.PERCENT, new PercentExpenseCalculatorImpl());
    }

}
