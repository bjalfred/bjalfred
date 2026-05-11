//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Blue ray collection class


public class BlueRayCollection {
    BlueRayDisk head;

    public void addDisk(String nameOfMovie, String nameOfDirector, int movieYear, double priceOfMovie){
        BlueRayDisk node= new BlueRayDisk(nameOfMovie,nameOfDirector,movieYear,priceOfMovie);
        node.next= null;
        if (head==null) {
            head=node;
        }
        else{
            BlueRayDisk current= head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=node;
        }

    }

    public String showAll(){
        String showItAll="";
        BlueRayDisk current= head;
        while(current!=null){
            showItAll += current.toString() +"\n";
            current=current.next;
        }
        return showItAll;
    }
}
