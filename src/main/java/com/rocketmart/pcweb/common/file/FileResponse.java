package com.rocketmart.pcweb.common.file;

import lombok.Data;

@Data
public class FileResponse {

	private String fileName; // 파일명
	private String fileDownloadUrl; // 파일 다운로드 URL
	private String fileType; // 파일 유형
	private Long fileSize; // 파일 사이즈
}
