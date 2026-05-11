//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Park Wallet Class

public class ParkWallet {
    private static int tickets;
    private static boolean holiday;

    public ParkWallet(){
        tickets=0;
        holiday=false;
    }
    public ParkWallet(int newTickets){
        tickets=newTickets;
        holiday=false;
    }

    public static int  getTicketCount(){
        return tickets;
    }
    public static boolean holidayStatus(){
        return holiday;
    }

    public static void setTickets(int newTickets){
        if (newTickets<0){
        }
        else {
            tickets = newTickets;
        }
    }

    public static boolean setHoliday(){
        holiday=!holiday;
        return holiday;
    }

    public static void addTickets(int ticketCount){
        if (ticketCount>0){
            tickets+=ticketCount;
        }
        else{

        }
    }
    public static boolean removeTickets(int ticketCount){
        boolean enoughTickets= ticketCount<=tickets;
        if (ticketCount>0 && enoughTickets){
            tickets-=ticketCount;
            return true;
        }
        else{
            return false;
        }
    }
}
