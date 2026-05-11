import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment : Lab 7

public class Assignment6 {

    public static ArrayList<FYENote> loadMusic(Scanner musicFile) throws FYEMusicReaderException {

        int totalNotes = musicFile.nextByte();

        if (totalNotes < 0) {
            throw new FYEMusicReaderException(" Note counter out of range.");
        }

        ArrayList<FYENote> compositon = new ArrayList<>();

        while (totalNotes > 0) {
            byte timea = musicFile.nextByte();

            if (timea < 0) {
                throw new FYEMusicReaderException(" Note out of range.");
            }

            byte timing = musicFile.nextByte();

            if (timing < 0) {
                throw new FYEMusicReaderException(" Timing out of range.");
            }

            int timeb = timing * (1000000 / 16);

            Note musicNote = new Note(timea, timeb);

            compositon.add(musicNote);


            totalNotes -= 1;
        }


        return compositon;

    }

    public static void main(String[] args) throws FileNotFoundException, FYEMusicReaderException {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("[FYE Music Player]");

        while (running) {
            System.out.println("1. Load music");
            System.out.println("2. Play music");
            System.out.println("3. Quit");

            try {
                System.out.println("Enter option: ");
                int Option = scanner.nextInt();
                scanner.nextLine();

                switch (Option) {
                    case 1:

                        System.out.println("Enter name of music file");
                        String music = scanner.nextLine();
                        File musicFile = new File(music);
                        Scanner tunes = new Scanner(musicFile);
                        ArrayList musicNotes= loadMusic(tunes);
                        FYEMusicPlayer.loadNotes(musicNotes);
                        System.out.println("Music Loaded");
                        break;
                    case 2:
                        FYEMusicPlayer.play();
                        break;
                    case 3:
                        FYEMusicPlayer.close();
                        running = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("File contains invalid information.");
            } catch (NoSuchElementException e) {
                System.out.println("File ended abruptly.");
            } catch (FYEMusicReaderException e) {
                System.out.println("Unable to load file: " + e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}