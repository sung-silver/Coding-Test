-- 코드를 입력하세요
with compare_fp as (
    SELECT category, MAX(price) as price
    FROM FOOD_PRODUCT
    GROUP BY category
)

SELECT fp.category, fp.price, fp.product_name
FROM FOOD_PRODUCT fp join compare_fp cp
ON fp.category = cp.category AND fp.price = cp.price
WHERE fp.category in ('과자', '국', '김치', '식용유')
ORDER BY fp.price DESC;