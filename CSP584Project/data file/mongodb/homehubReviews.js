/*
 Navicat Premium Data Transfer

 Source Server         : local_mongdb
 Source Server Type    : MongoDB
 Source Server Version : 30222
 Source Host           : localhost:27017
 Source Schema         : homehubReviews

 Target Server Type    : MongoDB
 Target Server Version : 30222
 File Encoding         : 65001

 Date: 06/12/2020 19:04:34
*/


// ----------------------------
// Collection structure for myReviews
// ----------------------------
db.getCollection("myReviews").drop();
db.createCollection("myReviews");

// ----------------------------
// Documents of myReviews
// ----------------------------
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e0ca5c810f1295b57c65"),
    title: "myReviews",
    ProductName: "hammer",
    ProductType: "Tool",
    TotalPrice: "10.99",
    StoreID: "HomeHub",
    StoreZip: "60615",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "1",
    UserAge: NumberInt("30"),
    UserGender: "male",
    UserOccupation: "Teacher",
    ReviewRating: NumberInt("5"),
    ReviewDate: "2020-12-10",
    ReviewText: " good quality",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e1035c810f1295b57c68"),
    title: "myReviews",
    ProductName: "Knot Filling & Wood Repair Kit",
    ProductType: "Tool",
    TotalPrice: "170.0",
    StoreID: "HomeHub",
    StoreZip: "60618",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "1",
    UserAge: NumberInt("30"),
    UserGender: "male",
    UserOccupation: "Teacher",
    ReviewRating: NumberInt("3"),
    ReviewDate: "2021-01-03",
    ReviewText: " a little bit expensive",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e12b5c810f1295b57c6b"),
    title: "myReviews",
    ProductName: "pliers",
    ProductType: "Tool",
    TotalPrice: "12.99",
    StoreID: "HomeHub",
    StoreZip: "60618",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "1",
    UserAge: NumberInt("30"),
    UserGender: "male",
    UserOccupation: "Teacher",
    ReviewRating: NumberInt("4"),
    ReviewDate: "2020-12-08",
    ReviewText: " good",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e1cc5c810f1295b57c6e"),
    title: "myReviews",
    ProductName: "shovel",
    ProductType: "Tool",
    TotalPrice: "12.99",
    StoreID: "HomeHub",
    StoreZip: "60615",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "2",
    UserAge: NumberInt("23"),
    UserGender: "female",
    UserOccupation: "Student",
    ReviewRating: NumberInt("1"),
    ReviewDate: "2020-12-06",
    ReviewText: " dislike",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e1fa5c810f1295b57c71"),
    title: "myReviews",
    ProductName: "Anti-tip Wall Anchor Kit",
    ProductType: "Tool",
    TotalPrice: "11.99",
    StoreID: "HomeHub",
    StoreZip: "60615",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "2",
    UserAge: NumberInt("23"),
    UserGender: "female",
    UserOccupation: "Student",
    ReviewRating: NumberInt("2"),
    ReviewDate: "2020-12-09",
    ReviewText: " not good enough",
    OrderStatus: "Disputed",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e2225c810f1295b57c74"),
    title: "myReviews",
    ProductName: "Wood Markers",
    ProductType: "Tool",
    TotalPrice: "7.99",
    StoreID: "HomeHub",
    StoreZip: "60615",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "2",
    UserAge: NumberInt("23"),
    UserGender: "female",
    UserOccupation: "Student",
    ReviewRating: NumberInt("5"),
    ReviewDate: "2020-12-12",
    ReviewText: " good product",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e2475c810f1295b57c76"),
    title: "myReviews",
    ProductName: "Floor Repair",
    ProductType: "Tool",
    TotalPrice: "22.99",
    StoreID: "HomeHub",
    StoreZip: "60615",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "2",
    UserAge: NumberInt("23"),
    UserGender: "female",
    UserOccupation: "Student",
    ReviewRating: NumberInt("5"),
    ReviewDate: "2020-12-12",
    ReviewText: " goog",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e28a5c810f1295b57c78"),
    title: "myReviews",
    ProductName: "Anti-tip Wall Anchor Kit",
    ProductType: "Tool",
    TotalPrice: "35.97",
    StoreID: "HomeHub",
    StoreZip: "60616",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "3",
    UserAge: NumberInt("35"),
    UserGender: "female",
    UserOccupation: "Accountant",
    ReviewRating: NumberInt("5"),
    ReviewDate: "2020-12-11",
    ReviewText: " good",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e2f35c810f1295b57c7d"),
    title: "myReviews",
    ProductName: "pliers",
    ProductType: "Tool",
    TotalPrice: "12.99",
    StoreID: "HomeHub",
    StoreZip: "60616",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "3",
    UserAge: NumberInt("35"),
    UserGender: "female",
    UserOccupation: "Accountant",
    ReviewRating: NumberInt("5"),
    ReviewDate: "2020-12-05",
    ReviewText: " I will buy it again. nice!",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e48b5c810f1295b57c7f"),
    title: "myReviews",
    ProductName: "hammer",
    ProductType: "Tool",
    TotalPrice: "10.99",
    StoreID: "HomeHub",
    StoreZip: "60615",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "4",
    UserAge: NumberInt("18"),
    UserGender: "male",
    UserOccupation: "Programmer",
    ReviewRating: NumberInt("1"),
    ReviewDate: "2020-12-05",
    ReviewText: " bad",
    OrderStatus: "Approved",
    OrderReturn: "Yes"
} ]);
db.getCollection("myReviews").insert([ {
    _id: ObjectId("5fc9e6225c810f1295b57c81"),
    title: "myReviews",
    ProductName: "WOOD CARVING TOOL SET",
    ProductType: "Tool",
    TotalPrice: "22.99",
    StoreID: "HomeHub",
    StoreZip: "60616",
    StoreCity: "Chicago",
    StoreState: "IL",
    UserID: "3",
    UserAge: NumberInt("35"),
    UserGender: "female",
    UserOccupation: "Accountant",
    ReviewRating: NumberInt("3"),
    ReviewDate: "2020-12-12",
    ReviewText: " not very good",
    OrderStatus: "Approved",
    OrderReturn: "No"
} ]);
