package org.ezplatform.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.ezplatform.mybatis.pojo.Lock;
import org.ezplatform.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface A20220725_UserMapper {

	/**
	* * MyBatis面向接口编程的两个一致：
	 * 1。映射文件namespace和Mapper接口的全类名一致
	 * 2。映射文件中sql语句的id和mapper接口中的方法一致
	 */

	/**
	 * 添加用户
	 */
	public User queryUserById( String param);


	public List<User> queryUsers();

	//他还能主动分析对象中的属性,并且和#{}中的名称进行匹配
	public int saveUser(User user);
	public int saveUse2r(User user);

	public int updateUser(User user);

	public int deleteUserById(Integer id);

	//传递多个参数,并且使用Param注解给它起个别名,方便#{name} 使用
	// Param 标注的参数 可以在sql中用#{name} 来表示注解参数name的值
	public List<User> queryUserByNameAndId(@Param("name") String lastName, @Param("id") Integer id);


	// 传递一个Map对象作为参数
	// 只要保证Map中的key和#{name}中的名称保持一致就可以了
	public List<User> queryUserByMap(Map<String, Object> paramMap);


	// 模糊查询
	//注意!!!
	// last_name like '%${name}%'
	//这里使用的是 ${}  是$$$$ 不是####  %${name}%!
	public List<User> queryUserLikeName(@Param("name") String name);



	//亦或者 想使用#{} 那就用concat拼接函数去使用
	public List<User> queryUserLikeName2(@Param("name") String name);



	// 懒加载 例如A对象中含有B对象   查询A的时候可以通过配置文件,分成查询两个对象  当B对象没有使用到的时候,开启了懒加载,name查询B的语句就不会执行
	/**
	 * 延迟加载在一定程序上可以减少很多没有必要的查询。给数据库服务器提升性能上的优化。
	 * 要启用延迟加载，需要在mybatis-config.xml配置文件中，添加如下两个全局的settings配置。
	 *
	 * 		<!-- 打开延迟加载的开关 -->
	 *      <setting name="lazyLoadingEnabled" value="true" />
	 *      <!-- 将积极加载改为消极加载  按需加载 -->
	 * 		<setting name="aggressiveLazyLoading" value="false"/>
	 */
	public Lock queryLockByIdLazy(Integer id);
}
