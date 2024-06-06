package org.ezplatform.mybatis.mapper;

import org.ezplatform.mybatis.pojo.Lock;

public interface E20230526LockMapper {
    /**
     * 根据lock的id查询lock信息
     */
    public Lock queryLockById(Integer id);
}
