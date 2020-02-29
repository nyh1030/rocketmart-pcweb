package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.records.TbOtherContactUsRecord;
import com.rocketmart.pcweb.biz.dao.repository.OtherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class OtherSvc {

	@Autowired
	private OtherRepository otherRepository;

	/**
	 * ContactUs 등록
	 * @param
	 * @return int
	 */
	@Transactional(rollbackFor = Exception.class)
	public int saveOneForContactUsInfo(TbOtherContactUsRecord contactUsRecord) {
		return otherRepository.saveOneForContactUsInfo(contactUsRecord);
	}

	/**
	 * ContactUs 목록 조회
	 * @param
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForContactUsInfo() {
		return otherRepository.findAllForContactUsInfo();

	}
}