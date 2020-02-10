package com.rocketmart.pcweb.biz.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandDto {

	private String brandId;
	private String brandName;
}
