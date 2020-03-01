package com.rocketmart.pcweb.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ApiBusiness {

	OK("OK", "성공"),
	SAVE("SAVE", "저장"),
	FAIL("FAIL", "실패");

	private String code;
	private String msg;
}
