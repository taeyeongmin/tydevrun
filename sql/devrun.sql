-- 회원 테이블 생성
CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"ID"	VARCHAR2(50)		NOT NULL,
	"NAME"	VARCHAR2(50)		NOT NULL,
	"NICKNAME"	VARCHAR2(50)		NOT NULL,
	"PASSWORD"	VARCHAR2(300)		NOT NULL,
	"BIRTHDAY"	DATE		NOT NULL,
	"EMAIL"	VARCHAR2(300)		NOT NULL,
	"PHONE"	CHAR(11)		NOT NULL,
	"POINT"	NUMBER	DEFAULT 0	NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"PRO_PHOTO"	VARCHAR2(100)		NULL,
	"BLACK_YN"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"SMS_YN"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"WARNING_COUNT"	NUMBER	DEFAULT 0	NULL,
	"URL"	VARCHAR2(500)		NULL,
	"INTRO"	VARCHAR2(1000)		NULL
);

-- 회원 테이블 코멘트 추가
COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호';
COMMENT ON COLUMN "MEMBER"."ID" IS '회원 아이디';
COMMENT ON COLUMN "MEMBER"."NAME" IS '회원 이름';
COMMENT ON COLUMN "MEMBER"."NICKNAME" IS '회원 닉네임';
COMMENT ON COLUMN "MEMBER"."PASSWORD" IS '비밀번호';
COMMENT ON COLUMN "MEMBER"."BIRTHDAY" IS '생일';
COMMENT ON COLUMN "MEMBER"."EMAIL" IS '이메일';
COMMENT ON COLUMN "MEMBER"."PHONE" IS '휴대폰번호';
COMMENT ON COLUMN "MEMBER"."POINT" IS '포인트';
COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '가입일';
COMMENT ON COLUMN "MEMBER"."PRO_PHOTO" IS '프로필사진(선생님대화참고 아이디.jpg이용)';
COMMENT ON COLUMN "MEMBER"."BLACK_YN" IS '블랙리스트 회원 구분 여부';
COMMENT ON COLUMN "MEMBER"."SMS_YN" IS 'SMS수신여부';
COMMENT ON COLUMN "MEMBER"."WARNING_COUNT" IS '경고횟수';
COMMENT ON COLUMN "MEMBER"."URL" IS '사이트 주소';
COMMENT ON COLUMN "MEMBER"."INTRO" IS '소개글';

-- 제약조건 추가
ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);


-----------지영 작업-----------



-----------지원 작업-----------



-----------종서 작업-----------



