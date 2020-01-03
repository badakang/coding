package com.test.coding.replect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JUnit3TestRunner {

	private static final Logger log = LoggerFactory.getLogger(JUnit3TestRunner.class);

	@Test
	public void run() throws Exception {
		Class<JUnit3Test> clazz = JUnit3Test.class;
		// TODO Junit3Test에서 test로 시작하는 메소드 실행
		Method[] methods = clazz.getDeclaredMethods();
		methods = Arrays.stream(methods).filter(method -> startWithTest(method.getName())).toArray(Method[]::new);

		for (Method method : methods) {
			log.debug("test로 시작하는 메서드 : {}", method);
			method.invoke(clazz.newInstance()); // 해당 메서드 실행
		}
	}

	private boolean startWithTest(String name) {
		return name.startsWith("test");
	}
}
