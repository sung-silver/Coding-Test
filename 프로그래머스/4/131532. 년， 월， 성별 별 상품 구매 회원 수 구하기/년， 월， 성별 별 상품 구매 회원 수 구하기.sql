-- 코드를 입력하세요
SELECT EXTRACT(YEAR FROM s.sales_date) AS year, EXTRACT(MONTH FROM s.sales_date) AS month,
i.gender, COUNT(DISTINCT i.user_id) AS users 
FROM user_info i JOIN online_sale s
ON i.user_id = s.user_id
WHERE gender IS NOT NULL
GROUP BY EXTRACT(YEAR FROM s.sales_date), EXTRACT(MONTH FROM s.sales_date), i.gender
ORDER BY year ASC, month ASC, i.gender ASC