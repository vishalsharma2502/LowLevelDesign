package com.vishal.splitwise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class User {
    private String Id;
    private String name;
    private String email;
    private String mobileNo;

    public User(String name, String email, String mobileNo) {
        this.Id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Id.equals(user.Id)) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = Id.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
