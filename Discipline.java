import java.util.ArrayList;

   public class Discipline {
       private String name;
       private Member member;
       private ArrayList<Time> times;

    public Discipline(String name){
      this.name = name;
      this.times = new ArrayList<>();
    }

   public String getName(){
      return name;
   }
   
   public int getTimesSize(){
      return times.size();
   }
   
   public void addTime(int inputTime, Member inputMember){
      times.add(new Time(inputTime, inputMember));
   }
   
   public void printNameAndTime(int i){
      System.out.println("Name: " + times.get(i).getMember().getName() + ".");
      System.out.println("Time: " + times.get(i).getTime() + " seconds.\n");
   }
   public void sortTimes(){
        Time current;
        Time previous = times.get(0); // gode gamle stakitproblematik
        ArrayList<Time> SortedTimes;

        for (int i = 0; i < times.size(); i++) {
            current = times.get(i);




        }


   }
   
   
}