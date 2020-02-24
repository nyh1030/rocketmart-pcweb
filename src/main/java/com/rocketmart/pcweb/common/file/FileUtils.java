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

	public String uploadFile(MultipartFile file, HttpServletRequest request) {
		//String path = request.getSession().getServletContext().getRealPath("resources/fileUpload");
		String path = "C:\\fileUpload";

		/*String fileDownloadPath = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(fileName)
				.toUriString();*/

		return this.saveFile(file, path);
	}

	public String saveFile(MultipartFile file, String uploadDirPath) {
		int fileSeq = 0;
		String realFileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
		String fileExtensions = realFileName.substring(realFileName.indexOf("."));
		String storedFileNm = CommonUtils.getFileId(realFileName);
		Path targetLocation = Paths.get(uploadDirPath).toAbsolutePath().normalize().resolve(storedFileNm.concat(".").concat(fileExtensions));
			try {
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			fileSeq = this.fileRepository.findOneForMaxSeq() + 1;
			this.fileRepository.saveInfoForBrandFile(fileSeq, storedFileNm, realFileName, fileExtensions);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return String.valueOf(fileSeq);
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