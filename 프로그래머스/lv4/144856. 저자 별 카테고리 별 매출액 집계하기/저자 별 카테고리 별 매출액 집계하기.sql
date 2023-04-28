-- 코드를 입력하세요
SELECT a.author_id, a.author_name, j.category, SUM(j.book_total) as total_sales FROM (SELECT b.book_id, b.author_id, b.category, SUM(b.price*s.sales) as book_total
FROM BOOK b JOIN BOOK_SALES s
ON b.book_id = s.book_id
WHERE DATE_FORMAT(s.sales_date, "%Y-%m") = "2022-01"
GROUP BY b.book_id)
j JOIN AUTHOR a
ON j.author_id = a.author_id
WHERE a.author_id IS NOT NULL
GROUP BY a.author_id, j.category
ORDER BY a.author_id, j.category DESC;
