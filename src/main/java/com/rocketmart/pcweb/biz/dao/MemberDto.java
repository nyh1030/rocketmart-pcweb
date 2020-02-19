package com.rocketmart.pcweb.biz.dao;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MemberDto {

	private int memSeq;
	private String role;
	private String memId;
	private String memNm;
	private String memPw;
	private String tel;
	private String companyNm;
	private String companyUrl;
	private int bsnsRgstrSeq;
	private String regUsrId;
	private Date regTs;
	private String updUsrId;
	private Date updTs;

}
