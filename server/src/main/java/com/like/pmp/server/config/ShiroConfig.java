package com.like.pmp.server.config;

import com.like.pmp.server.shiro.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author like
 * @date 2022年04月26日 20:18
 */
@Configuration
public class ShiroConfig {

    /**
     * 安全器管理-管理所有的subject
     * @author like
     * @date 2022/5/7 16:00
     * @param userRealm
     * @return org.apache.shiro.mgt.SecurityManager
     */
    @Bean
    public SecurityManager securityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setRememberMeManager(null);
        return securityManager;
    }

    /**
     * 过滤链配置
     * @author like
     * @date 2022/5/7 16:00
     * @param securityManager
     * @return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilter  = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        //设定用户没有登录认证的跳转连接
        shiroFilter.setLoginUrl("/login.html");
        //设定用户没有授权时的跳转链接
        shiroFilter.setUnauthorizedUrl("/");
        //过滤器链配置
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/swagger/**", "anon");
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/statics/**", "anon");
        filterMap.put("/login.html", "anon");
        filterMap.put("/sys/login", "anon");
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/sys/captcha.jpg", "anon");
        filterMap.put("/**","authc");
        filterMap.put("/druid/*","anon");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }

    /**
     * 关于Shiro的Bean生命周期的管理
     * @author like
     * @date 2022/5/7 15:59
     * @param null
     * @return null
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
