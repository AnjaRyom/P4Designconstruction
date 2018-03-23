package com.company;

/* The productOrder class is for the purpose of ordering products. This contains all the info that is needed for the order.
 * As it is an abstract class, it inherits all the the attributes from it's superclass. */

public class ProductOrder {
        int numberOfProductsOrdered;
        int hairSalonCustomerNo;
        String hairSalonAddress;
        String paymentInfo;
        String deliveryTime;
        String deliveryConditions;

    //Constructor

    public ProductOrder(int numberOfProductsOrdered,
                        int hairSalonCustomerNo,
                        String hairSalonAddress,
                        String paymentInfo,
                        String deliveryTime,
                        String deliveryConditions) {
        this.numberOfProductsOrdered = numberOfProductsOrdered;
        this.hairSalonCustomerNo = hairSalonCustomerNo;
        this.hairSalonAddress = hairSalonAddress;
        this.paymentInfo = paymentInfo;
        this.deliveryTime = deliveryTime;
        this.deliveryConditions = deliveryConditions;
    }

    //Getters and setters
        public int getNumberOfProductsOrdered() {
            return numberOfProductsOrdered;
        }

        public void setNumberOfProductsOrdered(int numberOfProductsOrdered) { this.numberOfProductsOrdered = numberOfProductsOrdered; }

        public int getHairSalonCustomerNo() {
            return hairSalonCustomerNo;
        }

        public void setHairSalonCustomerNo(int hairSalonCustomerNo) {
            this.hairSalonCustomerNo = hairSalonCustomerNo;
        }

        public String getHairSalonAddress() {
            return hairSalonAddress;
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



