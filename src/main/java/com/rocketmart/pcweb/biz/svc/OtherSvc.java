package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.jooq.tables.records.TbContactUsRecord;
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
	public int saveOneForContactUsInfo(TbContactUsRecord contactUsRecord) {
		return otherRepository.saveOneForContactUsInfo(contactUsRecord);
	}

	/**
	 * ContactUs 목록 조회
	 * @param
	 * @return List<Map<String, Object>>
	 */
	public List<Map<String, Object>> findAllForContactUsInfo(TbContactUsRecord tbContactUsRecord) {
		return otherRepository.findAllForContactUsInfo(tbContactUsRecord);
	}

	/**
	 * ContactUs 상세정보 조회
	 * @param contactSeq
	 * @return mmbrMap
	 */
	public Map<String, Object> findOneForContactUsInfo(int contactSeq) {
		return otherRepository.findOneForContactUsInfo(contactSeq);
	}
}