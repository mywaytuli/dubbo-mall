package com.tuli.dmall.test.facade.user;

import com.tuli.dmall.common.utils.CryptUtil;
import com.tuli.dmall.facade.user.entity.User;
import com.tuli.dmall.facade.user.service.UserManagerService;
import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestUserManager extends TestCase {

	ClassPathXmlApplicationContext context;

	UserManagerService userManagerService;

	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] { "consumer.xml" });
		super.setUp();
		userManagerService = (UserManagerService) context.getBean("userManagerService");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		context = null;
	}

	public void testCreateAccount() {
		User user = new User();
		user.setAccount("tuli2");
		user.setName("涂立4");
		user.setPwd(CryptUtil.sha1("123456"));
		boolean result = userManagerService.insert(user);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(result);
	}
}
