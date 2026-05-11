//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: DNALib Class

public class DNALib {
    public static boolean validator(String DNA ){
        boolean length;
        boolean characters;

        DNA =DNA.toUpperCase();

        if (DNA.length()%3==0){
            length=true;
        }
        else{
            length=false;
        }

        if (length){
            DNA= DNA.replaceAll("A","");
            DNA= DNA.replaceAll("C","");
            DNA= DNA.replaceAll("T","");
            DNA= DNA.replaceAll("G","");
        }

        if (DNA.isEmpty()){
            characters=true;
        }
        else{
            characters=false;
        }

        if (length  && characters){
            return true;
        }
        else {
            return false;
        }


    }
    public static String stringReverser(String DNA) {
        DNA = DNA.toUpperCase();

        if (DNA.length()==1) {
            return DNA;
        }
        else {
            return stringReverser(DNA.substring(1))+ DNA.charAt(0);
        }
    }

    public static String stringInverser(String DNA){
        DNA= DNA.toUpperCase();
        char toSwitch = 'n';

        if (DNA.isEmpty()){
            return "";
        }
       else {
            char DNAChar = DNA.charAt(0);

            switch (DNAChar) {
                case 'A':
                    toSwitch = 'T';
                    break;
                case 'T':
                    toSwitch = 'A';
                    break;
                case 'C':
                    toSwitch = 'G';
                    break;
                case 'G':
                    toSwitch = 'C';
                    break;
            }
        }
            return toSwitch + stringInverser(DNA.substring(1));
    }

    public static String stringTranslator(String DNA){
        String aminoacid="n";

        if (DNA.isEmpty()){
            return "";
        }
        if (DNA.length()<3){
            return "";
        }
        else{
            String sequence= "" + DNA.charAt(0)+ DNA.charAt(1)+ DNA.charAt(2);

            switch(sequence){
                case "GCA":
                case "GCC":
                case "GCG":
                case "GCT":
                    aminoacid = "A";
                    break;
                case "TGC":
                case "TGT":
                    aminoacid = "C";
                    break;
                case "GAC":
                case "GAT":
                    aminoacid = "D";
                    break;
                case "GAA":
                case "GAG":
                    aminoacid = "E";
                    break;
                case "TTC":
                case "TTT":
                    aminoacid = "F";
                    break;
                case "GGA":
                case "GGC":
                case "GGG":
                case "GGT":
                    aminoacid = "G";
                    break;
                case "CAC":
                case "CAT":
                    aminoacid = "H";
                    break;
                case "ATA":
                case "ATC":
                case "ATT":
                    aminoacid = "I";
                    break;
                case "AAA":
                case "AAG":
                    aminoacid = "K";
                    break;
                case "CTA":
                case "CTC":
                case "CTG":
                case "CTT":
                case "TTA":
                case "TTG":
                    aminoacid = "L";
                    break;
                case "ATG":
                    aminoacid = "M";
                    break;
                case "AAT":
                case "AAC":
                    aminoacid = "N";
                    break;
                case "CCA":
                case "CCC":
                case "CCG":
                case "CCT":
                    aminoacid = "P";
                    break;
                case "CAA":
                case "CAG":
                    aminoacid = "Q";
                    break;
                case "AGA":
                case "AGG":
                case "CGA":
                case "CGC":
                case "CGG":
                case "CGT":
                    aminoacid = "R";
                    break;
                case "AGC":
                case "AGT":
                case "TCA":
                case "TCC":
                case "TCG":
                case "TCT":
                    aminoacid = "S";
                    break;
                case "ACA":
                case "ACC":
                case "ACG":
                case "ACT":
                    aminoacid = "T";
                    break;
                case "GTA":
                case "GTC":
                case "GTG":
                case "GTT":
                    aminoacid = "V";
                    break;
                case "TGG":
                    aminoacid = "W";
                    break;
                case "TAC":
                case "TAT":
                    aminoacid = "Y";
                    break;
                case "TAA":
                case "TAG":
                case "TGA":
                    aminoacid = "-";}

            }

        return aminoacid + stringTranslator(DNA.substring(3));
    }

}

