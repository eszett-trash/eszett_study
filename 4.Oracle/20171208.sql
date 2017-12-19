create user test IDENTIFIED by java;
drop user test CASCADE;


http://tibang.tistory.com/entry/오라클-접속-방법

1)테이블 스페이스 생성

CREATE tablespace 테이블 스페이스명
DATAFILE '경로' SIZE 사이즈

2)사용자 계정 생성

CREATE USER 사용자 ID identified by 비밀번호
DEFAULT TABLESPACE 테이블스페이스명
QUOTA UNLIMITED ON 테이블 스페이스명;


--유저 생성 hw / ces
create user hw identified by ces;

--유저 권한부여
grant 꿘한 to hw;
