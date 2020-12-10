import Bean.Bestrating;
import Bean.MostSold;
import Bean.Mostsoldzip;
import Bean.Review;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBObject; 
import com.mongodb.util.JSON;

import java.util.*;

public class MongoDBDataStoreUtilities {
    static DBCollection myReviews;

    public static DBCollection getConnection() {
        MongoClient mongo;
        mongo = new MongoClient("localhost", 27017);
        DB db = mongo.getDB("homehubReviews");
        myReviews = db.getCollection("myReviews");
        return myReviews;
    }

    public static void main(String[] args) {

        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    public static String insertReview(String productName, String type, String price, String storeID, String storeZip, String storeCity, String storeState,
                                      String userID, String userAge, String userGender, String userOccupation, String Rating, String reviewDate, String reviewText) {
        try {
            getConnection();
            BasicDBObject doc = new BasicDBObject("title", "myReviews").
                    append("ProductName", productName).
                    append("ProductType", type).
                    append("TotalPrice", price).

                    append("StoreID", storeID).
                    append("StoreZip", storeZip).
                    append("StoreCity", storeCity).
                    append("StoreState", storeState).


                    append("UserID", userID).
                    append("UserAge", Integer.parseInt(userAge)).
                    append("UserGender", userGender).
                    append("UserOccupation", userOccupation).

                    append("ReviewRating", Integer.parseInt(Rating)).
                    append("ReviewDate", reviewDate).
                    append("ReviewText", reviewText);
            myReviews.insert(doc);
            return "Successful";
        } catch (Exception e) {
            return "UnSuccessful";
        }

    }

    public static HashMap<String, ArrayList<Review>> selectReview() {
        HashMap<String, ArrayList<Review>> reviews;
        try {
            getConnection();
            DBCursor cursor = myReviews.find();
            reviews = new HashMap();
            while (cursor.hasNext()) {
                //create a query
                BasicDBObject obj = (BasicDBObject) cursor.next();
                if (!reviews.containsKey(obj.getString("UserID"))) {
                    ArrayList<Review> arr = new ArrayList<Review>();
                    reviews.put(obj.getString("UserID"), arr);
                }
                
                ArrayList<Review> listReview = reviews.get(obj.getString("UserID"));
                Review review = new Review(obj.getString("UserID"), obj.getString("ProductName"), obj.getString("ProductType"), obj.getString("TotalPrice"), obj.getString("StoreID"), obj.getString("StoreZip"),
                        obj.getString("StoreCity"), obj.getString("StoreState"), obj.getString("UserAge"), obj.getString("UserGender"), obj.getString("UserOccupation"), obj.getString("ReviewRating"), obj.getString("ReviewDate"), obj.getString("ReviewText"));
                //add to review hashmap
                listReview.add(review);

            }
            return reviews;
        } catch (Exception e) {
            reviews = null;
            return reviews;
        }
    }
    
    public static ArrayList<Bestrating> topProducts() {
        ArrayList<Bestrating> Bestrate = new ArrayList<Bestrating>();
        try {

            getConnection();
            int retlimit = 5;
            DBObject sort = new BasicDBObject();
            sort.put("ReviewRating", -1);
            DBCursor cursor = myReviews.find().limit(retlimit).sort(sort);
            while (cursor.hasNext()) {
                BasicDBObject obj = (BasicDBObject) cursor.next();

                String prodcutnm = obj.getString("ProductName");
                String rating = obj.getString("ReviewRating");
                Bestrating best = new Bestrating(prodcutnm, rating);
                Bestrate.add(best);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Bestrate;
    }
    @SuppressWarnings("deprecation")
    public static ArrayList<MostSold> mostsoldProducts() {
        ArrayList<MostSold> mostsold = new ArrayList<MostSold>();
        try {
            getConnection();
            DBObject groupProducts = new BasicDBObject("_id", "$ProductName");
            groupProducts.put("count", new BasicDBObject("$sum", 1));
            DBObject group = new BasicDBObject("$group", groupProducts);
            DBObject limit = new BasicDBObject();
            limit = new BasicDBObject("$limit", 5);

            DBObject sortFields = new BasicDBObject("count", -1);
            DBObject sort = new BasicDBObject("$sort", sortFields);
            AggregationOutput output = myReviews.aggregate(group, sort, limit);

            for (DBObject res : output.results()) {

                String productName = (res.get("_id")).toString();
                String count = (res.get("count")).toString();
                MostSold mostsld = new MostSold(productName, count);
                mostsold.add(mostsld);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mostsold;

    }
    @SuppressWarnings("deprecation")
	public static ArrayList<Mostsoldzip> mostsoldZip() {
        ArrayList<Mostsoldzip> mostsoldzip = new ArrayList<Mostsoldzip>();
        try {
            System.out.println("top5");
            getConnection();
            DBObject groupProducts = new BasicDBObject("_id", "$StoreZip");
            groupProducts.put("count", new BasicDBObject("$sum", 1));

           DBObject group = new BasicDBObject("$group", groupProducts);
            DBObject limit = new BasicDBObject();
            limit = new BasicDBObject("$limit", 5);

            DBObject sortFields = new BasicDBObject("count", -1);
            DBObject sort = new BasicDBObject("$sort", sortFields);
            @SuppressWarnings("deprecation")
			AggregationOutput output = myReviews.aggregate(group, sort, limit);


            for (DBObject res : output.results()) {
                System.out.println(res);
                String zipcode = (res.get("_id")).toString();
                String count = (res.get("count")).toString();
                Mostsoldzip mostsldzip = new Mostsoldzip(zipcode, count);
                mostsoldzip.add(mostsldzip);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mostsoldzip;
    }

}