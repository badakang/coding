package com.test.coding.replect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class JUnit4TestRunner {

	/**
	 * 요구사항3 - @MyTest 애노테이션으로 설정된 메소드 메서드 실행하기
	 * @throws Exception
	 */
	@Test
	public void run() throws Exception {
        Class<JUnit4Test> clazz = JUnit4Test.class;
        // TODO Junit4Test에서 @MyTest 애노테이션이 있는 메소드 실행
        Method[] methods = clazz.getMethods();
//        Method[] methods = clazz.getDeclaredMethods();
        List<Method> annotatedMethods = Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(MyTest.class))
                .collect(Collectors.toList());
        for (Method method : annotatedMethods) {
            method.invoke(clazz.newInstance());
        }
    }
}
