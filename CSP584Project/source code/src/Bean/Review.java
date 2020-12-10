package Bean;

public class Review {
    private String productname;
    private String producttype;
    private String price;
    private String storeid;
    private String storezip;
    private String storecity;
    private String storestate;
    private String userid;
    private String userage;
    private String usergender;
    private String userOccupation;
    private String rate;
    private String reviewDate;
    private String reviewText;

    public Review(String userid, String productname, String producttype, String price, String storeid, String storezip, String storecity, String storestate, String userage, String usergender, String userOccupation, String rate, String reviewDate, String reviewText) {
        this.userid = userid;
        this.productname = productname;
        this.producttype = producttype;
        this.price = price;
        this.storeid = storeid;
        this.storezip = storezip;
        this.storecity = storecity;
        this.storestate = storestate;
        this.userage = userage;
        this.usergender = usergender;
        this.userOccupation = userOccupation;
        this.rate = rate;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getStorezip() {
        return storezip;
    }

    public void setStorezip(String storezip) {
        this.storezip = storezip;
    }

    public String getStorecity() {
        return storecity;
    }

    public void setStorecity(String storecity) {
        this.storecity = storecity;
    }

    public String getStorestate() {
        return storestate;
    }

    public void setStorestate(String storestate) {
        this.storestate = storestate;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getUsergender() {
        return usergender;
    }

    public void setUsergender(String usergender) {
        this.usergender = usergender;
    }

    public String getUserOccupation() {
        return userOccupation;
    }

    public void setUserOccupation(String userOccupation) {
        this.userOccupation = userOccupation;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
