-- 코드를 입력하세요
SELECT COUNT(DISTINCT name) as count
FROM ANIMAL_INS
WHERE name IS NOT NULL;