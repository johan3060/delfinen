import java.util.ArrayList;
import java.util.Scanner;

public class Delfinen {
    private static ArrayList<Discipline> disciplines = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static User activeUser;
    private static ArrayList<String> menuOptions = new ArrayList<>();
    private static ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args){
        // Test flow
        generateUsers();
        activeUser = users.get(0);
        generateMembers();
        listMembers();



        /* Real flow
        generateUsers();
        login();
        generateMenuOptions();
        registerMember();
        */

    }
    private static void generateUsers(){
        users.add(new User("Chairman", "123", "chairman"));
        users.add(new User("Trainer", "abc", "trainer"));
        users.add(new User("Cashier", "food", "cashier"));
    }
    private static void generateMembers(){
        members.add(new Member("Peter", 11,true,true));
        members.add(new Member("Uffe", 32,true,true));
        members.add(new Member("Mads", 12,false,true));
        members.add(new Member("Morten", 10,true,false));
    }
    private static void login() {
        int i = 0;
        System.out.println("Choose a user");
        for (User u : users){
            System.out.println(i + " " + u.getUsername());
            i++;
        }
        int input = scanner.nextInt();
        System.out.println("Enter your password:");
        String passwordInput = scanner.next();

        if (users.get(input).getPassword().equals(passwordInput)){
            System.out.println("Login successful");
            activeUser = users.get(input);
        } else {
            System.out.println("Login failed");
        }
    }
    private static void generateMenuOptions(){
        switch (activeUser.getClearance()) {
            case "chairman":
                System.out.println("1. Register new member");
                System.out.println("2. Delete member");
                System.out.println("3. Display list of members");
                break;
            case "trainer":
                System.out.println("1. Register swim time");
                System.out.println("2. List swim times");
                System.out.println("3. Display list of members");
                break;
            case "cashier":
                System.out.println("1. Register payment");
                System.out.println("2. List delayed payments");
                System.out.println("3. Display list of members");
                break;
        }


    }
    private static void registerMember() {
        System.out.println("Enter a name");
        String name = scanner.next();
        System.out.println("Enter an age");
        int age = scanner.nextInt();
        System.out.println("Is the member an active member?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int active = scanner.nextInt();
        boolean activeBoolean = false;
        if (active == 1)
            activeBoolean = true;
        boolean competitiveBoolean = false;
        System.out.println("Is the member a competitor?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int competitive = scanner.nextInt();
        if (competitive == 1)
            competitiveBoolean = true;
        members.add(new Member(name, age, activeBoolean, competitiveBoolean));
    }
    private static void deleteMember(){
        int i = 0;
        for (Member m : members) {
            System.out.println(i + ". " + m.toString());
            i++;
        }
        System.out.println("Enter the index you want to delete.");
        int input = scanner.nextInt();
        System.out.println("You have selected: " + input + " " + members.get(input).toString());
        System.out.println("Are you sure you want to delete? ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int confirm = scanner.nextInt();
        if (confirm == 1) {
            members.remove(input);
            System.out.println("Member deleted successfully.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    private static void listMembers(){
        for (Member m : members) {
        System.out.println(m.toString());
        }
    }







}
