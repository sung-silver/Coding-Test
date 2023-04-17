-- 코드를 입력하세요
SELECT i.animal_id, i.animal_type, i.name
FROM ANIMAL_INS i JOIN ANIMAL_OUTS o
ON i.animal_id = o.animal_id
WHERE (i.sex_upon_intake LIKE "Intact%") AND 
(o.sex_upon_outcome LIKE "Neutered%" OR o.sex_upon_outcome LIKE "Spayed%")
ORDER BY i.animal_id ASC;