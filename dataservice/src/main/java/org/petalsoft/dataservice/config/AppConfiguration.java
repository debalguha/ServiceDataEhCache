package org.petalsoft.dataservice.config;

import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.Cache;

@Configuration
public class AppConfiguration {
	@Bean
	public Cache createCache(){
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cacheManagerFactoryBean.afterPropertiesSet();
		return cacheManagerFactoryBean.getObject().getCache("InstrumentCache");
	}
}
