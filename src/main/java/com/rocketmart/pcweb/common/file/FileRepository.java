package com.rocketmart.pcweb.common.file;

import com.rocketmart.jooq.tables.TbCmAfile;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class FileRepository {

	@Autowired
	private DSLContext dslContext;

	public int findOneForMaxSeq() {
		return this.dslContext.select(DSL.coalesce(DSL.max(TbCmAfile.TB_CM_AFILE.AFILE_SEQ), 0))
				.from(TbCmAfile.TB_CM_AFILE)
				.fetchOne(Record1::value1);
	}

	public int saveInfoForFile(int afileSeq, int afileNo, String orgnFileNm, String urlPathCd, String afilePath, String regFileNm, String ext, int afileSize, String themaRelmCd, String regMenuPart) {
		return this.dslContext.insertInto(TbCmAfile.TB_CM_AFILE)
				.columns(TbCmAfile.TB_CM_AFILE.AFILE_SEQ, TbCmAfile.TB_CM_AFILE.AFILE_NO, TbCmAfile.TB_CM_AFILE.ORGN_FILE_NM, TbCmAfile.TB_CM_AFILE.URL_PATH_CD,
						TbCmAfile.TB_CM_AFILE.AFILE_PATH, TbCmAfile.TB_CM_AFILE.REG_FILE_NM, TbCmAfile.TB_CM_AFILE.EXT, TbCmAfile.TB_CM_AFILE.AFILE_SIZE, TbCmAfile.TB_CM_AFILE.THEMA_RELM_CD, TbCmAfile.TB_CM_AFILE.REG_MENU_PART,
						TbCmAfile.TB_CM_AFILE.DEL_YN, TbCmAfile.TB_CM_AFILE.REG_USR_ID, TbCmAfile.TB_CM_AFILE.UPD_USR_ID)
				.values(afileSeq, afileNo, orgnFileNm, urlPathCd, afilePath, regFileNm, ext, afileSize, themaRelmCd, regMenuPart, "N", "ADMIN", "ADMIN")
				.execute();
	}
}
