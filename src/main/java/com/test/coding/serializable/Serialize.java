package com.test.coding.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Serialize {

	private static final Logger log = LoggerFactory.getLogger(Serialize.class);
	
	public static void main(String[] args) throws IOException{
	    
		Member member = new Member("김배민", "deliverykim@baemin.com", 25);
	    
	    byte[] serializedMember;
	    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	    	try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
	    		oos.writeObject(member);
	            // serializedMember -> 직렬화된 member 객체
	    		serializedMember = baos.toByteArray();
	    	}
	    }
	    
	    // 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
	    log.debug(Base64.getEncoder().encodeToString(serializedMember));
	}
}
