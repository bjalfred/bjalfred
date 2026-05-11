/***************************/
/* Name:Brooke Alfred */
/* Class: CS 3410 */
/* Term: Spring 2025 */
/* Assgn #: 3 */
/***************************/

/*2.28*/
SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE INVENTORY.QuantityOnHand=0 OR INVENTORY.QuantityOnOrder=0
ORDER BY WarehouseID DESC , SKU ASC;

/*2.29*/
SELECT SKU, SKU_Description, WarehouseID,QuantityOnHand
FROM INVENTORY
WHERE INVENTORY.QuantityOnHand>1 AND INVENTORY.QuantityOnHand<10;

/*2.30*/
SELECT SKU, SKU_Description, WarehouseID,QuantityOnHand
FROM INVENTORY
WHERE INVENTORY.QuantityOnHand BETWEEN 1 AND 10;

/*2.31*/
SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE INVENTORY.SKU_Description LIKE 'Half-dome%';

/*2.32*/
SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE INVENTORY.SKU_Description LIKE '%Climb%';

/*2.33*/
SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE INVENTORY.SKU_Description LIKE '__d%';

/*2.35*/
/*Count will count up the total number of items in a row, but sum will add up all of the numbers in a row*/

/*2.36*/
SELECT WarehouseID, SUM(QuantityOnHand) AS TotalItemsOnHand
FROM INVENTORY
GROUP BY WarehouseID
ORDER BY TotalItemsOnHand DESC;

/*2.37*/
SELECT WarehouseID, SUM(QuantityOnHand) AS TotalItemsOnHandLT3
FROM INVENTORY
WHERE QuantityOnHand < 3
GROUP BY WarehouseID
ORDER BY TotalItemsOnHandLT3 DESC;

/*2.38*/
SELECT WarehouseID, SUM(QuantityOnHand) AS TotalItemsOnHandLT3
FROM INVENTORY
WHERE QuantityOnHand < 3
GROUP BY WarehouseID
HAVING SUM(QuantityOnHand)<2
ORDER BY TotalItemsOnHandLT3 DESC;

/*2.39*/
/* Where is applied first because you have to look for the first quantities to make that new column, then search through the new column*/

/*2.40*/
SELECT SKU,SKU_Description,WarehouseID, WarehouseCity, WarehouseState
FROM INVENTORY JOIN WAREHOUSE
ON INVENTORY.WarehouseID= WAREHOUSE.WarehouseID
WHERE WAREHOUSE.WarehouseCity='Atlanta' 
OR WAREHOUSE.WarehouseCity='Bangor' 
OR WAREHOUSE.WarehouseCity='Chicago';

/*2.41*/
SELECT SKU,SKU_Description,WarehouseID, WarehouseCity, WarehouseState
FROM INVENTORY JOIN WAREHOUSE
ON INVENTORY.WarehouseID= WAREHOUSE.WarehouseID
WHERE WAREHOUSE.WarehouseCity IN ('Atlanta','Bangor','Chicago');

/*2.42*/
SELECT SKU,SKU_Description,WarehouseID, WarehouseCity, WarehouseState
FROM INVENTORY JOIN WAREHOUSE
ON INVENTORY.WarehouseID= WAREHOUSE.WarehouseID
WHERE WAREHOUSE.WarehouseCity<>'Atlanta' 
AND WAREHOUSE.WarehouseCity<>'Bangor' 
AND WAREHOUSE.WarehouseCity<>'Chicago';

/*2.43*/
SELECT SKU,SKU_Description,WarehouseID, WarehouseCity, WarehouseState
FROM INVENTORY JOIN WAREHOUSE
ON INVENTORY.WarehouseID= WAREHOUSE.WarehouseID
WHERE WAREHOUSE.WarehouseCity NOT IN ('Atlanta','Bangor','Chicago');

/*2.44*/ 
SELECT SKU_Description || ' is in a warehouse in ' || WarehouseCity AS ItemLocation
FROM INVENTORY 
JOIN WAREHOUSE 
ON INVENTORY.WarehouseID = WAREHOUSE.WarehouseID;

/*2.45*/ 
SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE WarehouseID IN (
SELECT WarehouseID
FROM WAREHOUSE
WHERE Manager = 'Lucille Smith');

/*2.46*/ 
SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY , WAREHOUSE 
WHERE INVENTORY.WarehouseID = WAREHOUSE.WarehouseID AND WAREHOUSE.Manager = 'Lucille Smith';

/*2.47*/ 
SELECT SKU,SKU_Description, WarehouseID
FROM INVENTORY 
JOIN WAREHOUSE 
ON INVENTORY.WarehouseID = WAREHOUSE.WarehouseID
WHERE WAREHOUSE.Manager = 'Lucille Smith';

/*2.48*/ 
SELECT WarehouseID, AVG(QuantityOnHand) AS AvgQuantity
FROM INVENTORY
WHERE WarehouseID IN (
SELECT WarehouseID
FROM WAREHOUSE
WHERE Manager = 'Lucille Smith')
GROUP BY WarehouseID;

/*2.49*/ 
SELECT WarehouseID, AVG(QuantityOnHand) AS AvgQuantity
FROM INVENTORY , WAREHOUSE 
WHERE INVENTORY.WarehouseID = WAREHOUSE.WarehouseID AND WAREHOUSE.Manager = 'Lucille Smith'
GROUP BY INVENTORY.WarehouseID;

/*2.50*/ 
SELECT WarehouseID, AVG(QuantityOnHand) AS AvgQuantity
FROM INVENTORY 
JOIN WAREHOUSE 
ON INVENTORY.WarehouseID = WAREHOUSE.WarehouseID
WHERE WAREHOUSE.Manager = 'Lucille Smith'
GROUP BY INVENTORY.WarehouseID;




