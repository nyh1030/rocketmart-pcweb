package com.rocketmart.pcweb.biz.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDto {

	private String memId;
	private String memNm;

}
