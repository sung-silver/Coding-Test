-- 코드를 입력하세요
SELECT j.flavor FROM JULY j JOIN FIRST_HALF f
ON j.flavor = f.flavor 
GROUP BY j.flavor
ORDER BY SUM(j.TOTAL_ORDER) + SUM(f.TOTAL_ORDER) DESC
LIMIT 3;