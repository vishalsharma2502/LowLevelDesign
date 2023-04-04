package com.vishal.splitwise;

import com.vishal.splitwise.model.ExpenseType;
import com.vishal.splitwise.model.User;
import com.vishal.splitwise.model.split.EqualSplit;
import com.vishal.splitwise.model.split.ExactSplit;
import com.vishal.splitwise.model.split.PercentageSplit;
import com.vishal.splitwise.model.split.Split;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//@SpringBootApplication
public class SplitwiseApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SplitwiseApplication.class, args);
		ExpenseManager expenseManager = new ExpenseManager();
		expenseManager.addUser(new User("u1", "User1", 9898L, "user1@gmail.com"));
		expenseManager.addUser(new User("u2", "User2", 9897L, "user2@gmail.com"));
		expenseManager.addUser(new User("u3", "User3", 9896L, "user3@gmail.com"));
		expenseManager.addUser(new User("u4", "User4", 9895L, "user4@gmail.com"));

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag){
			String command = sc.nextLine();
			String[] commands = command.split(" ");
			String commandType = commands[0];
			if(Objects.equals(commandType, "false")){
				break;
			}
			System.out.println("******************************");
			System.out.println(command);

			switch (commandType){
				case "SHOW": if(commands.length == 1){
					expenseManager.showBalances();
				} else expenseManager.showBalance(commands[1]);
					break;
				case "EXPENSE" :
					String paidBy = commands[1];
					Double amount = Double.parseDouble(commands[2]);
					int noOfUsers = Integer.parseInt(commands[3]);
					String expenseType = commands[4 + noOfUsers];
					List<Split> splitList = new ArrayList<>();
					switch (expenseType){
						case "EQUAL":
							for(int i = 0; i<noOfUsers; i++){
								splitList.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
							}
							expenseManager.addExpense(ExpenseType.EQUAL, amount,paidBy, splitList, null);
							break;
						case "EXACT":
							for(int i = 0; i<noOfUsers; i++){
								splitList.add(new ExactSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
							}
							expenseManager.addExpense(ExpenseType.EXACT,amount,paidBy, splitList, null);

						case "PERCENT":
							for (int i = 0; i < noOfUsers; i++) {
								splitList.add(new PercentageSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
							}
							expenseManager.addExpense(ExpenseType.PERCENTAGE, amount, paidBy, splitList, null);
							break;
					}
					break;
			}
		}

	}

}
