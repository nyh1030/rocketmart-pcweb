# 브랜드 정보 #
create table rocketmart.tb_brand_mst
(
    BRAND_SEQ           bigint auto_increment primary key,
    BRAND_NM            text not null,
    BRAND_LOGO          text not null,
    BRAND_OWNERSHIP     text not null,
    BRAND_HOMEPAGE_URL  text null,
    BRAND_YOUTUBE_URL   text null,
    BRAND_INSTAGRAM_URL text null,
    BRAND_CERIFY        text null,
    BRAND_INTRODUCTION  text null
)
    comment '브랜드_정보';
#-----------------------------------------------------------------------------------------------------------------------