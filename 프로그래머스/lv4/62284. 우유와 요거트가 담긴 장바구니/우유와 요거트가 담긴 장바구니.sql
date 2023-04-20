-- 코드를 입력하세요
SELECT m.cart_id FROM 
(SELECT cart_id, name FROM CART_PRODUCTS WHERE name LIKE "Milk") as m 
JOIN (SELECT cart_id, name FROM CART_PRODUCTS WHERE name LIKE "Yogurt") as y
ON m.cart_id = y.cart_id
WHERE m.cart_id IS NOT NULL AND y.cart_id IS NOT NULL
GROUP BY m.cart_id
ORDER BY m.cart_id ASC;