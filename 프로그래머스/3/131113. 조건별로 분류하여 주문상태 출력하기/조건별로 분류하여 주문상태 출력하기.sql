-- 코드를 입력하세요
-- out_date를 기준으로 2022년 5월 1일보다 같거나 작으면 출고 완료 그렇지 않으면 출고 대기, null 이면 출고 미정
SELECT ORDER_ID, PRODUCT_ID, TO_CHAR(OUT_DATE, 'YYYY-MM-DD') AS OUT_DATE, 
CASE WHEN OUT_DATE <= TO_DATE('2022-05-01', 'YYYY-MM-DD') THEN '출고완료'
    WHEN OUT_DATE > TO_DATE('2022-05-01', 'YYYY-MM-DD') THEN '출고대기'
    ELSE '출고미정'
END AS 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID ASC;