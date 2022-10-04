1. Buatlah sebuah query untuk menampilkan result set data customers yang berasal dari Germany. dengan detail cutomer id, Customer Name, contact name, city , dan country.
SELECT CustomerID,CustomerName,ContactName,City,Country FROM Customers WHERE Country = "Germany"

2. Buatlah sebuah query untuk menampilkan result set data Harga Paling mahal dari product.

SELECT MAX(Price) FROM Products

3. Buatlah sebuah query untuk menampilkan result set data detail nama product yang paling mahal beserta harga nya.
SELECT 	ProductName,Price, MAX(Price) FROM Products

4. Buatlah sebuah query untuk menampilkan result set data detail product dengan harga termurah dari category beverages.

SELECT *
FROM Products
INNER JOIN Categories
WHERE CategoryName = "Beverages" 
AND Price =(
	SELECT MIN(Price) 
	FROM Products)

5. Buatlah sebuah query untuk menampilkan result set data berapa jumlah pesanan product Konbu.

SELECT COUNT(OrderID)
FROM OrderDetails
WHERE ProductID = (
	SELECT ProductID
	FROM Products
	WHERE ProductID=13
);

6. Buatlah sebuah query untuk menampilkan result set data Berapa harga rata rata dari semua product.

SELECT AVG(Price) as AveragePrice
FROM Products

7. Buatlah sebuah query untuk menampilkan result set data customer yang bukan dari amerika latin

SELECT *
FROM Customers
WHERE Country 
NOT LIKE "Brazil" 
AND Country 
NOT LIKE "Mexico" 
AND Country 
NOT LIKE "Argentina"
GROUP BY Country
ORDER BY CustomerID

8. Buatlah sebuah query untuk menampilkan result set data product yang harganya dibawah $100.

SELECT *
FROM Products
WHERE Price < 100
ORDER BY CategoryID

9. Buatlah sebuah query untuk menampilkan result set data detail customer yang berasal dari Germany atau France.

SELECT *
FROM Customers
WHERE Country 
LIKE "Germany" 
OR Country 
LIKE "France"
ORDER BY Country


10. Buatlah sebuah query untuk menampilkan result set data jumlah customer yang berasal dari USA

Query
SELECT COUNT(CustomerID) AS CustomerFromUSA
FROM Customers
WHERE Country='USA';

11. Buatlah sebuah query untuk menampilkan result set data customer yang berasal dari negara yang berakhiran "a"

SELECT *
FROM Customers
WHERE Country LIKE "%a";
12. Buatlah sebuah query untuk menampilkan result set data product yang harganya dibawah harga rata-rata.
SELECT *
FROM Products
WHERE Price < (
	SELECT
	AVG(Price)
	FROM
	Products
);

13. Buatlah sebuah query untuk menamplikan result set data Product yang berkategori beverages dan memiliki price diatas harga rata rata product.

SELECT *
FROM Products
WHERE CategoryID = (
	SELECT CategoryID
	FROM Categories
	WHERE CategoryID = 1
	)
AND Price > (
	SELECT AVG(Price)
	FROM Products
	);

14. Buatlah sebuah query untuk menamplikan result set data Order yang menggunakan Shipper Speedy Express.


15. Buatlah sebuah query untuk menamplikan result set data Product yang harganya dibawah Rata-rata Harga Product.
