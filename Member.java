import java.util.ArrayList;

public class Member {
    private int id;
    private int age;
    private String name;
    private boolean competitive;
    private boolean active;
    private ArrayList<Discipline> disciplines;
    private SubscriptionCalculator subsciptionCalculator;

    public Member(String name, int age, boolean active, boolean competitive) {
        this.age = age;
        this.name = name;
        this.active = active;
        this.competitive = competitive;

        this.disciplines = new ArrayList<>();
        this.subsciptionCalculator = new SubscriptionCalculator(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(ArrayList<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public SubscriptionCalculator getSubsciptionCalculator() {
        return subsciptionCalculator;
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

        return stringOutput;
    }
}