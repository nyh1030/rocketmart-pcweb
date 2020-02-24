package com.rocketmart.pcweb.common;

import org.apache.tomcat.util.codec.binary.Base64;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommonUtils {

	public static String convertDataToBase64(String targetValue) {
		return new String(Base64.encodeBase64(targetValue.getBytes()));
	}

	public static String getFileId(String fileName) {
		return String.format("%s_%s", DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now()), CommonUtils.convertDataToBase64(fileName));
	}
}
