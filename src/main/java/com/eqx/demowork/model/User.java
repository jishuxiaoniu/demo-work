package com.eqx.demowork.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class User {

    private int id;
    private String name;
    private int age;
    private String address;
}
