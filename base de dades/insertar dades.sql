--1--

DECLARE
    PRODUCT_NOT_FOUND exception;
    TYPE t_product_id IS TABLE OF PRODUCTS.PRODUCT_ID%TYPE;
    
    v_Producte t_Products;
    v_total NUMBER;
    
    FUNCTION total_price(p_ids t_products) RETURN NUMBER IS
        preu_total number _:= 0;
        aux number;
        vIDX PLS_INTEGER;
    BEGIN   
        vIDX:=pIDs.FIRST;
        WHILE vIDX IS NOT NULL LOOP
            SELECT count(*) INTO aux FROM PRODUCTS WHERE product_id = pIDs(vIDX);
                if   (aux = 0) then
                    RAISE PRODUCT_NOT_FOUND;
                end if;
            SELECT list_price into aux FROM PRODUCTS WHERE product_id = pIDs(vIDX);
                preu_total := preu_total + aux;
                vIDX := pIDs.NEXT(vIDX);
        END LOOP;
        RETURN preu_total;
    END;
BEGIN
    v_Products := t_Products(1,2,4);
    vTotal := total_price(v_Products);
    DBMS_OUTPUT.PUT_LINE('Preu total: '||vTotal);
END;


--2--
DECLARE
    PRODUCT_NOT_FOUND exception;
    TYPE tAss IS TABLE OF PRODCUTS%ROWTYPE;
    
    vAss tAss;
    IDX PLS_INTEGER;
    
    FUNCTION get_products_by_category(p_id_category number) REURN tAss IS
        vAss tAss;
    BEGIN
        SELECT * BULK COLLECT INTO vAss FROM PRODUCTS WHERE CATEGORY_ID = p_id_category;
        RETURN vAss;
    END;
    
BEGIN vAss := get_products_by_category(2);
    IDX := vAss.FIRST;
    LOOP
        DBMS_OUTPUT.PUT_LINE(vAss).product_name);
        IDX := vAss.NEXT(IDX);
        EXIT WHEN IDX IS NULL;
    END LOOP;
END;