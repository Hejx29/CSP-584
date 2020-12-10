// import org.apache.commons.fileupload.FileItem;
// import org.apache.commons.fileupload.FileUploadException;
// import org.apache.commons.fileupload.disk.DiskFileItemFactory;
// import org.apache.commons.fileupload.servlet.ServletFileUpload;
// import org.apache.commons.io.IOUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@WebServlet("/StoreManagerHome")
public class StoreManagerHome extends HttpServlet {

    private String error_msg;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        displayStoreManagerHome(request, response, pw, "");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Utilities utility = new Utilities(request, pw);

        //Add New product
        Map<String, Object> map = new HashMap<String, Object>();

        //DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        String catalog;  
    }

    public boolean storeNewProduct(Map<String, Object> map) {
        String id = String.valueOf(map.get("id"));
        String name = String.valueOf(map.get("name"));
        double price = Double.parseDouble(String.valueOf(map.get("price")));
        String image = String.valueOf(map.get("image"));
        //String retailer = String.valueOf(map.get("manufacturer"));
        String condition = String.valueOf(map.get("condition"));
        double discount = Double.parseDouble(String.valueOf(map.get("discount")));
        String catalog = String.valueOf(map.get("productCatalog"));

        switch (catalog) {
            case "tv":
                TV tv = new TV();
                tv.setId(id);
                tv.setName(name);
                tv.setPrice(price);
                tv.setImage(image);
                //tv.setRetailer(retailer);
                tv.setCondition(condition);
                tv.setDiscount(discount);
                SaxParserDataStore.tvs.put(id, tv);
                return true;
            case "soundsystem":
                SoundSystem soundsystem = new SoundSystem();
                soundsystem.setId(id);
                soundsystem.setName(name);
                soundsystem.setPrice(price);
                soundsystem.setImage(image);
                //soundsystem.setRetailer(retailer);
                soundsystem.setCondition(condition);
                soundsystem.setDiscount(discount);
                SaxParserDataStore.soundsystems.put(id, soundsystem);
                return true;
            case "voice":
                Voice voice = new Voice();
                voice.setId(id);
                voice.setName(name);
                voice.setPrice(price);
                voice.setImage(image);
              //  voice.setRetailer(retailer);
                voice.setCondition(condition);
                voice.setDiscount(discount);
                SaxParserDataStore.voices.put(id, voice);
                return true;
            case "wearable":
                Wearable wearable = new Wearable();
                wearable.setId(id);
                wearable.setName(name);
                wearable.setPrice(price);
                wearable.setImage(image);
                //wearable.setRetailer(retailer);
                wearable.setCondition(condition);
                wearable.setDiscount(discount);
                SaxParserDataStore.wearables.put(id, wearable);
                return true;
            case "phone":
                Phone phone = new Phone();
                phone.setId(id);
                phone.setName(name);
                phone.setPrice(price);
                phone.setImage(image);
                //phone.setRetailer(retailer);
                phone.setCondition(condition);
                phone.setDiscount(discount);
                SaxParserDataStore.phones.put(id, phone);
                return true;
            case "laptop":
                Laptop laptop = new Laptop();
                laptop.setId(id);
                laptop.setName(name);
                laptop.setPrice(price);
                laptop.setImage(image);
                //laptop.setRetailer(retailer);
                laptop.setCondition(condition);
                laptop.setDiscount(discount);
                SaxParserDataStore.laptops.put(id, laptop);
                return true;

        }
        return false;
    }

    public boolean removeProduct(String productId, String catalog) {
        switch (catalog) {
            case "tv":
                SaxParserDataStore.tvs.remove(productId);
                return true;
            case "watch":

                SaxParserDataStore.soundsystems.remove(productId);
                return true;
            case "voice":

                SaxParserDataStore.voices.remove(productId);
                return true;
            case "wearable":

                SaxParserDataStore.wearables.remove(productId);
                return true;
            case "phone":

                SaxParserDataStore.phones.remove(productId);
                return true;
            case "laptop":

                SaxParserDataStore.laptops.remove(productId);
                return true;


        }
        return false;
    }

    public boolean updateProduct(String id, String name, String price, String manufacturer, String condition, String discount, String image, String catalog) {
        switch (catalog) {
            case "tv":
                TV tv = new TV();
                tv.setId(id);
                tv.setName(name);
                tv.setPrice(Double.parseDouble(price));
              //  tv.setRetailer(manufacturer);
                tv.setCondition(condition);
                tv.setDiscount(Double.parseDouble(discount));
                tv.setImage(image);
                SaxParserDataStore.tvs.remove(id);
                SaxParserDataStore.tvs.put(id, tv);

                return true;
            case "soundsystem":

                SoundSystem soundsystem = new SoundSystem();
                soundsystem.setId(id);
                soundsystem.setName(name);
                soundsystem.setPrice(Double.parseDouble(price));
              //  soundsystem.setRetailer(manufacturer);
                soundsystem.setCondition(condition);
                soundsystem.setDiscount(Double.parseDouble(discount));
                soundsystem.setImage(image);
                SaxParserDataStore.soundsystems.remove(id);
                SaxParserDataStore.soundsystems.put(id, soundsystem);
                return true;
            case "voice":

                Voice voice = new Voice();
                voice.setId(id);
                voice.setName(name);
                voice.setPrice(Double.parseDouble(price));
              //  voice.setRetailer(manufacturer);
                voice.setCondition(condition);
                voice.setDiscount(Double.parseDouble(discount));
                voice.setImage(image);
                SaxParserDataStore.voices.remove(id);
                SaxParserDataStore.voices.put(id, voice);
                return true;
            case "wearabel":

                Wearable wearable = new Wearable();
                wearable.setId(id);
                wearable.setName(name);
                wearable.setPrice(Double.parseDouble(price));
              //  wearable.setRetailer(manufacturer);
                wearable.setCondition(condition);
                wearable.setDiscount(Double.parseDouble(discount));
                wearable.setImage(image);
                SaxParserDataStore.wearables.remove(id);
                SaxParserDataStore.wearables.put(id, wearable);
                return true;
            case "phone":

                Phone phone = new Phone();
                phone.setId(id);
                phone.setName(name);
                phone.setPrice(Double.parseDouble(price));
              //  phone.setRetailer(manufacturer);
                phone.setCondition(condition);
                phone.setDiscount(Double.parseDouble(discount));
                phone.setImage(image);
                SaxParserDataStore.phones.remove(id);
                SaxParserDataStore.phones.put(id, phone);
                return true;
            case "laptop":

                Laptop laptop = new Laptop();
                laptop.setId(id);
                laptop.setName(name);
                laptop.setPrice(Double.parseDouble(price));
                //laptop.setRetailer(manufacturer);
                laptop.setCondition(condition);
                laptop.setDiscount(Double.parseDouble(discount));
                laptop.setImage(image);
                SaxParserDataStore.laptops.remove(id);
                SaxParserDataStore.laptops.put(id, laptop);
                return true;

        }
        return false;
    }


    private void displayStoreManagerHome(HttpServletRequest request,
                                         HttpServletResponse response, PrintWriter pw, String flag)
    {

        Utilities utility = new Utilities(request, pw);
        utility.printHtml("Header.html");
        utility.printHtml("LeftNavigationBar.html");

         pw.print("<div id='content'>");
          
         pw.print("<div class='post'>");
         pw.print("<h2 class='title meta'>");
         pw.print("<a style='font-size: 24px;'>Create new product</a></h2>");
         pw.print("</h3>");
         pw.print("<div class='entry'>");
//
        if (flag.equals("newProduct"))
            pw.print("<h4 style='color:red'>" + error_msg + "</h4>");
////////////////////////////////////////
            pw.print("<form action='CreateProduct' method='post'");
            pw.print("<table class='gridtable'><tr><td>");

            pw.print("Product ID:</td><td>");

            pw.print("<input type='text' name='productId' value=''>");
             pw.print("</td></tr><br>");
            // pw.print("<input type='hidden' name='catalog' value='" + catalog + "'>");
            // pw.print("<input type='hidden' name='image' value='" + image + "'>");

            pw.print("<tr><td>Product Name</td><td><input type='text' name='productName' value='' class='input' required>");
            pw.print("</td></tr>");
//
            pw.print("<tr><td>Product Catalog</td><td><select id='catalog' name='productCatalog' class='input'>" +
                  "<option value='tv' name='tv'selected>TV</option>" +
                  "<option value='soundsystem' name='soundsystem'>Soundsystem</option>" +
                  "<option value='voice' name='voice'>Voice Assistant</option>" +
                  "<option value='phone' name='phone'>Phone</option>" +
                  "<option value='laptop' name'laptop'>Laptop</option>" +
                  "<option value='wearable' name='wearable'>WearableTechnology</option>" +
                  "<option value='accessory' name='accessory'>Accessory</option>"
                  );
            pw.print("</select></td></tr>");
//
//
            pw.print("<tr><td>Price</td><td><input type='text' name='price' value='' class='input' required>");
            pw.print("</td></tr>");
            pw.print("<tr><td>Manufacturer</td><td><input type='text' name='manufacturer' value='' class='input' required></input>");
            pw.print("</td></tr><tr><td>");
//
            pw.print("<tr><td>Condition</td><td><select name='condition' class='input'>" +
                  "<option value='New' selected>New</option>" +
                  "<option value='Used'>Used</option>" +
                  "<option value='Refurbished'>Refurbished</option></select>");
            pw.print("</td></tr>");
//
            pw.print("<tr><td>Image</td><td><img id=\"preview\" /><br/><input type='file' name='image' class='input' required>");
            pw.print("</td></tr><tr><td>");
//
            pw.print("Discount</td><td><input type='text' name='discount' value='' class='input' required>");
            pw.print("</td></tr>");
//
            pw.print("<tr><td><input type='submit' class='btnbuy' value='Create' style='float: left;height: 20px margin: 20px; margin-right: 10px;'>");
            pw.print("</td></tr><tr><td></td><tr>");
            pw.print("</table>");
            pw.print("</form></div></div>");
//

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




        pw.print("<div class='post'>");
        // pw.print("<form method='post' action='RemoveUpdateProduct'>");
        pw.print("<h2 class='title meta'>");
        pw.print("<a style='font-size: 24px;'>View Products</a></h2>");
        pw.print("<div class='entry'>");
        pw.print("<table class='gridtable'>");

        if (flag.equals("RemoveUpdateProduct"))
            pw.print("<h4 style='color:red'>" + error_msg + "</h4>");



//        pw.print("<div align='left' style='float:left'>");
//        pw.print("<input type='submit' name='Product' value='Update Product' class='btnbuy'>");
//        pw.print("</div>");
//        pw.print("<div align='right'>");
//        pw.print("<input type='submit' name='Product' value='Remove Product' class='btnbuy'>");
//        pw.print("</div>");
//        pw.print("<br>");



        pw.print("<tr>");
        pw.print("<td>Product Name</td>");
        pw.print("<td>Price</td>");
      //  pw.print("<td>Manufacturer</td>");
        pw.print("<td>Condition</td>");
        pw.print("<td>Discount</td>");
        pw.print("<td>Catalog</td>");
        pw.print("</tr>");


        for (Map.Entry<String, TV> entry : SaxParserDataStore.tvs.entrySet()) {
            TV tv = entry.getValue();
            pw.print("<form method='post' action='RemoveUpdateProduct'>");
            pw.print("<tr>");
//            pw.print("<td><input type='radio' name='productId' value='" + tv.getId() + "'></td>");

            pw.print("<td>" + tv.getName() + "</td>" +
                    "<td>" + tv.getPrice() + "</td>" +
                    // "<td>" + tv.getRetailer() + "</td>" +
                    "<td>" + tv.getCondition() + "</td>" +
                    "<td>" + tv.getDiscount() + "</td>" +
                    "<td>TV </td>");

            pw.print("<input type='hidden' name='productId' value='" + tv.getId() + "'>");
            pw.print("<input type='hidden' name='productName' value='" + tv.getName() + "'>");
            pw.print("<input type='hidden' name='price' value='" + tv.getPrice() + "'>");
            // pw.print("<input type='hidden' name='manufacturer' value='" + tv.getRetailer() + "'>");
            pw.print("<input type='hidden' name='condition' value='" + tv.getCondition() + "'>");
            pw.print("<input type='hidden' name='discount' value='" + tv.getDiscount() + "'>");
            pw.print("<input type='hidden' name='productCatalog' value='tv'>");
            pw.print("<input type='hidden' name='image' value='" + tv.getImage() + "'>");
            pw.print("</tr>");

            pw.print("<tr>");
            pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
            pw.print("<td>");
            pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
            pw.print("</tr>");
            pw.print("</form>");
            //pw.print("<br>");
        }


        for (Map.Entry<String, SoundSystem> entry : SaxParserDataStore.soundsystems.entrySet()) {
            SoundSystem soundsystem = entry.getValue();
            pw.print("<form method='post' action='RemoveUpdateProduct'>");
            pw.print("<tr>");
            //pw.print("<td><input type='radio' name='productId' value='" + soundsystem.getId() + "'></td>");

            pw.print("<td>" + soundsystem.getName() + "</td>" +
                    "<td>" + soundsystem.getPrice() + "</td>" +
                    //"<td>" + soundsystem.getRetailer() + "</td>" +
                    "<td>" + soundsystem.getCondition() + "</td>" +
                    "<td>" + soundsystem.getDiscount() + "</td>" +
                    "<td>Soundsystem</td>");
            pw.print("<input type='hidden' name='productId' value='" + soundsystem.getId() + "'>");
            pw.print("<input type='hidden' name='productName' value='" + soundsystem.getName() + "'>");
            pw.print("<input type='hidden' name='price' value='" + soundsystem.getPrice() + "'>");
        //    pw.print("<input type='hidden' name='manufacturer' value='" + soundsystem.getRetailer() + "'>");
            pw.print("<input type='hidden' name='condition' value='" + soundsystem.getCondition() + "'>");
            pw.print("<input type='hidden' name='discount' value='" + soundsystem.getDiscount() + "'>");
            pw.print("<input type='hidden' name='productCatalog' value='soundsystem'>");
            pw.print("<input type='hidden' name='image' value='" + soundsystem.getImage() + "'>");
            pw.print("</tr>");

            pw.print("<tr>");
            pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
            pw.print("<td>");
            pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
            pw.print("</tr>");
            pw.print("</form>");
        }



        for (Map.Entry<String, Voice> entry : SaxParserDataStore.voices.entrySet()) {
            Voice voice = entry.getValue();
            pw.print("<form method='post' action='RemoveUpdateProduct'>");
            pw.print("<tr>");
            // pw.print("<td><input type='radio' name='productId' value='" + voice.getId() + "'></td>");
            pw.print("<td>" + voice.getName() + "</td>" +
                    "<td>" + voice.getPrice() + "</td>" +
                  //  "<td>" + voice.getRetailer() + "</td>" +
                    "<td>" + voice.getCondition() + "</td>" +
                    "<td>" + voice.getDiscount() + "</td>" +
                    "<td>voice</td>");
            pw.print("<input type='hidden' name='productId' value='" + voice.getId() + "'>");
            pw.print("<input type='hidden' name='productName' value='" + voice.getName() + "'>");
            pw.print("<input type='hidden' name='price' value='" + voice.getPrice() + "'>");
          //  pw.print("<input type='hidden' name='manufacturer' value='" + voice.getRetailer() + "'>");
            pw.print("<input type='hidden' name='condition' value='" + voice.getCondition() + "'>");
            pw.print("<input type='hidden' name='discount' value='" + voice.getDiscount() + "'>");
            pw.print("<input type='hidden' name='productCatalog' value='voice'>");
            pw.print("<input type='hidden' name='image' value='" + voice.getImage() + "'>");
            pw.print("</tr>");
            pw.print("<tr>");
            pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
            pw.print("<td>");
            pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
            pw.print("</tr>");
            pw.print("</form>");
        }

         //Pet Tracker
        for (Map.Entry<String, Wearable> entry : SaxParserDataStore.wearables.entrySet()) {
            Wearable pettracker = entry.getValue();
            pw.print("<form method='post' action='RemoveUpdateProduct'>");
            pw.print("<tr>");
            // pw.print("<td><input type='radio' name='productId' value='" + wearable.getId() + "'></td>");

            pw.print("<td>" + pettracker.getName() + "</td>" +
                    "<td>" + pettracker.getPrice() + "</td>" +
              //      "<td>" + wearable.getRetailer() + "</td>" +
                    "<td>" + pettracker.getCondition() + "</td>" +
                    "<td>" + pettracker.getDiscount() + "</td>" +
                    "<td>Wearable</td>");
            pw.print("<input type='hidden' name='productId' value='" + pettracker.getId() + "'>");
            pw.print("<input type='hidden' name='productName' value='" + pettracker.getName() + "'>");
            pw.print("<input type='hidden' name='price' value='" + pettracker.getPrice() + "'>");
          //  pw.print("<input type='hidden' name='manufacturer' value='" + wearable.getRetailer() + "'>");
            pw.print("<input type='hidden' name='condition' value='" + pettracker.getCondition() + "'>");
            pw.print("<input type='hidden' name='discount' value='" + pettracker.getDiscount() + "'>");
            pw.print("<input type='hidden' name='productCatalog' value='pettracker'>");
            pw.print("<input type='hidden' name='image' value='" + pettracker.getImage() + "'>");
            pw.print("</tr>");
            pw.print("<tr>");
            pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
            pw.print("<td>");
            pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
            pw.print("</tr>");
            pw.print("</form>");
        }

         //Phone
        for (Map.Entry<String, Phone> entry : SaxParserDataStore.phones.entrySet()) {
            Phone phone = entry.getValue();
            pw.print("<form method='post' action='RemoveUpdateProduct'>");
            pw.print("<tr>");
            // pw.print("<td><input type='radio' name='productId' value='" + phone.getId() + "'></td>");

            pw.print("<td>" + phone.getName() + "</td>" +
                    "<td>" + phone.getPrice() + "</td>" +
                  //  "<td>" + phone.getRetailer() + "</td>" +
                    "<td>" + phone.getCondition() + "</td>" +
                    "<td>" + phone.getDiscount() + "</td>" +
                    "<td>Phone</td>");
            pw.print("<input type='hidden' name='productId' value='" + phone.getId() + "'>");
            pw.print("<input type='hidden' name='productName' value='" + phone.getName() + "'>");
            pw.print("<input type='hidden' name='price' value='" + phone.getPrice() + "'>");
          //  pw.print("<input type='hidden' name='manufacturer' value='" + phone.getRetailer() + "'>");
            pw.print("<input type='hidden' name='condition' value='" + phone.getCondition() + "'>");
            pw.print("<input type='hidden' name='discount' value='" + phone.getDiscount() + "'>");
            pw.print("<input type='hidden' name='productCatalog' value='phone'>");
            pw.print("<input type='hidden' name='image' value='" + phone.getImage() + "'>");
            pw.print("</tr>");
            pw.print("<tr>");
            pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
            pw.print("<td>");
            pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
            pw.print("</tr>");
            pw.print("</form>");
        }

         //Laptop
        for (Map.Entry<String, Laptop> entry : SaxParserDataStore.laptops.entrySet()) {
            Laptop laptop = entry.getValue();
            pw.print("<form method='post' action='RemoveUpdateProduct'>");
            pw.print("<tr>");
            //pw.print("<td><input type='radio' name='productId' value='" + laptop.getId() + "'></td>");

            pw.print("<td>" + laptop.getName() + "</td>" +
                    "<td>" + laptop.getPrice() + "</td>" +
                  //  "<td>" + laptop.getRetailer() + "</td>" +
                    "<td>" + laptop.getCondition() + "</td>" +
                    "<td>" + laptop.getDiscount() + "</td>" +
                    "<td>Laptop</td>");
            pw.print("<input type='hidden' name='productId' value='" + laptop.getId() + "'>");
            pw.print("<input type='hidden' name='productName' value='" + laptop.getName() + "'>");
            pw.print("<input type='hidden' name='price' value='" + laptop.getPrice() + "'>");
            // pw.print("<input type='hidden' name='manufacturer' value='" + laptop.getRetailer() + "'>");
            pw.print("<input type='hidden' name='condition' value='" + laptop.getCondition() + "'>");
            pw.print("<input type='hidden' name='discount' value='" + laptop.getDiscount() + "'>");
            pw.print("<input type='hidden' name='productCatalog' value='laptop'>");
            pw.print("<input type='hidden' name='image' value='" + laptop.getImage() + "'>");
            pw.print("</tr>");
            pw.print("<tr>");
            pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
            pw.print("<td>");
            pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
            pw.print("</tr>");
            pw.print("</form>");
        }

         //Voice Assistant
        

          //Accessory
          for (Map.Entry<String, Accessory> entry : SaxParserDataStore.accessories.entrySet()) {
              Accessory accessory = entry.getValue();
              pw.print("<form method='post' action='RemoveUpdateProduct'>");
              pw.print("<tr>");
              // pw.print("<td><input type='radio' name='productId' value='" + accessory.getId() + "'></td>");

              pw.print("<td>" + accessory.getName() + "</td>" +
                      "<td>" + accessory.getPrice() + "</td>" +
                    //  "<td>" + accessory.getRetailer() + "</td>" +
                      "<td>" + accessory.getCondition() + "</td>" +
                      "<td>" + accessory.getDiscount() + "</td>" +
                      "<td>Accessory</td>");
              pw.print("<input type='hidden' name='productId' value='" + accessory.getId() + "'>");
              pw.print("<input type='hidden' name='productName' value='" + accessory.getName() + "'>");
              pw.print("<input type='hidden' name='price' value='" + accessory.getPrice() + "'>");
              //pw.print("<input type='hidden' name='manufacturer' value='" + accessory.getRetailer() + "'>");
              pw.print("<input type='hidden' name='condition' value='" + accessory.getCondition() + "'>");
              pw.print("<input type='hidden' name='discount' value='" + accessory.getDiscount() + "'>");
              pw.print("<input type='hidden' name='productCatalog' value='accessory'>");
              pw.print("<input type='hidden' name='image' value='" + accessory.getImage() + "'>");
              pw.print("</tr>");
              pw.print("<tr>");
              pw.print("<td><div align=\"left\" style=\"float:left\"><input type='submit' name='Product' value='Update' class='btnbuy'></div></td>");
              pw.print("<td>");
              pw.print("<div align=\"right\"><input type='submit' name='Product' value='Remove' class='btnbuy'></div></td>");
              pw.print("</tr>");
              pw.print("</form>");
          }
         
        pw.print("</table>");
        pw.print("</div></div></div>");
        
        utility.printHtml("Footer.html");

    }
}
