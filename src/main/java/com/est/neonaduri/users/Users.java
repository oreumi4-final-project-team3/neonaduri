package com.est.neonaduri.users;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id
    @Column(name="USER_ID", updatable = false,length = 100)
    private String userId;

    @Column(name="USER_NAME",nullable = false,length=20)
    private String userName;

}
