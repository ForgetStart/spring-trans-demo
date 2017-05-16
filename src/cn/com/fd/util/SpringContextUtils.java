package cn.com.fd.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 类名: com.dns.common.util.SpringContextUtils
 * <p>
 * 描述: Spring框架的应用上下文环境工具类，本类继承了org.springframework.context.ApplicationContextAware接口
 * </p>
 * 日期: 2013年11月29日 下午5:15:19
 * 
 * @author 蓝斌
 * @version V1.0
 * @since JDK1.5
 */
@Component("springContextUtil")
public class SpringContextUtils implements ApplicationContextAware {

	/**
	 * 描述: Spring应用上下文环境
	 */
	private static ApplicationContext applicationContext;

	/**
	 * @return applicationContext 请参考applicationContext字段的描述
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtils.applicationContext = applicationContext;
	}

	/**
	 * <p>
	 * 描述: 通过Spring框架的应用上下文环境获取指定注册名字的bean对象
	 * </p>
	 * 
	 * @param name
	 *            bean实例的注册名字
	 * @return 指定注册名字的bean的实例
	 * @throws BeansException
	 *             org.springframework.beans.BeansException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T) applicationContext.getBean(name);
	}

	/**
	 * <p>
	 * 描述: 通过Spring框架的应用上下文环境获取指定类型的bean对象
	 * </p>
	 * 
	 * @param clz
	 *            要获取的bean对象的类型
	 * @return 指定类型的bean的实例
	 * @throws BeansException
	 *             org.springframework.beans.BeansException
	 */
	public static <T> T getBean(Class<T> clz) throws BeansException {
		return (T) applicationContext.getBean(clz);
	}

	/**
	 * <p>
	 * 描述: 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
	 * </p>
	 * 
	 * @param name
	 *            bean实例的注册名字
	 * @return true-包含匹配的bean定义 false-不包含匹配的bean定义
	 */
	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	/**
	 * <p>
	 * 描述: 判断以给定名字注册的bean定义是一个singleton还是一个prototype， 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常
	 * </p>
	 * 
	 * @param name
	 *            bean实例的注册名字
	 * @return true-bean定义是singleton false-bean定义是prototype
	 * @throws NoSuchBeanDefinitionException
	 *             如果与给定名字相应的bean定义没有被找到，将会抛出org.springframework.beans.factory.NoSuchBeanDefinitionException异常
	 */
	public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
		return applicationContext.isSingleton(name);
	}

	/**
	 * <p>
	 * 描述: 获取指定注册名字的bean的类型
	 * </p>
	 * 
	 * @param name
	 *            bean实例的注册名字
	 * @return 注册对象的类型
	 * @throws NoSuchBeanDefinitionException
	 *             如果与给定名字相应的bean定义没有被找到，将会抛出org.springframework.beans.factory.NoSuchBeanDefinitionException异常
	 */
	public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
		return applicationContext.getType(name);
	}

	/**
	 * <p>
	 * 描述: 如果给定的bean名字在bean定义中有别名，则返回这些别名
	 * </p>
	 * 
	 * @param name
	 *            bean实例的注册名字
	 * @return 别名的数组
	 * @throws NoSuchBeanDefinitionException
	 *             如果与给定名字相应的bean定义没有被找到，将会抛出org.springframework.beans.factory.NoSuchBeanDefinitionException异常
	 */
	public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
		return applicationContext.getAliases(name);
	}

}
