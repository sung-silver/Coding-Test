-- 코드를 입력하세요
SELECT i.animal_id, i.name
FROM ANIMAL_INS i JOIN ANIMAL_OUTS o
ON i.animal_id = o.animal_id
WHERE TIMEDIFF(o.datetime, i.datetime) < 0
ORDER BY i.datetime;