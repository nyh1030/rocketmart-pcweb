package com.rocketmart.pcweb.biz.ctl.rest;

import com.rocketmart.jooq.tables.records.TbMemMstRecord;
import com.rocketmart.pcweb.biz.svc.MemberSvc;
import com.rocketmart.pcweb.common.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MemberRestCtl {

    @Autowired
    private MemberSvc memberSvc;

    /**
     * 회원중복 체크
     * @param memId
     * @return boolean
     *
     * Y면 중복아이디 존재, N이면 중복아이디 없음(회원가입가능)
     */
    @PostMapping("/any/rest/member/idOverLapChk")
    public boolean idOverLapChk(@RequestBody String memId) {
        return memberSvc.idOverLapChk(memId);
    }

    /**
     * 회원 승인 처리
     * @param memId
     * @param apprvlYn
     * @return String
     */
    @PostMapping("/any/rest/member/execApproval")
    public String execApproval(String memId, String apprvlYn) {

        String msg = "";

        // 회원 승인 처리
        msg = memberSvc.execApprovalMember(memId, apprvlYn);

        return msg;
    }

    /**
     * 사업자 등록증 등록처리
     * @param file
     * @param themaRelmCd
     * @param regMenuPart
     * @return ResponseEntity<String>
     */
    @PostMapping("/any/rest/member/bsnsRgstr/file/upload")
    public ResponseEntity<String> saveBsnsRgstrUpload(MultipartFile file, @RequestParam(value = "themaRelmCd") String themaRelmCd, @RequestParam(value = "regMenuPart") String regMenuPart) {
        return new ResponseEntity<>(memberSvc.saveBsnsRgstrUpload(file, themaRelmCd, regMenuPart), HttpStatus.OK);
    }

    /**
     * 비밀번호 초기화
     * @param memId
     * @return ResponseEntity<String>
     */
    @PostMapping("/admin/rest/member/mempw/init")
    public ResponseEntity<String> saveBsnsRgstrUpload(@RequestParam(value = "memId") String memId) {
        return new ResponseEntity<>(memberSvc.execModifyMemPwInfo(memId) > 0 ? ApiResponse.SUCCESS.getCode() : ApiResponse.FAIL.getCode(), HttpStatus.OK);
    }
}
