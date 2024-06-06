package org.ezplatform.mybatis.mapper;

import org.ezplatform.mybatis.pojo.Key;

/**
 * @author:ningxh
 * @date:2023/5/26 17:50
 * @description: 延迟加载
 */
public interface E20230526KeyMapper {
   /*   懒加载 例如A对象中含有B对象   查询A的时候可以通过配置文件,分成查询两个对象  当B对象没有使用到的时候,开启了懒加载,name查询B的语句就不会执行

    延迟加载在一定程序上可以减少很多没有必要的查询。给数据库服务器提升性能上的优化。
    要启用延迟加载，需要在mybatis-config.xml配置文件中，添加如下两个全局的settings配置。

    打开延迟加载的开关
            <setting name="lazyLoadingEnabled" value="true" />
    将积极加载改为消极加载  按需加载
             <setting name="aggressiveLazyLoading" value="false"/>
    */



    /**
     * 这里只是简单地把key中的数据查询出来<br/>
     * 然后当需要用到Lock数据的时候再调用另一个查询去查lock的数据
     * @param id
     * @return
     */
    public Key queryKeyByIdForSimple(Integer id);
}
