package org.ezplatform.mybatis.pojo;

import lombok.*;

/**
 * @author:ningxh
 * @date:2023/5/26 10:52
 * @description: some description
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Key {
    private Integer id;
    private String name;
    private Lock lock;
}
