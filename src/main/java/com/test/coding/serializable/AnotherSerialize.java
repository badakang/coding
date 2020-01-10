package com.test.coding.serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnotherSerialize {

	private static final Logger log = LoggerFactory.getLogger(AnotherSerialize.class);

	public static void main(String[] args) {
		toCSV();
		toJSON();
	}

	private static void toCSV() {
		Member member = new Member("김배민", "deliverykim@baemin.com", 25);
		// member객체를 csv로 변환
		String csv = String.format("%s,%s,%d", member.getName(), member.getEmail(), member.getAge());
		log.debug(csv);
	}

	private static void toJSON() {
		Member member = new Member("김배민", "deliverykim@baemin.com", 25);
		// member객체를 csv로 변환
		String json = String.format("{\"name\":\"%s\",\"email\":\"%s\",\"age\":%d}", member.getName(),
				member.getEmail(), member.getAge());
		log.debug(json);
	}

}
