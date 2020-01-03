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

	/**
	 * 요구사항1 - 자바리플렉션  API 활용해 클래스 정보 출력하기
	 */
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
