package com.rocketmart.pcweb.biz.svc;

import com.rocketmart.pcweb.biz.dao.dto.BrandDto;
import com.rocketmart.pcweb.biz.dao.repository.BrandRepository;
import com.rocketmart.pcweb.common.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

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
}