DECLARE
    v_nom VARCHAR2(20) := 'Spain';
    v_id VARCHAR2(2) := 'SP';
    v_id_region NUMBER;

BEGIN
    SELECT region_id INTO v_id_region FROM REGIONS WHERE region_name = 'Europe';
    INSERT INTO COUNTRIES VALUES ( v_id, v_nom, v_id_region); 
        DBMS_OUTPUT.PUT_LINE('Nom:'||v_nom|| ' Id:'||v_id||'Id regio:'||v_id_region);
END;    

DECLARE
    TYPE t_sales IS TABLE OF NUMBER INDEX BY VARCHAR2(10);
    c_sales t_sales;
    
BEGIN
    SELECT COUNT(*) INTO c_sales('Blake') FROM ORDERS JOIN EMPLOYEES ON SALESMAN_ID = EMPLOYEE_ID 
    WHERE FIRST_NAME = 'Blake' AND STATUS = 'Shipped';
    
    SELECT COUNT(*) INTO c_sales('Daisy') FROM ORDERS JOIN EMPLOYEES ON SALESMAN_ID = EMPLOYEE_ID
    WHERE FIRST_NAME = 'Daisy' AND STATUS = 'Shipped';
    
    SELECT COUNT(*) INTO c_sales('Lily') FROM ORDERS JOIN EMPLOYEES ON SALESMAN_ID = EMPLOYEE_ID
    WHERE FIRST_NAME = 'Lily' AND STATUS = 'Shipped';
    
    DBMS_OUTPUT.PUT_LINE('F'||c_sales.FIRST||', ' ||c_sales(c_sales.FIRST));
END;
    
DECLARE
    TYPE t_varr IS VARRAY (3) OF EMPLOYEES.FIRST_NAME%TYPE;
    v_varr t_varr;
    
BEGIN
    SELECT FIRST_NAME BULK COLLECT INTO v_varr 
    FROM EMPLOYEES JOIN ORDERS ORD ON ORD.SALESMAN_ID = EMPLOYEE_ID AND ORD.STATUS = 'Shipped' 
    ORDER BY STATUS DESC FETCH FIRST 3 ROWS ONLY ;
    DBMS_OUTPUT.PUT_LINE('Els empleats amb mes comandes son'||v_varr(1)||', '||v_varr(2)||', '||v_varr(3));
END;

DECLARE
    TYPE t_varr IS VARRAY (3) OF EMPLOYEES.FIRST_NAME%TYPE;
    v_varr t_varr;
BEGIN
    SELECT FIRST_NAME
    BULK COLLECT INTO v_varr
    FROM (
        SELECT E.FIRST_NAME, COUNT(*) AS total
        FROM EMPLOYEES E
        JOIN ORDERS O ON O.SALESMAN_ID = E.EMPLOYEE_ID
        WHERE O.STATUS = 'Shipped'
        GROUP BY E.FIRST_NAME
        ORDER BY total DESC
    )
    WHERE ROWNUM <= 3;

    DBMS_OUTPUT.PUT_LINE('Els empleats amb més comandes són: ' || 
                         v_varr(1) || ', ' || v_varr(2) || ', ' || v_varr(3));
END;

DECLARE
    ID_EMPLEAT EMPLOYEES.EMPLOYEE_ID%TYPE := 82;
    SALARI EMPLOYEES.SALARY%TYPE;
    TITOL EMPLOYEES.JOB_TITLE%TYPE;
BEGIN
    -- Obtenim el JOB_TITLE de l'empleat amb ID concret
    SELECT JOB_TITLE INTO TITOL FROM EMPLOYEES WHERE EMPLOYEE_ID = ID_EMPLEAT;

    -- Comprovem si és programador
    IF TITOL = 'Programmer' THEN
        -- Si ho és, agafem el salari
        SELECT SALARY INTO SALARI FROM EMPLOYEES WHERE EMPLOYEE_ID = ID_EMPLEAT;

        -- Comprovem el rang segons el salari
        CASE SALARI
            WHEN 4200 THEN DBMS_OUTPUT.PUT_LINE('Junior');
            WHEN 4800 THEN DBMS_OUTPUT.PUT_LINE('Mid');
            WHEN 6000 THEN DBMS_OUTPUT.PUT_LINE('Senior');
            WHEN 9000 THEN DBMS_OUTPUT.PUT_LINE('Lead');
            ELSE DBMS_OUTPUT.PUT_LINE('Salari no classificat');
        END CASE;
    ELSE
        -- Si no és programador, ho indiquem
        DBMS_OUTPUT.PUT_LINE('Aquest empleat no és programador.');
    END IF;
END;
