package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.records.TbCateMstRecord;
import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.dao.repository.CategoryRepository;
import com.rocketmart.pcweb.biz.dao.repository.MemberRepository;
import com.rocketmart.pcweb.common.file.FileUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class CategorySvc {

	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * 메인 > Category 목록 메뉴
	 * @param cate1Cd
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForCategoryMenu(String cate1Cd) {
		return categoryRepository.findAllForCategoryMenu(cate1Cd);
	}

	/**
	 * 메인 > Category 목록 조회
	 * @param
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForCategoryPrdInfo(TbCateMstRecord tbCateMstRecord, int startIndex, int pageSize) {
		return categoryRepository.findAllForCategoryPrdInfo(tbCateMstRecord, startIndex, pageSize);
	}

	/**
	 * 메인 > Brands 목록 조회
	 * @param
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForCategoryWithBrandPrdInfo(TbCateMstRecord tbCateMstRecord, int brandSeq) {
		return categoryRepository.findAllForCategoryWithBrandPrdInfo(tbCateMstRecord, brandSeq);
	}

	public List<Map<String, Object>> findAll() {
		return categoryRepository.findAll();
	}

	public List<Map<String, Object>> findAllByBrandSeq(int brandSeq) {
		return categoryRepository.findAllByBrandSeq(brandSeq);
	}

	public int findCategoryPrdInfoCnt(TbCateMstRecord tbCateMstRecord) {
		return categoryRepository.findCategoryPrdInfoCnt(tbCateMstRecord);
	}
}