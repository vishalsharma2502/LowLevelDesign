package com.vishal.splitwise.model.split;

import com.vishal.splitwise.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public abstract class Split {
    private User user;
    Double amount;

    public Split(User user) {
        this.user = user;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
