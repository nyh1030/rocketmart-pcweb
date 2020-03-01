## 📖 Rocket International Project Specification


- Framework - Spring5, Springboot2.0
- View - Thymeleaf
- JDK - 1.8
- Builder - Gradle 6.0
- DB - MariaDB
- DB Interface - jOOQ // SQL Mapper - Mybatis 대신에 사용 
- 형상관리 - Git
- 배포(CI) - Jenkins
- Layout - Responsive, Bootstrap 4.x
- Compatible Browsers	Firefox, Safari, Opera, Chrome, Edge
- 네이버 클라우드 플랫폼 / Linux




## 📝 고려사항

- [ ] 도메인
- [ ] 호스팅
- [ ] 테이블설계
- [ ] 로그인(스프링 시큐리티 적용) : 어플리케이션의 보안(인증과 권한)을 담당하는 프레임워크 //세션-쿠키방식으로 인증 
- [ ] 보안취약점 대응 : 크로스사이트 스크립팅(XSS), SQL Injection, 크로스 사이트 요청변조(CSRF)
- [ ] 로깅처리 : Log4j2
- [ ] 예외처리 : 예외처리발생시 ControllerAdvice (Exception Handler)를 통하여 예외처리를 관리
- [ ] 첨부파일 및 이미지 관리 : 폴더구성 변수화
- [ ] 인터셉터 : 로그인, 마이바티스, //다국어
- [ ] 메일전송 
- [ ] 시큐어 코딩(벨리드 어노테이션, 데이터 마스킹)
- [ ] Restful 설계

## 📑 작성문서

- [ ] 기획서(요구사항정의서)
- [ ] 테이블정의서
- [ ] ERD

#### 템플릿 URL
php 버전이 더 많은 내용을 가지고 있음

 - html5 - https://themeforest.net/item/martfury-multipurpose-marketplace-html5-template-with-dashboard/23954976
 - php - http://demo2.drfuri.com/martfury/

### 설치 URL

 - MariaDB 10.4.12 - https://mariadb.com/download-confirmation/?group-name=MariaDB%20Community%20Server&release-notes-uri=https%3A%2F%2Fmariadb.com%2Fkb%2Fen%2Fmariadb-10412-release-notes%2F&documentation-uri=https%3A%2F%2Fmariadb.com%2Fkb%2Fen%2Fwhat-is-mariadb-104%2F&download-uri=https%3A%2F%2Fdownloads.mariadb.com%2FMariaDB%2Fmariadb-10.4.12%2Fwinx64-packages%2Fmariadb-10.4.12-winx64.msi&product-name=MariaDB%2520Server&download-size=54.23%20MB
 - Gradle 6.0.1 - https://gradle.org/next-steps/?version=6.0.1&format=all

## Project Naming rule
```
- Controller : ctl
- Data Access Object : dao
- Service : svc
```

## DB Naming rule
```
- 테이블
ex) TB_MEM_MST / TB_MEM_DTL
    TB_PRD_MST / TB_PRD_DTL

 - CUD 테이블 기본 생성 컬럼명
일련번호
ex) ******_SEQ (NUMBER 8)

등록&수정
REG_USR_ID (VARCHAR(20))
REG_TS (SYSDATE)
UPD_USR_ID (VARCHAR(20))
UPD_TS (SYSDATE)
```



## 🤝 Connect
```
github : https://github.com/nyh1030
email  : nyhpig@gmail.com
phone : 010-9989-1405
```
