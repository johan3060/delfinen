import java.util.ArrayList;

   public class Discipline {
       private String name;
       private ArrayList<Integer> times;
       private ArrayList<String> memberNames;      

    public Discipline(String name){
      this.name = name;
      this.times = new ArrayList<>();
      this.memberNames = new ArrayList<>();
    }

   public String getName(){
      return name;
   }
   
   public int getTimesSize(){
      return times.size();
   }
   
   public void addTime(int inputTime){
      times.add(inputTime);
   }
   
   public void addMemberName(String inputName){
      memberNames.add(inputName);
   }
   
   public void printNameAndTime(int i){
      System.out.println("Name: " + memberNames.get(i) + ".");
      System.out.println("Time: " + times.get(i) + " seconds.\n");
   }
   
   
}