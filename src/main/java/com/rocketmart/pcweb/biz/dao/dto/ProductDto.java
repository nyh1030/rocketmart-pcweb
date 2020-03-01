package com.rocketmart.pcweb.biz.dao.dto;

import lombok.Data;

@Data
public class ProductDto {

	private String productNm;
	private int brandSeq;
	private String cate1Cd;
	private String cate2Cd;
	private String cate3Cd;
	private String productUrl;
	private String productCapacity;
	private String productLineup;
	private String sellerNote;
	private String productContent;
	private int retailPrice;
	private String giveSampleYn;
	private String productAtrbt;
	private String productCrt;
	private String exportHst;
	private String tradingConditions;
	private String productFrontAfileSeq;
	private String productBackAfileSeq;
	private String productAspectAfileSeq;
	private String productShape1AfileSeq;
	private String productShape2AfileSeq;
	private String productOutside1AfileSeq;
	private String productOutside2AfileSeq;
	private String productEtc1AfileSeq;
	private String productEtc2AfileSeq;
}
