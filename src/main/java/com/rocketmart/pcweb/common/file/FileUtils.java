package com.rocketmart.pcweb.common.file;

import com.rocketmart.pcweb.common.CommonUtils;
import com.rocketmart.pcweb.common.api.ApiBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class FileUtils {

	@Autowired
	private FileRepository fileRepository;

	@Value("${afile.host}")
	private String host;
	@Value("${afile.path}")
	private String filePath;

	public String uploadFile(MultipartFile file, String themaRelmCd, String regMenuPart) {
		int afileSeq = this.fileRepository.findOneForMaxSeq() + 1;
		boolean isSuccess = this.saveFile(file, afileSeq, 1, themaRelmCd, regMenuPart).equals(ApiBusiness.OK.getCode());
		return isSuccess ? String.valueOf(afileSeq) : "0";
	}

	public String uploadFiles(MultipartFile[] files, String themaRelmCd, String regMenuPart) {
		AtomicInteger afileNo = new AtomicInteger(1);
		int afileSeq = this.fileRepository.findOneForMaxSeq() + 1;
		Arrays.stream(files).forEach(file -> {
			this.saveFile(file, afileSeq, afileNo.getAndAdd(1), themaRelmCd, regMenuPart);
		});
		return String.valueOf(afileSeq);
	}

	public String saveFile(MultipartFile file, int afileSeq, int afileNo, String themaRelmCd, String regMenuPart) {
		int resultCnt = 0;
		String fullFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
		String orgnFileNm = fullFileName.substring(0, fullFileName.lastIndexOf("."));
		String ext = fullFileName.substring(fullFileName.lastIndexOf("."));
		String regFileNm = CommonUtils.getFileId();

		this.makeDirectoryIfNotExists(filePath.concat(themaRelmCd)); // 디렉토리가 없을 경우 생성

		Path targetLocation = Paths.get(filePath.concat(themaRelmCd).concat("/")).toAbsolutePath().normalize().resolve(regFileNm.concat(ext));
		try {
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			String urlPathCd = host.concat("/afiles/").concat(themaRelmCd).concat("/").concat(regFileNm).concat(ext);
			resultCnt = this.fileRepository.saveInfoForFile(afileSeq, afileNo, orgnFileNm, urlPathCd, targetLocation.toString(), regFileNm, ext, (int) file.getSize(), themaRelmCd, regMenuPart);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultCnt > 0 ? ApiBusiness.OK.getCode() : ApiBusiness.FAIL.getCode();
	}

	public Resource loadFileAsResource(String fileName, String uploadDirPath) {
		Resource resource = null;
		try {
			resource = new UrlResource(Paths.get(uploadDirPath).toAbsolutePath().normalize().resolve(fileName).normalize().toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return resource;
	}

	public void makeDirectoryIfNotExists(String filePath) {
		File directoryPath = new File(filePath);
		if (!directoryPath.exists()) {
			directoryPath.mkdir();
		}
	}
}