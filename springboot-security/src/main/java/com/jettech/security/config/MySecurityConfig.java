package com.jettech.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		
		//定制授权规则
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/level1/**").hasRole("VIP1")
				.antMatchers("/level2/**").hasRole("VIP2")
				.antMatchers("/level3/**").hasRole("VIP3");
		
		//开启自动配置的登录功能，效果，如果没有权限就显示登录页面
		/**
		 * 1，生成一个自动登录页
		 * 2，/login请求来到登录页
		 * 3，如果认证失败重定向到/login?error
		 */
		http.formLogin().usernameParameter("user").passwordParameter("pwd")
				.loginPage("/userlogin");
		
		//开启自动配置的注销功能
		/**
		 *1、访问 /logout 表示用户注销，清空session
        *2、注销成功会返回 /login?logout 页面；
        *4、默认post形式的 /login代表处理登陆
        *5、一但定制loginPage；那么 loginPage的pos
		 */
		http.logout().logoutSuccessUrl("/");	//注销成功后来到首页
		
		//开启“记住我”功能
        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie
		http.rememberMe().rememberMeParameter("remeber");
	}
	
	//定义认证规则
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		//auth.jdbcAuthentication()	查询数据库
		//内存中的数据
		auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1","VIP2")
															.and().withUser("lisi").password("123456").roles("VIP2","VIP3")
															.and().withUser("wangwu").password("123456").roles("VIP3","VIP1");
	}
}