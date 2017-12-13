package com.tuli.dmall.test.facade.user;

import com.alibaba.fastjson.JSONObject;
import com.tuli.dmall.facade.user.entity.Menu;
import com.tuli.dmall.facade.user.entity.User;
import com.tuli.dmall.facade.user.service.MenuQueryService;
import com.tuli.dmall.facade.user.service.UserQueryService;
import junit.framework.TestCase;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMenuQuery extends TestCase {

	ClassPathXmlApplicationContext context;

	MenuQueryService menuQueryService;

	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "consumer.xml" });
		super.setUp();
		menuQueryService = (MenuQueryService) context.getBean("menuQueryService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		context = null;
	}

	public void testA() {
		List<Menu> user = menuQueryService.getMenuList("1");
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
