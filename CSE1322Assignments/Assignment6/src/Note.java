//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Note Class


public class Note implements FYENote {
    private byte Note;
    private int Timing;

    public Note(byte timea, int timeb){
        Note = timea;
        Timing = timeb;
    }

    @Override
    public byte getNote() {
        return Note  ;
    }

    @Override
    public int getTiming(){
        return Timing;
    }
}
