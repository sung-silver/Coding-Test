select b.book_id, a.author_name, DATE_FORMAT(b.published_date,"%Y-%m-%d") as publised_date
from book b join author a on b.author_id = a.author_id
where b.category LIKE '경제'
order by b.published_date ASC;