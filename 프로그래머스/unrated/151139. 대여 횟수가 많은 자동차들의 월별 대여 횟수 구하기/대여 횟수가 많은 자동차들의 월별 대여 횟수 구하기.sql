-- 코드를 입력하세요
-- 대여 시작일을 기준으로 총 대여 횟수가 5회 이상인 자동차는 자동차 ID가 1, 2인 자동차입니다. 월 별 자동차 ID별 총 대여 횟수를 구하고 월 오름차순, 자동차 ID 내림차순으로 정렬

-- 테이블에서 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트를 출력하는 SQL문을 작성해주세요. 결과는 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬해주세요. 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요.

-- SELECT DATE_FORMAT(START_DATE, '%c') MONTH, CAR_ID, COUNT(HISTORY_ID) AS RECORDS from CAR_RENTAL_COMPANY_RENTAL_HISTORY where (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10') GROUP BY CAR_ID HAVING COUNT(HISTORY_ID) >= 5;

SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
        GROUP BY CAR_ID
        HAVING COUNT(CAR_ID) >= 5
    ) AND (DATE_FORMAT(START_DATE, '%Y-%m') BETWEEN '2022-08' AND '2022-10')
GROUP BY MONTH, CAR_ID
HAVING RECORDS > 0
ORDER BY MONTH ASC, CAR_ID DESC;