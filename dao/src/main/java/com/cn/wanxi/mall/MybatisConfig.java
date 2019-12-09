package com.cn.wanxi.mall;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * MyBatis的配置文件
 * @author Lucio
 */
@SpringBootConfiguration
public class MybatisConfig {

	/**
	 * 创建一个SqlSessionFactoryBean  MyBatis plus---> 分頁插件
	 */
	@Bean
	@ConditionalOnMissingBean
/**
	 条件注解: 当spring容器里没有指定的Bean的情况下创建该对象
*/
	public MybatisSqlSessionFactoryBean getSqlSessionFactory(DataSource ds) {
		MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
		// 设置数据源
		
		sqlSessionFactoryBean.setDataSource(ds);
		// 设置mybatis的主配置文件----->当项目中有Mybatis总体配置文件时，使用这种方式加载
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource mybatisConfigXml = resolver.getResource("mybatis_config.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);

		//给实体类别名
		sqlSessionFactoryBean.setTypeAliasesPackage("com.cn.wanxi.mall.bean");
		
		return sqlSessionFactoryBean;
	}
	
}
