package com.rocketmart.pcweb.common;

import org.apache.tomcat.util.codec.binary.Base64;
import org.jooq.Condition;
import org.jooq.impl.DSL;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class CommonUtils {

	public static String convertDataToBase64(String targetValue) {
		return new String(Base64.encodeBase64(targetValue.getBytes()));
	}

	public static String getFileId() {
		return String.format("%s_%s", DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()), UUID.randomUUID());
	}

	public static Condition isNotEmpty(Object value, Condition condition){
		if(value == null || "".equals(value)){
			return DSL.trueCondition();
		}
		return condition;
	}
}
