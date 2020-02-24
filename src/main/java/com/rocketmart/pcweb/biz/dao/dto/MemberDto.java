package com.rocketmart.pcweb.biz.dao.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class MemberDto {

	private	String username;
	private	String password;
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
