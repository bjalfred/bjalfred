import java.util.ArrayList;
import javax.sound.midi.*;

public interface FYENote {
    byte getNote();
    int getTiming();
}

class FYEMusicPlayerReaderException extends FYEMusicReaderException {
    public FYEMusicPlayerReaderException(String message){
        super(message);
    }
}

class FYEMusicPlayer{
    private static ArrayList<FYENote> notes;


    public static void loadNotes(ArrayList<FYENote> notes) throws FYEMusicPlayerReaderException {
        for(FYENote n : notes){
            if (n.getNote() < 0             ||
                n.getTiming() < 0           ||
                n.getTiming() % 62500 != 0  ||
                n.getTiming() > 7_937_500) {
                throw new FYEMusicPlayerReaderException("File not parsed correctly. Check the specifications and correct your code");
            }
        }

        FYEMusicPlayer.notes = notes;
    }

    public static void play() throws FYEMusicPlayerReaderException {
        if(notes == null) throw new FYEMusicPlayerReaderException("No melody loaded");
        MusicPlayer.play(notes);
    }

    public static void close(){
        MusicPlayer.close();
    }
}




















/*
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
    ==============================DO NOT READ PAST THIS POINT==============================
 */

class MusicPlayer{
    private static Synthesizer synth;
    private static Sequencer seq;

    private static void initialize() throws MidiUnavailableException{
        if(synth == null || !synth.isOpen()) synth = MidiSystem.getSynthesizer();
        if (seq == null || !seq.isOpen()) seq = MidiSystem.getSequencer();
        synth.open();
        seq.open();
    }

    public static void close(){
        if (synth != null) synth.close();
        if (seq != null) seq.close();
    }

    static void play(ArrayList<FYENote> notes) throws FYEMusicPlayerReaderException {

        try{
            initialize();

            long latency = synth.getLatency();
            Sequence sequence = new Sequence(Sequence.SMPTE_25, 40000);
            Track t = sequence.createTrack();

            long timer = latency;

            for (FYENote note : notes) {
                if(note.getNote() != 0)
                    t.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, note.getNote(), 100), timer));
                else
                    t.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, 0, 100), timer));

                timer += note.getTiming();
                t.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, note.getNote(), 100), timer));
            }
            t.add(new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, 0, 100), timer + latency));

            seq.setSequence(sequence);

            seq.start();

            while (true) {
                if (!seq.isRunning()) break;
            }
        } catch (MidiUnavailableException | InvalidMidiDataException | SecurityException e) {
            String message = "Java is unable to make your computer play sounds. Code your solution according to specifications, as your submission will still be graded as normal.";
            throw new FYEMusicPlayerReaderException(message);
        }
        catch (Exception e){
            throw new FYEMusicPlayerReaderException("An unknown error has occurred: " + e.getMessage() + ".");
        }
    }
}