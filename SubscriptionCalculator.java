package delfinen;

public class SubscriptionCalculator {
    private int paymentDue;
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