import java.util.ArrayList;
import java.util.LinkedList;

public class Discipline {
       private String name;
       private Member member;
       private LinkedList<Time> times;

    public Discipline(String name){
      this.name = name;
      this.times = new LinkedList<>();
    }

       public LinkedList<Time> getTimes() {
           return times;
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
        LinkedList<Time> sortedTimes = new LinkedList<>();
        int iterations;
        if (times.size() < 5) {
            iterations = times.size();
        } else {
            iterations = 5;
        }

        for (int i = 0; i < iterations; i++) {
            Time currentBest = times.get(0);
            for (Time t : times) {
                if (t.getTime() < currentBest.getTime() ){
                    currentBest = t;
                }
            }
            sortedTimes.add(currentBest);
            times.remove(currentBest);
        }
        times = sortedTimes;


   }
   
   
}