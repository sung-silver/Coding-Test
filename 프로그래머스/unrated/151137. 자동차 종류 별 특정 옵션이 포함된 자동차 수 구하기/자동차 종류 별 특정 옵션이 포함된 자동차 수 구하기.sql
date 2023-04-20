-- 코드를 입력하세요
SELECT car_type, count(car_id) AS CARS FROM CAR_RENTAL_COMPANY_CAR
WHERE REGEXP_LIKE(options, '통풍시트|열선시트|가죽시트')
GROUP BY car_type
ORDER BY car_type asc;