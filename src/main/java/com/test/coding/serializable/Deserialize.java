package com.test.coding.serializable;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deserialize {

	private static final Logger log = LoggerFactory.getLogger(Deserialize.class);

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 직렬화 예제에서 생성된 base64 데이터
		String base64Member = "rO0ABXNyACNjb20udGVzdC5jb2Rpbmcuc2VyaWFsaXphYmxlLk1lbWJlcvWj9z8CAw8KAgADSQADYWdlTAAFZW1haWx0ABJMamF2YS9sYW5nL1N0cmluZztMAARuYW1lcQB+AAF4cAAAABl0ABZkZWxpdmVyeWtpbUBiYWVtaW4uY29tdAAJ6rmA67Cw66+8";
		byte[] serializedMember = Base64.getDecoder().decode(base64Member);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				// 역직렬화된 Member 객체를 읽어온다.
				Object objectMember = ois.readObject();
				Member member = (Member) objectMember;
				log.debug(member.toString());
				//Member{name='김배민', email='deliverykim@baemin.com', age='25'}
			}
		}
	}
}
