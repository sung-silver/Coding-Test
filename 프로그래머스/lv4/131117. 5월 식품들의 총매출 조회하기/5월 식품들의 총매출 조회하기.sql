-- 코드를 입력하세요
SELECT p.product_id, p.product_name, (p.price*total_amount)as TOTAL_SALES
FROM (SELECT product_id, sum(amount) as total_amount
    FROM FOOD_ORDER
    WHERE DATE_FORMAT(produce_date,"%Y-%m") = "2022-05"
    GROUP BY product_id) as o 
JOIN FOOD_PRODUCT as p
ON o.product_id = p.product_id
ORDER BY TOTAL_SALES DESC, p.product_id ASC;