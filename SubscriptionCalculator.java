package delfinen;

import java.util.Date;

public class SubscriptionCalculator {
    private int paymentDue;
    private int amountDue;
    private Member owner;
    private double price;

    public SubscriptionCalculator(Member owner){
        paymentDue = 2018;
        this.owner = owner;
        calculateSubscription();
    }

    public double getPrice() {
        calculateSubscription();
        return price;
    }
    public void registerPayment(){
        paymentDue += 1;
    }
    public int getPaymentDue() {
        return paymentDue;
    }
    public void setPaymentDue(int paymentDue) {
        this.paymentDue = paymentDue;
    }
    public int getAmountDue() {
        return amountDue;
    }
    public void setAmountDue(int amountDue) {
        this.amountDue = amountDue;
    }
    public void calculateSubscription(){
        price = 1000;
        if (owner.getAge() >= 18){
            price += 600;
        }
        if (owner.getAge() >= 60) {
            price = price * 0.75;
        }
        if (owner.isActive() == false) {
            price = 500;
        }
    }
}