create table tb_mem_mst
(
    MEM_SEQ        int                                  not null comment '회원정보 일련번호',
    ROLE           varchar(50)                          null comment '역할',
    MEM_ID         varchar(50)                          not null comment '회원아이디(이메일)',
    MEM_NM         varchar(80)                          not null comment '회원명',
    MEM_PW         varchar(1000)                        null comment '비밀번호',
    TEL            varchar(40)                          null comment '전화번호',
    COMPANY_NM     varchar(100)                         null comment '회사명',
    COMPANY_URL    varchar(200)                         null comment '회사URL',
    BSNS_RGSTR_SEQ int                                  not null comment '사업자등록증 일련번호',
    REG_USR_ID     varchar(50)                          not null comment '등록자 아이디',
    REG_TS         datetime default current_timestamp() not null comment '등록일시',
    UPD_USR_ID     varchar(50)                          not null comment '수정자 아이디',
    UPD_TS         datetime default current_timestamp() not null comment '수정일시'
)
    comment '회원정보 마스터';

create index IDX_MEM_SEQ
    on tb_mem_mst (MEM_SEQ);


