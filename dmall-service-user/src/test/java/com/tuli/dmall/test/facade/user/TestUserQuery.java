package com.tuli.dmall.test.facade.user;

import java.util.HashMap;
import java.util.Map;

import com.tuli.dmall.facade.user.entity.User;
import com.tuli.dmall.facade.user.service.UserQueryService;
import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.alibaba.fastjson.JSONObject;

public class TestUserQuery extends TestCase {

	ClassPathXmlApplicationContext context;

	UserQueryService userQueryService;

	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "consumer.xml" });
		super.setUp();
		userQueryService = (UserQueryService) context.getBean("userQueryService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		context = null;
	}

	public void testA() {
		User user = userQueryService.getUserByAccount("tuli");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(JSONObject.toJSONString(user));
	}
	
	public static void main(String[] args){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("r1_MerchantNo", true);
		map.put("r2_RefundOrderNo", 123L);
		map.put("r3_RefundAmount", "abcd");
		
		System.out.println(JSONObject.toJSONString(map));
	}
}
