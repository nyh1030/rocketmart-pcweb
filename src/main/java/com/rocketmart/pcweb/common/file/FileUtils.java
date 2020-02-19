package com.rocketmart.pcweb.common.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {

	private static String uploadDirPath = "C:\\fileUpload";

	public static String saveFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path targetLocation = Paths.get(uploadDirPath).toAbsolutePath().normalize().resolve(fileName);
		try {
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	public static Resource loadFileAsResource(String fileName) {
		Resource resource = null;
		try {
			resource = new UrlResource(Paths.get(uploadDirPath).toAbsolutePath().normalize().resolve(fileName).normalize().toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return resource;
	}
}