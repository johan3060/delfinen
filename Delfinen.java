package delfinen;

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
        generateUsers();
        generateDisciplin();
        generateMembers();
        
        int option;
        boolean keepRunning = true;
        
        login();
        
           while (keepRunning){
              //print menu
              System.out.println("1. Register new member");
              System.out.println("2. Delete member");
              System.out.println("3. List members");
              System.out.println("4. Register swim time");
              System.out.println("5. List swim times");
              System.out.println("6. Exit");
              option = getInt("Pick a number (1-6): ");

              switch (option){
                  case 1:
                     if (activeUser.getClearance() == "chairman"){
                        registerMember();
                     }
                     else {
                        System.out.println("Not authorized");
                     }
                     break;

                  case 2:
                     if (activeUser.getClearance() == "chairman"){
                        deleteMember();
                     }
                     else {
                        System.out.println("Not authorized");
                     }
                     break;

                  case 3:
                     listMembers();
                     break;

                  case 4:
                     if (activeUser.getClearance() == "trainer"){
                        registerSwimTime();
                     }
                     else {
                        System.out.println("Not authorized");
                     }
                     break;

                  case 5:
                     System.out.println("Listing swim times");
                     if (activeUser.getClearance() == "trainer"){
                        listDisciplineTimes();
                     }
                     else {
                        System.out.println("Not authorized");
                     }
                     break;

                  case 6:
                     System.out.println("Exiting");
                     System.exit(0);

                  default:
                     System.out.println("You must choose a number (0-5)");
           }
      }
   }
   
   public static int getInt(String prompt){
      Scanner scanInt = new Scanner (System.in);
      System.out.print(prompt);
      //anti Jarl scan.hasNextInt()
      while (!scanInt.hasNextInt()){
      //smid det n�ste v�k n�r det ikke er en int
         scanInt.next();
      //vejleder brugeren
      System.out.print(prompt);
      }      
      return scanInt.nextInt();
      }
   private static void generateDisciplin(){
      disciplines.add(new Discipline("Crawl"));
      disciplines.add(new Discipline("Stroke"));
      disciplines.add(new Discipline("Backstroke"));
      disciplines.add(new Discipline("Butterfly"));
   }
   private static void registerSwimTime(){
      int inputDiscipline = 1;
      int inputTime;
      int inputNameNumber;
      Member inputMember = null;
      boolean goAgain = false;
         System.out.println("Registering swim time...");
      do
      { 
         System.out.println("Choose one of the following members"); 
         listMemberNames();
         try {
            inputNameNumber = scanner.nextInt();
            inputMember = members.get(inputNameNumber-1);
            System.out.println("You have choosen " + inputMember.getName());
          
            
            goAgain = false;
         }
         catch(Exception e){
            System.out.println("Do only choose a number which displays on the list");
            goAgain = true;
         }
      }
   
      
      while(goAgain);
      
      do
      { 
         
         System.out.println("Choose one of the following disciplines");
         listDisciplines();
         try {
            inputDiscipline = scanner.nextInt();
         //If user enters out of range, will have an error!
            System.out.println("You have choosen " + disciplines.get(inputDiscipline-1).getName());
            goAgain = false;
         }
         catch(Exception e){
            System.out.println("Do only choose a number which displays on the list");
            goAgain = true;
         }
      }
      while(goAgain);
      System.out.println("Enter the time for your choosen disciplin (in seconds)");
      inputTime = scanner.nextInt();

      disciplines.get(inputDiscipline-1).addTime(inputTime, inputMember);
      System.out.println("The swim time has been successfully registered");
      
      }
   private static void listDisciplines(){
      int i = 1;
      for (Discipline d : disciplines){
         System.out.println(i + ". " + d.getName() + ".");
         i++;
      }
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
      int i = 1;
      System.out.println("Choose a user");
      for (User u : users){
         System.out.println(i + " " + u.getUsername());
         i++;
      }
      int input = scanner.nextInt() - 1;
      System.out.println("Enter your password:");
      String passwordInput = scanner.next();
   
      if (users.get(input).getPassword().equals(passwordInput)){
         System.out.println("Login successful");
         activeUser = users.get(input);
      } else {
         System.out.println("Login failed");
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
   private static void listMemberNames(){
      int i = 1;
      for (Member m : members){
         System.out.println(i + ": " + m.getName());
         i++;
      }
   }
   private static void listDisciplineTimes(){
      boolean goAgain;
      int inputDisciplineNumber;
      Discipline disciplineInput = new Discipline("placeholder");
      do
      { 
         
         System.out.println("Which discipline would you like to see all times for?");
         listDisciplines();
         try {
            inputDisciplineNumber = scanner.nextInt();
            disciplineInput = disciplines.get(inputDisciplineNumber-1);
         //If user enters out of range, will have an error!
            System.out.println("You have choosen " + disciplineInput.getName());
            disciplineInput.sortTimes();
            goAgain = false;
         }
         catch(Exception e){
            System.out.println("Do only choose a number which displays on the list");
            goAgain = true;
         }
      }
      while(goAgain);
      
      for (int i = 0; i< disciplineInput.getTimesSize(); i++){
         disciplineInput.printNameAndTime(i);
      }
   
   }
}