-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH , "%Y-%m-%d")from MEMBER_PROFILE where GENDER ="W" and month(DATE_OF_BIRTH) = 3 and TLNO is not null ORDER BY MEMBER_ID;