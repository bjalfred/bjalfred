//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Video Game

public class VideoGame extends Software{
    protected boolean multiplayerSupport;

    public VideoGame(String nameOfItem, Double priceOfItem, String nameOfPublisher, boolean canMultiplayer){
        super(nameOfItem, priceOfItem,nameOfPublisher);
        multiplayerSupport = canMultiplayer;

    }

    public boolean setMultiplayer(boolean canMultiplayer){
        multiplayerSupport=canMultiplayer;
        return multiplayerSupport;

    }

    public boolean getMultiplayer(){
        return multiplayerSupport;
    }

    @Override
    public String toString(){
        return super.toString() + "\n\t\t Multiplayer Support: " + multiplayerSupport;
    }
}
