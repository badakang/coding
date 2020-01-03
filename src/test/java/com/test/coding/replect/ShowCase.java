package com.test.coding.replect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.test.coding.App;

public class ShowCase {
	private static final Logger logger = LoggerFactory.getLogger(ShowCase.class);

	@Test
	public void showClass() {
		Class<Student> clazz = Student.class;
		logger.debug(clazz.getName());
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			logger.debug("메서드 : {}", method.getName());
		}

		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			logger.debug("생성자 : {}", constructor.getName());
		}

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			logger.debug("필드 : {}", field.getName());
		}

	}
}
