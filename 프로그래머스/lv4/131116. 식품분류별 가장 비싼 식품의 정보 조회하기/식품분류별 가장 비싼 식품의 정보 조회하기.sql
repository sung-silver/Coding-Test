-- 코드를 입력하세요
SELECT category, price as max_price, product_name
FROM FOOD_PRODUCT
WHERE (category,price) in (
    SELECT category, MAX(price) as max_price
    FROM FOOD_PRODUCT 
    WHERE category in ('과자','국','김치','식용유')
    GROUP BY category)
ORDER BY max_price DESC;