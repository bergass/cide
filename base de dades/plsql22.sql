DECLARE
    v_id_llibre LLIBRE.ID%TYPE := 3;
    v_exemplars LLIBRE.EXEMPLARS%TYPE;
    
BEGIN
    SELECT EXEMPLARS INTO v_exemplars FROM LLIBRE WHERE ID = v_id_llibre;
        FOR INDX IN 1..v_exemplars LOOP
            UPDATE LLIBRE SET EXEMPLARS = EXEMPLARS - 1 WHERE ID = v_id_llibre;
            END LOOP;
END;

DECLARE
    TYPE t_varray IS VARRAY(3) OF LLIBRE%ROWTYPE;
    v_array t_array;
BEGIN
    SELECT * BULK COLLECT INTO v_array FROM LLIBRE ORDER BY EXEMPLARS DESC FETCH FIRST 3 ROWS ONLY;
    
    FOR i IN v_array.FIRST..v_array.LAST LOOP
        DBMS_OUTPUT.PUT_LINE(v_array(i).TITOL || v_array(i).
    