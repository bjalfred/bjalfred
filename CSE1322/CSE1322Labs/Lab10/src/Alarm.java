//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Alarm class

public class Alarm extends Thread {
    public int timer;
    public String name;
    private int id;
    public static int nextId=1;

    public Alarm(String nameofAlarm, int secAmount){
            timer = secAmount*1000;
            id = nextId;
            nextId += 1;
            name= nameofAlarm;

        if (nameofAlarm.isEmpty()) {
            name = "Alarm " + id;
        }

    }

    @Override
    public void run() {
       try{
           while (timer>0){
               if (timer==10000){
                   System.out.println(name + " will go off in 10 seconds!");
               }
               Thread.sleep(1000);
               timer-=1000;
           }

           if (timer==0){
               System.out.println(name + " has gone off!");
           }
       }
       catch (InterruptedException e){
           System.out.println(name + " has been interrupted at " + timer/1000 + " seconds" );

       }
    }

    @Override
    public String toString(){
        return name + " is currently at " + timer/1000 + " seconds";

    }
}
