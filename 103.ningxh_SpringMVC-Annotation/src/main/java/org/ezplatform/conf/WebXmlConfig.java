package org.ezplatform.conf;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * 创建初始化类，代替web.xml
 */
public class WebXmlConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * 在Servlet3.0环境中，容器会在类路径中查找实现javax.servlet.ServletContainerInitializer接口的类，
	 * 如果找到的话就用它来配置Servlet容器。
	 * Spring提供了这个接口的实现，名为SpringServletContainerInitializer，
	 * 这个类反过来又会查找实现WebApplicationInitializer的类并将配置的任务交给它们来完成。
	 * Spring3.2引入了一个便利的WebApplicationInitializer基础实现，
	 * 名为AbstractAnnotationConfigDispatcherServletInitializer，
	 * 当我们的类扩展了AbstractAnnotationConfigDispatcherServletInitializer并将其部署到Servlet3.0容器的时候，
	 * 容器会自动发现它，并用它来配置Servlet上下文。
	 */



	/**
	 * 指定spring的配置类
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{SpringConfig.class};
	}
	/**
	 * 指定SpringMVC的配置类
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{MvcConfig.class};
	}

	/**
	 * 指定DispatcherServlet的映射规则，即url-pattern
	 * @return
	 */

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/anno/test"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceRequestEncoding(true);
		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		return new Filter[]{encodingFilter, hiddenHttpMethodFilter};
	}
}
