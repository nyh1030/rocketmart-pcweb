package com.rocketmart.pcweb.biz.dao.dto;

import lombok.Data;

@Data
public class ProductDto {

	private int productSeq;
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
	private String fobSeq;
	private String giveSampleYn;
	private String productAtrbt;
	private String productCrt;
	private String exportHst;
	private String tradingConditions;
	private int productFrontAfileSeq;
	private int productBackAfileSeq;
	private int productAspectAfileSeq;
	private int productShape1AfileSeq;
	private int productShape2AfileSeq;
	private int productOutside1AfileSeq;
	private int productOutside2AfileSeq;
	private int productEtc1AfileSeq;
	private int productEtc2AfileSeq;
	private String rangeStart;
	private String rangeEnd;
	private String tradingPrice;
	private String supplyRate;
}
