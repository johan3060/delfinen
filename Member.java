package delfinen;

public class Member {
    private int age;
    private String name;
    private boolean competitive;
    private boolean active;
    private SubscriptionCalculator subscriptionCalculator;

    public Member(String name, int age, boolean active, boolean competitive) {
        this.age = age;
        this.name = name;
        this.active = active;
        this.competitive = competitive;
        this.subscriptionCalculator = new SubscriptionCalculator(this);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public SubscriptionCalculator getSubscriptionCalculator() {
        return subscriptionCalculator;
    }

    public String toString(){
        String competitiveString;
        String activeString;
        String stringOutput = "";
        stringOutput += "Name: " + name + ", ";
        stringOutput += "age: " + age + ", ";
        if (active == true){
            activeString = "yes";
        }
        else {
            activeString = "no";
        }
        stringOutput += "is active: " + activeString + ", ";
        if (competitive == true){
            competitiveString = "yes";
        }
        else {
            competitiveString = "no";
        }
        stringOutput += "is competetive: " + competitiveString;
        stringOutput += ", subscription price: " + subscriptionCalculator.getPrice() + " kr.";

        return stringOutput;
    }
}