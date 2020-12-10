
1.install MYSQL and MONGODB
2.put mongo-java-driver-3.2.2.jar,mysql-connector-java-8.0.20.jar,gson-2.6.2.jar under Tomcat/bin 
3.Start MySQL Server
4.Start Mongod.exe and mongo.exe
5.Navigate to the class file folder Store\WEB-INF\classes
6.Run the java files javac *.java
7.Schema Name : example database
Tables - orders, user, productdetails,CustomerAddress,StroeLocation
orders - Order and transaction details
user - username, password and user related details
CustomerAddress-customers' userId,steet,city,state,zipcode
StroeLocation- StoreId,steet,city,state,zipcode
product details - all product related details including product name,id, price, etc.
8. Schema Name : CustomerReview
Tables:myReview
myReview:Order and review details
9.go to browser and type http://localhost/WebStore/