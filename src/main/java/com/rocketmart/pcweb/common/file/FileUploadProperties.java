package com.rocketmart.pcweb.common.file;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "attach-file")
public class FileUploadProperties {
	private String uploadDir;
}


