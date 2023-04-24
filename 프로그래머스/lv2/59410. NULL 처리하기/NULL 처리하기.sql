-- 코드를 입력하세요
SELECT animal_type, (
    CASE WHEN name IS NULL THEN "No name"
         ELSE name
    END) AS NAME, 
    sex_upon_intake
FROM ANIMAL_INS
ORDER BY animal_id ASC;