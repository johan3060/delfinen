import java.util.ArrayList;

public class Member {
    private int id;
    private int age;
    private String name;
    private boolean active;
    private ArrayList<Discipline> disciplines;
    private SubscriptionCalculator subsciptionCalculator;

    public Member(int id, int age, String name, boolean active) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.active = active;

        disciplines = new ArrayList<>();
        subsciptionCalculator = new SubscriptionCalculator(this);
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

}
