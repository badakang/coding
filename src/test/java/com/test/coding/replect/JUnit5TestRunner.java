package com.test.coding.replect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JUnit5TestRunner {

	private static final Logger logger = LoggerFactory.getLogger(JUnit5TestRunner.class);

	/**
	 * 요구사항4 - private field에 값 할당
	 * @throws Exception
	 */
	@Test
	public void fieldAccess() throws Exception {
		Class<Student> student = Student.class;
		Field nameField = student.getDeclaredField("name");
		Field ageField = student.getDeclaredField("age");

		nameField.setAccessible(true);
		ageField.setAccessible(true);

		Student thisStudent = new Student(); // (주의)객체를 만들어줘야함!!
		nameField.set(thisStudent, "브래드와 숲");
		ageField.set(thisStudent, 20);

		logger.debug("student : {}", thisStudent);
	}

	/**
	 * 요구사항5 - 인자를 가진 생성자의 인스턴스 생성
	 * @throws Exception
	 */
	@Test
    public void makeConstructor() throws Exception {
        Class<?> clazz = Class.forName("com.test.coding.replect.Student");
        for (Constructor declaredConstructor : clazz.getDeclaredConstructors()) {
            Object user = declaredConstructor.newInstance("브래드", 20);
            logger.debug("user : {}", user);
        }
    }
}
