-- 코드를 입력하세요
SELECT m.member_name, r.review_text, DATE_FORMAT(r.review_date, "%Y-%m-%d") as REVIEW_DATE
FROM REST_REVIEW r JOIN MEMBER_PROFILE m
ON r.member_id = m.member_id
WHERE m.member_id in(SELECT member_id 
                     FROM REST_REVIEW
                     GROUP BY MEMBER_ID
                     HAVING COUNT(*) = (SELECT count(*) as result
                                        FROM REST_REVIEW
                                        GROUP BY member_id
                                        ORDER BY result DESC LIMIT 1
                                        )
                    )
ORDER BY REVIEW_DATE ASC, r.review_text ASC;
