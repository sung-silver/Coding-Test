-- 코드를 입력하세요
SELECT b.category AS CATEGORY, SUM(s.sales) as TOTAL_SALES
FROM BOOK as b 
    JOIN BOOK_SALES as s
    ON b.book_id = s.book_id
WHERE YEAR(s.sales_date)=2022 AND MONTH(s.sales_date) = 1
group by b.category
order by b.category ASC;