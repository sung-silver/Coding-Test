-- 코드를 입력하세요
SELECT YEAR(o.sales_date) as YEAR, MONTH(o.sales_date) as MONTH, i.gender as GENDER, COUNT(DISTINCT i.user_id) as USERS
FROM USER_INFO i JOIN ONLINE_SALE o
ON i.user_id = o.user_id
WHERE i.gender IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER