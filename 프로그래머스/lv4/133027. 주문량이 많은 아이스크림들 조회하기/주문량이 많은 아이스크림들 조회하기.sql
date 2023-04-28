-- 코드를 입력하세요
SELECT j.flavor
FROM (SELECT flavor, SUM(total_order) as total
      FROM JULY
      GROUP BY flavor
      ) j
JOIN FIRST_HALF f
on j.flavor = f.flavor
GROUP BY j.flavor
ORDER BY f.total_order+j.total DESC
limit 3;
      
