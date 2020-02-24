package com.rocketmart.pcweb.common.file;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResponse {

	private String fileSeq; // 파일명
	private String fileName; // 파일명
	private String fileDownloadUrl; // 파일 다운로드 URL
	private String fileType; // 파일 유형
	private Long fileSize; // 파일 사이즈
}
