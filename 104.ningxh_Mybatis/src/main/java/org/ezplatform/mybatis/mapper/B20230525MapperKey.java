package org.ezplatform.mybatis.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.ezplatform.mybatis.pojo.User;

import java.util.Map;

/**
 * @author:ningxh
 * @date:2023/5/25 21:11
 * @description: @MapKey可以把返回的结果转换为map对象，
 *                并指定一个属性做为key（ key是唯一的，所以指定的属性值要唯一 ）
 */
public interface B20230525MapperKey {
    @MapKey("lastName")
    public Map<String, User> queryUserMap();

}
