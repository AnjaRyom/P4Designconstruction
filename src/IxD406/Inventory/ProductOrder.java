package IxD406.Inventory;

/* The productOrder class is for the purpose of ordering products. This contains all the info that is needed for the order.
 * As it is an abstract class, it inherits all the the attributes from it's superclass. */

import java.util.Map;

public class ProductOrder {
        Map<String, Integer> articles;
        int hairSalonCustomerNo;
        String hairSalonAddress;
        String paymentInfo;
        String deliveryTime;
        String deliveryConditions;

    //Constructor

    public ProductOrder(Map<String, Integer> articles,
                        int hairSalonCustomerNo,
                        String hairSalonAddress,
                        String paymentInfo,
                        String deliveryTime,
                        String deliveryConditions) {
        this.articles = articles;
        this.numberOfProductsOrdered = numberOfProductsOrdered;
        this.hairSalonCustomerNo = hairSalonCustomerNo;
        this.hairSalonAddress = hairSalonAddress;
        this.paymentInfo = paymentInfo;
        this.deliveryTime = deliveryTime;
        this.deliveryConditions = deliveryConditions;
    }

    //Getters and setters

    public Map<String, Integer> getArticles() {
        return articles;
    }

    public void setArticles(Map<String, Integer> articles) {
        this.articles = articles;
    }

    public int getHairSalonCustomerNo() {
        return hairSalonCustomerNo;
    }

    public void setHairSalonCustomerNo(int hairSalonCustomerNo) {
        this.hairSalonCustomerNo = hairSalonCustomerNo;
    }

    public String getHairSalonAddress() {
        return hairSalonAddress;
    }

    public void setHairSalonAddress(String hairSalonAddress) {
        this.hairSalonAddress = hairSalonAddress;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryConditions() {
        return deliveryConditions;
    }

    public void setDeliveryConditions(String deliveryConditions) {
        this.deliveryConditions = deliveryConditions;
    }


}



