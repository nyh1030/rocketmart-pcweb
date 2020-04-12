package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.pcweb.common.file.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class FileRestCtl {

	@Autowired
	private FileUtils fileUtils;

	@Value("${afile.path}")
	private String path;

	@GetMapping("/downloadFile/{module}/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String module, @PathVariable String fileName, HttpServletRequest request) {
		Resource resource = fileUtils.loadFileAsResource(fileName, path+module);

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
