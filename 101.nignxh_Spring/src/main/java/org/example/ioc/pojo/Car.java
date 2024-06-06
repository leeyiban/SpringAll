package org.example.ioc.pojo;

import lombok.*;

/**
 * @author:ningxh
 * @date:2023/5/27 13:00
 * @description: springIOC javaBean
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String type;
    private String carNo;
    private String name;

    public static Integer staticFun() {
        System.out.println("!1111111");
        return 3;
    }
}
