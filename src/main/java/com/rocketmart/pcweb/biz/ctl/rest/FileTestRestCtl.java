package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.common.file.FileResponse;
import com.rocketmart.pcweb.common.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class FileTestRestCtl {

	@Autowired
	private FileUtils fileUtils;

	@PostMapping("/uploadFile")
	public FileResponse uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/fileUpload");
		String fileName = fileUtils.saveFile(file, path);
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

	/*@PostMapping("/uploadMultiFiles")
	public List<FileResponse> uploadMultiFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/fileUpload");
		return Arrays.stream(files)
				.map(this::uploadFile)
				.collect(Collectors.toList());
	}*/

	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("resources/fileUpload");
		Resource resource = fileUtils.loadFileAsResource(fileName, path);

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
