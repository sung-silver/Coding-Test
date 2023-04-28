-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, a.pt_no, d.mcdp_cd, d.dr_name, a.apnt_ymd
FROM APPOINTMENT a
JOIN PATIENT p
ON a.pt_no = p.pt_no
JOIN DOCTOR d
ON a.mddr_id = d.dr_id
WHERE a.mcdp_cd = "CS" 
    AND a.apnt_cncl_yn = "N" 
    AND DATE_FORMAT(a.apnt_ymd,"%Y-%m-%d") = "2022-04-13"
ORDER BY a.apnt_ymd ASC
