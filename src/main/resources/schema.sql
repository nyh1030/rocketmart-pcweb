# 브랜드 정보 #
create table rocketmart.tb_brand_mst
(
    brand_seq           bigint auto_increment primary key,
    brand_nm            varchar(100) not null,
    brand_logo          varchar(50) not null,
    brand_ownership     varchar(50) not null,
    brand_homepage_url  varchar(100) null,
    brand_youtube_url   varchar(100) null,
    brand_instagram_url varchar(100) null,
    brand_cerify        varchar(100) null,
    brand_introduction  varchar(100) null,
    reg_user_id         varchar(50) not null,
    reg_ts              timestamp not null,
    upd_user_id         varchar(50) null,
    upd_ts              timestamp null
)
    comment '브랜드_정보';
#-----------------------------------------------------------------------------------------------------------------------