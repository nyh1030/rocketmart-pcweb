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
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForCategoryMenu() {
		return categoryRepository.findAllForCategoryMenu();

	}
}