package com.rocketmart.pcweb.common.file;

import com.rocketmart.pcweb.common.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Component
public class FileUtils {

	@Autowired
	private FileRepository fileRepository;

	public String uploadFile(MultipartFile file, HttpServletRequest request, String themaRelmCd, String regMenuPart) {
		//String path = request.getSession().getServletContext().getRealPath("resources/fileUpload");
		String path = "C:\\rocketmart-pcweb\\src\\main\\resources\\static\\afiles\\".concat(themaRelmCd);

		/*String fileDownloadPath = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(fileName)
				.toUriString();*/

		return this.saveFile(file, 1, path, themaRelmCd, regMenuPart);
	}

	public String saveFile(MultipartFile file, int afileNo, String uploadDirPath, String themaRelmCd, String regMenuPart) {
		int afileSeq = 0;
		String fullFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
		String orgnFileNm = fullFileName.substring(0, fullFileName.indexOf("."));
		String ext = fullFileName.substring(fullFileName.indexOf("."));
		String regFileNm = CommonUtils.getFileId(orgnFileNm);
		Path targetLocation = Paths.get(uploadDirPath).toAbsolutePath().normalize().resolve(regFileNm.concat(ext));
		try {
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			afileSeq = this.fileRepository.findOneForMaxSeq(regMenuPart) + 1;
			String urlPathCd = "http://localhost:8080".concat("/afiles/").concat(themaRelmCd).concat("/").concat(regFileNm).concat(ext);

			this.fileRepository.saveInfoForBrandFile(afileSeq, afileNo, orgnFileNm, urlPathCd, targetLocation.toString(), regFileNm, ext, (int) file.getSize(), themaRelmCd, regMenuPart);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return String.valueOf(afileSeq);
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
}