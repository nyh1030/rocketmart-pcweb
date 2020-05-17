package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.records.TbBrandMstRecord;
import com.rocketmart.jooq.tables.records.TbPrdFobHstRecord;
import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.dao.repository.BrandRepository;
import com.rocketmart.pcweb.common.api.ApiResponse;
import com.rocketmart.pcweb.common.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BrandSvc {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private FileUtils fileUtils;

	public List<Map<String, Object>> findAll() {
		return brandRepository.findAll();
	}

	public List<Map<String, Object>> findAllForAfile(String regUsrId) {
		return brandRepository.findAllForAfile(regUsrId);
	}

	public Map<String, Object> findByBrandSeq(int brandSeq) {
		return brandRepository.findByBrandSeq(brandSeq);
	}

	public List<Map<String, Object>> findBrandByUsrId() {
		return brandRepository.findBrandByUsrId("ADMIN");
	}

	public Timestamp findLastUpdatedDateTime(String regUsrId) {
		return brandRepository.findLastUpdatedDateTime(regUsrId);
	}

	@Transactional(rollbackFor = Exception.class)
	public String saveBrandUpload(MultipartFile file, String themaRelmCd, String regMenuPart) {
		return fileUtils.uploadFile(file, themaRelmCd, regMenuPart);
	}

	@Transactional(rollbackFor = Exception.class)
	public int saveOneForBrandInfo(BrandDto brandDto) {
		return brandRepository.saveOneForBrandInfo(brandDto);
	}

	@Transactional(rollbackFor = Exception.class)
	public int updateOneForBrandInfo(BrandDto brandDto) {
		return brandRepository.updateOneForBrandInfo(brandDto);
	}

	public Map<String, Object> findAllForAlPaBet() {
		List<Map<String, Object>> BRAND_A = new ArrayList<>();
		List<Map<String, Object>> BRAND_B = new ArrayList<>();
		List<Map<String, Object>> BRAND_C = new ArrayList<>();
		List<Map<String, Object>> BRAND_D = new ArrayList<>();
		List<Map<String, Object>> BRAND_E = new ArrayList<>();
		List<Map<String, Object>> BRAND_F = new ArrayList<>();
		List<Map<String, Object>> BRAND_G = new ArrayList<>();
		List<Map<String, Object>> BRAND_H = new ArrayList<>();
		List<Map<String, Object>> BRAND_I = new ArrayList<>();
		List<Map<String, Object>> BRAND_J = new ArrayList<>();
		List<Map<String, Object>> BRAND_K = new ArrayList<>();
		List<Map<String, Object>> BRAND_L = new ArrayList<>();
		List<Map<String, Object>> BRAND_M = new ArrayList<>();
		List<Map<String, Object>> BRAND_N = new ArrayList<>();
		List<Map<String, Object>> BRAND_O = new ArrayList<>();
		List<Map<String, Object>> BRAND_P = new ArrayList<>();
		List<Map<String, Object>> BRAND_Q = new ArrayList<>();
		List<Map<String, Object>> BRAND_R = new ArrayList<>();
		List<Map<String, Object>> BRAND_S = new ArrayList<>();
		List<Map<String, Object>> BRAND_T = new ArrayList<>();
		List<Map<String, Object>> BRAND_U = new ArrayList<>();
		List<Map<String, Object>> BRAND_V = new ArrayList<>();
		List<Map<String, Object>> BRAND_W = new ArrayList<>();
		List<Map<String, Object>> BRAND_X = new ArrayList<>();
		List<Map<String, Object>> BRAND_Y = new ArrayList<>();
		List<Map<String, Object>> BRAND_Z = new ArrayList<>();
		List<Map<String, Object>> BRAND_ETC = new ArrayList<>();


		brandRepository.findAllForAlPaBet().forEach(brandInfo -> {
			String brandNm = (String) brandInfo.get("BRAND_NM");

			if (brandNm.toUpperCase().startsWith("A")) BRAND_A.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("B")) BRAND_B.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("C")) BRAND_C.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("D")) BRAND_D.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("E")) BRAND_E.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("F")) BRAND_F.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("G")) BRAND_G.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("H")) BRAND_H.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("I")) BRAND_I.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("J")) BRAND_J.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("K")) BRAND_K.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("L")) BRAND_L.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("M")) BRAND_M.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("N")) BRAND_N.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("O")) BRAND_O.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("P")) BRAND_P.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("Q")) BRAND_Q.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("R")) BRAND_R.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("S")) BRAND_S.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("T")) BRAND_T.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("U")) BRAND_U.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("V")) BRAND_V.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("W")) BRAND_W.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("X")) BRAND_X.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("Y")) BRAND_Y.add(brandInfo);
			else if (brandNm.toUpperCase().startsWith("Z")) BRAND_Z.add(brandInfo);
			else BRAND_ETC.add(brandInfo);

		});

		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("BRAND_A", BRAND_A);
		returnMap.put("BRAND_B", BRAND_B);
		returnMap.put("BRAND_C", BRAND_C);
		returnMap.put("BRAND_D", BRAND_D);
		returnMap.put("BRAND_E", BRAND_E);
		returnMap.put("BRAND_F", BRAND_F);
		returnMap.put("BRAND_G", BRAND_G);
		returnMap.put("BRAND_H", BRAND_H);
		returnMap.put("BRAND_I", BRAND_I);
		returnMap.put("BRAND_J", BRAND_J);
		returnMap.put("BRAND_K", BRAND_K);
		returnMap.put("BRAND_L", BRAND_L);
		returnMap.put("BRAND_M", BRAND_M);
		returnMap.put("BRAND_N", BRAND_N);
		returnMap.put("BRAND_O", BRAND_O);
		returnMap.put("BRAND_P", BRAND_P);
		returnMap.put("BRAND_Q", BRAND_Q);
		returnMap.put("BRAND_R", BRAND_R);
		returnMap.put("BRAND_S", BRAND_S);
		returnMap.put("BRAND_T", BRAND_T);
		returnMap.put("BRAND_U", BRAND_U);
		returnMap.put("BRAND_V", BRAND_V);
		returnMap.put("BRAND_W", BRAND_W);
		returnMap.put("BRAND_X", BRAND_X);
		returnMap.put("BRAND_Y", BRAND_Y);
		returnMap.put("BRAND_Z", BRAND_Z);
		returnMap.put("BRAND_ETC", BRAND_ETC);
		return returnMap;
	}

	public String deleteBrand(int brandSeq) {
		return brandRepository.deleteBrand(brandSeq) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode();
	}

	/**
	 * 브랜드 목록(어드민)
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForAdminBrandInfo(String schCompanyNm, String schMemId, String schBrandNm, int startIndex, int pageSize) {
		return brandRepository.findAllForAdminBrandInfo(schCompanyNm, schMemId, schBrandNm, startIndex, pageSize);
	}

	public int findAllCnt(String schCompanyNm, String schMemId, String schBrandNm) {
		return brandRepository.findAllCnt(schCompanyNm, schMemId, schBrandNm);
	}

	public List<Map<String, Object>> findAllForAfileWithBrandSeq(int brandSeq) {
		return brandRepository.findAllForAfileWithBrandSeq(brandSeq);
	}

	public int findPendingCnt(String schProductNm, String schBrandNm) {
		return brandRepository.findPendingCnt(schProductNm, schBrandNm);
	}

	public int findForRegBrandCnt() {
		return brandRepository.findForRegBrandCnt();
	}

	public int findForRegPrdCnt() {
		return brandRepository.findForRegPrdCnt();
	}

	public int findForAppPrdCnt() {
		return brandRepository.findForAppPrdCnt();
	}

	public int findForStaPrdCnt() {
		return brandRepository.findForStaPrdCnt();
	}

	public int findAdminBrandCnt(String schCompanyNm, String schMemId, String schBrandNm) {
		return brandRepository.findAdminBrandCnt(schCompanyNm, schMemId, schBrandNm);
	}
}