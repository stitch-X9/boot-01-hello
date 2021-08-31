package com.atguigu.boot.bean;


import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private String name;
    private Integer age;
}
