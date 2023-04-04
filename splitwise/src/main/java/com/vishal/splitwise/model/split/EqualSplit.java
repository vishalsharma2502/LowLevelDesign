package com.vishal.splitwise.model.split;

import com.vishal.splitwise.model.User;
import lombok.Getter;

@Getter
public class EqualSplit extends Split{

    public EqualSplit(User user) {
        super(user);
    }
}
