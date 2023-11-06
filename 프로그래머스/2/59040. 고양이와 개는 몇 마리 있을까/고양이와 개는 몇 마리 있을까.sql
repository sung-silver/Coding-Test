-- 코드를 입력하세요
select animal_type, count(animal_type) as count
from animal_ins
where animal_type = 'Cat' OR animal_type='Dog'
group by animal_type
order by animal_type