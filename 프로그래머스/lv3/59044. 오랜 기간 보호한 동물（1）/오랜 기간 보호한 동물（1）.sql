-- 코드를 입력하세요
SELECT i.name, i.datetime FROM ANIMAL_INS i
LEFT OUTER JOIN ANIMAL_OUTS o
ON i.animal_id = o.animal_id
WHERE o.animal_id IS NULL
ORDER BY i.datetime ASC
LIMIT 3;