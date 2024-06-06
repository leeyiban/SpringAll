package org.ezplatform.mybatis.pojo;

import lombok.*;

import java.util.List;

/**
 * @author:ningxh
 * @date:2023/5/26 18:06
 * @description: 一对多示例pojo
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer id;
    private String name;
    private List<Student> studentList;
}
