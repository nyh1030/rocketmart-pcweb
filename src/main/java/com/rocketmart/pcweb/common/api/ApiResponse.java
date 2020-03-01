package com.rocketmart.pcweb.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ApiResponse {

	SUCCESS("200", "성공", "정상적으로 처리되었습니다."),
	FAIL("-1", "실패", "정상적으로 처리되지 않았습니다.");

	private String code;
	private String msg;
	private String desc;

}
