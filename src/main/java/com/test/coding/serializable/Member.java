package com.test.coding.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private int age;
	private static final Logger log = LoggerFactory.getLogger(Member.class);

	public Member(String name, String email, int age) {
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return String.format("Member{name='%s', email='%s', age='%s'}", name, email, age);
	}

}
