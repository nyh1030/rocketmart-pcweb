package com.rocketmart.pcweb.common.file;

import com.rocketmart.jooq.tables.TbBrandFile;
import com.rocketmart.jooq.tables.TbBrandMst;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository {

	@Autowired
	private DSLContext dslContext;

	public int findOneForMaxSeq() {
		return this.dslContext.select(DSL.max(TbBrandFile.TB_BRAND_FILE.FILE_SEQ))
				.from(TbBrandFile.TB_BRAND_FILE).fetchOne(Record1::value1);
	}

	public int saveInfoForBrandFile(int fileSeq, String storedFileNm, String realFileNm, String fileExtensions) {
		return this.dslContext.insertInto(TbBrandFile.TB_BRAND_FILE)
				.columns(TbBrandFile.TB_BRAND_FILE.FILE_SEQ, TbBrandFile.TB_BRAND_FILE.STORED_FILE_NM, TbBrandFile.TB_BRAND_FILE.REAL_FILE_NM,
						TbBrandFile.TB_BRAND_FILE.FILE_EXTENSIONS, TbBrandMst.TB_BRAND_MST.REG_USR_ID, TbBrandMst.TB_BRAND_MST.UPD_USR_ID)
				.values(fileSeq, storedFileNm, realFileNm, fileExtensions, "ADMIN", "ADMIN")
				.execute();
	}
}
