package com.eqx.demowork.model;

import lombok.*;

import java.io.Serializable;

/**
 * @author duanhuazhen
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private int id;
    private String name;
    private int age;
    private String address;
}
