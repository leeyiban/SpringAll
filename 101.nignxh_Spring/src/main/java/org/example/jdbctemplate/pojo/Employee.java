package org.example.jdbctemplate.pojo;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author:ningxh
 * @date:2023/5/28 10:10
 * @description: some description
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private BigDecimal salary;
}
