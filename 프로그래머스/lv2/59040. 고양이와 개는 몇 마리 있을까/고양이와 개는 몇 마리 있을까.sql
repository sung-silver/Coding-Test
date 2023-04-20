-- 코드를 입력하세요
SELECT animal_type, COUNT(*) as count
FROM ANIMAL_INS
GROUP BY animal_type
ORDER BY animal_type;