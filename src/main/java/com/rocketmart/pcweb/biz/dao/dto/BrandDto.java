package com.rocketmart.pcweb.biz.dao.dto;

import lombok.Data;

@Data
public class BrandDto {

	private int brandSeq;
	private String brandNm;
	private int brandLogoFileSeq;
	private String brandOwnership;
	private String brandHomePageUrl;
	private String brandYouTubeUrl;
	private String brandInstagramUrl;
	private String brandCerify;
	private String brandIntroduction;
	private String regUsrId;
	private String updUsrId;
}
