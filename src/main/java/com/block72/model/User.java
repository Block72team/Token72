package com.block72.model;

import javax.persistence.Id;

/**
 * Created by Jiateng on 10/19/18.
 */
public class User {
    @Id
    private Integer id;
    private String  username;
    private String  password;
}
