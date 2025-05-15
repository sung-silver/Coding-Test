-- 코드를 입력하세요
SELECT
    b.author_id,
    a.author_name,
    b.category,
    SUM(bs.sales * b.price) AS total_sales
FROM
    book_sales bs
JOIN
    book b ON bs.book_id = b.book_id
JOIN
    author a ON b.author_id = a.author_id
WHERE
    bs.sales_date >= DATE '2022-01-01'
    AND bs.sales_date <  DATE '2022-02-01'
GROUP BY
    b.author_id,
    a.author_name,
    b.category
ORDER BY
    b.author_id ASC,
    b.category DESC;