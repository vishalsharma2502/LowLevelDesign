package com.vishal.splitwise.model.split;

import com.vishal.splitwise.model.User;
import lombok.Getter;

@Getter
public class ExactSplit extends Split {

    public ExactSplit(User user, Double amount) {
        super(user);
        this.amount = amount;
    }
}
