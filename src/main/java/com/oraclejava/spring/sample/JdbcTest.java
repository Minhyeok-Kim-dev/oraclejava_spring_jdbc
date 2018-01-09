package com.oraclejava.spring.sample;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTest {

	private static ApplicationContext ctx;
	private static JdbcTemplate jdbcTemplate;
	
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = ctx.getBean(JdbcTemplate.class);
	}
	
	public static void main(String[] args) {
		String sql = "SELECT * FROM members";
		List<Map<String, Object>> members = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> member : members) {
			String memberId = member.get("MEMBERID").toString();
			String passwd = member.get("PASSWD").toString();
			
			System.out.println(memberId + "//" + passwd);
		}
	}

}
