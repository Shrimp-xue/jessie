package com.jessie.util;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/**/*.xml")
public class BaseTest extends AbstractJUnit4SpringContextTests {

	@Before
	public void before() {
		System.out.println("开始测试...");
	}

	@After
	public void after() {
		System.out.println("测试完成...");
	}

}
