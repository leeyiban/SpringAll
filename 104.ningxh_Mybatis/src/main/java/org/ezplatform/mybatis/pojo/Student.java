package org.ezplatform.mybatis.pojo;

import lombok.*;

/**
 * @author:ningxh
 * @date:2023/5/26 18:05
 * @description: 一对多示例pojo
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
}
