package com.test.coding.replect;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JUnit4Test {
	private static final Logger log = LoggerFactory.getLogger(JUnit3Test.class);

	@MyTest
	public void test1() {
		log.debug("Running Test1.............");
	}

	@MyTest
	public void test2() {
		log.debug("Running Test2.............");
	}

	public void three() {
		log.debug("Running Test3.............");
	}
}
