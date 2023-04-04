package com.vishal.splitwise.model.split;

import com.vishal.splitwise.model.User;
import lombok.Getter;

@Getter
public class PercentageSplit extends Split{
    double percentage ;

    public PercentageSplit(User user, double percentage) {
        super(user);
        this.percentage = percentage;
    }
}
