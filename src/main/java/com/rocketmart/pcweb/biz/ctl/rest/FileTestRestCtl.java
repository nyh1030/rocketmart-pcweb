package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.common.file.FileResponse;
import com.rocketmart.pcweb.common.file.FileUtils;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileTestRestCtl {

	@PostMapping("/uploadFile")
	public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = FileUtils.saveFile(file);
		String fileDownloadPath = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/downloadFile/")
				.path(fileName)
				.toUriString();

		return FileResponse.builder()
				.fileName(fileName)
				.fileDownloadUrl(fileDownloadPath)
				.fileType(file.getContentType())
				.fileSize(file.getSize())
				.build();
	}

	@PostMapping("/uploadMultiFiles")
	public List<FileResponse> uploadMultiFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.stream(files)
				.map(this::uploadFile)
				.collect(Collectors.toList());
	}

	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		Resource resource = FileUtils.loadFileAsResource(fileName);

		String contentType = "";
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (contentType.isEmpty()) {
			contentType = MimeTypeUtils.APPLICATION_OCTET_STREAM.getType();
		}

		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);


	}
}
