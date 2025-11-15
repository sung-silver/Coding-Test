-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
FROM APPOINTMENT a 
JOIN DOCTOR d on a.mddr_id = d.dr_id
JOIN PATIENT p on a.pt_no = p.pt_no
WHERE a.apnt_cncl_yn = 'N'
    AND a.mcdp_cd = 'CS'
    AND TO_CHAR(a.apnt_ymd, 'YYYY-MM-DD') = '2022-04-13'
ORDER BY a.apnt_ymd;