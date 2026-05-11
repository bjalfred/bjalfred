#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//Brooke Alfred
//Assignment 2
//CS 3503
// Srilekkha Dodda
//Section 2


void oct_to_bin( const char *oct, char *out) {
    // to map digits im thinking the best way to extract into separate numbers is using an array
    // for digits


    // created an array that maps binary values from 0-7
    char *binaryDigits[8]= {
        "000", "001", "010", "011", "100", "101", "110", "111",
    };

    int i=0; // condition for the oct variable
    int pos=0; //position variable for out so we know where to map to

    //while the digit in the oct array is not null
    while (oct[i]!= '\0') {
        int num= oct[i]- '0'; //turn the octsl character into a number

        if (num<0 || num>7) {
            printf("Error invalid octal digit: '%c'" , oct[i]);
            out[0]='\0';
            return;
        }
        else {
            //using a for loop to properly add 3 characters wach into the out array
            for (int j=0; j<3; j++) {
                out[pos++]=binaryDigits[num][j]; //add in binary digits at the number assigned using j to do each one individually
            }
            i++; // goes on to the nect number
        }
    };
    out[pos]='\0'; // stops adding things to the string.
}

void oct_to_hex( const char *oct, char *out) {
    // use oct_to_bin to convert it to binary
    char tempBinary[100];
    oct_to_bin( oct, tempBinary);

    //padding the number with zeros

    int lenOfBin= strlen(tempBinary); //find the length of the current binary string

    int remainder= lenOfBin %4 ; // find out the remainder (numbers needed to add)

    // if the remainder is not 0 aka it is not divisible by 4)
    if ( remainder !=0) {
        int zeroAdd=4-remainder; // the number of zeros added needs to be the based on getting it to four

        // then going backwards i need to shift all the binary num values to the right by the amount of zeros we need to add
        for (int i= lenOfBin-1; i>=0; i--) {
            tempBinary[i+zeroAdd]= tempBinary[i];
        }

        // after that add zeros until we get to the last digit before we shifted
        for (int i=0; i<zeroAdd; i++) {
            tempBinary[i]='0';
        }
        tempBinary[lenOfBin+zeroAdd]='\0';
    }

    //making the lookup for hexadecimal
    char hexDigits[16]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    int pos=0;
    for (int i=0; tempBinary[i]!='\0'; i+=4) {
        char hex4[5]; //setting up a small group of four digits for each group in temp binary
        strncpy(hex4, &tempBinary[i],4); // looked up a function to easily copy digits from one array to another so i wouldnt have to do a for loop
        hex4[4]='\0'; //properly ending out the string

        int hex4digit= (int)strtol(hex4, NULL, 2); //looked up a function that could turn binary digits into decimal numbers for easy lookup within the array I made for hex digits
        out[pos++]=hexDigits[hex4digit];
    }
    out[pos]='\0';

    // remove leading zero after testing
    if (out[0] == '0' && out[1] != '\0') {
        memmove(out, out + 1, strlen(out));  // looked up a function on google to shift the string easilt
    }

}

void hex_to_bin(const char *hex, char *out) {
    int pos=0;

    const char *hex2Binary[16]= {
        "0000", "0001", "0010" , "0011", "0100", "0101", "0110", "0111",
        "1000", "1001" , "1010", "1011", "1100", "1101", "1110","1111"
    }; // mapping the four binary characters

    for (int i = 0; hex[i] != '\0'; i++) {
        char c = toupper(hex[i]); // looked up a function to send everything into uppercase
        //removes the worry about upper/lowercase cases


        // checking to make sure the hex characters are in the right range
        if  (! ( (c >= '0' && c <= '9') ||(c >= 'A' && c <= 'F'))){
            printf("Error: invalid hex digit '%c'", c); // if its not in there print out an error
            return;
        }

        //if the character is a number
        // in the for loops the num part is to match the mapping back into binary 0 would equal 0000 and so on.
        if (c >= '0' && c <= '9') {
            int num= c - '0'; // turn the character back into the into a number
            for (int j = 0; j < 4; j++) {
                out[pos++] = hex2Binary[num][j]; // because the characters have 4 characters we have to use another for loop to run through the characters
            }

        }
        else {
            int num= c - 'A' + 10; // if the character is a letter i looked up how to turn it back into a number on google
            for (int j = 0; j < 4; j++) {
                out[pos++] = hex2Binary[num][j]; //same as the other one copying the letters back into numbers
            }

        }
    }
    out[pos]='\0'; //end the character
}

void to_sign_magnitude(const char *dec, char *out) {

    char tempBinary[33]; //setting the char array up for binary
    int pos=31; // starting from the 31 position (leaving 32 for the ending string )

    int num=0; // number marker
    int i=0; //position looking
    int negNum=0; //sign marker

    // if the first character is supposed to show negative update the position to look from one and set the neg number flah
    if (dec[0] == '-') {
        i++;
        negNum=1;
    }

    //looked up how i could turn these back into a number safely. You cant really do 1101. so i looked up another way on google on how to change it back
    while (dec[i] != '\0') {
        num= num*10 +(dec[i]-'0'); // turn back into a number
        i++; // move to the next character
    }

    // if the number is zero set end position to zero
    if (num==0) {
        tempBinary[31]='0';
        pos--;
    }
    else {
        //else do the division remainder method, and turn it back into a character adding it to the array
        while (num>0) {
            int remainder= num%2;
            tempBinary[pos]= remainder + '0';
            pos--; // starting from the back so it will not have to be reversed (why we started from pos 31)
            num=num/2;
        }
    }
    //adding the zeros starting from the ending point of turning the number into its binary representation
    for (int i=pos; i>0; i--) {
    tempBinary[i]='0';
    }
    tempBinary[32]='\0'; // closing out the string

    // if the negnum flag is active change the sign
    if (negNum!=0) {
        tempBinary[0]='1';
    }
    else {
        tempBinary[0]='0';
    }

    strncpy(out,tempBinary,33); // copying my temporary array back to out
}


void to_ones_complement(const char *dec ,char *out) {

    to_sign_magnitude(dec,out); // using sign magnitude i already have its created its proper binary anf signed representstion

    // now if the first sign is negative we need to flip the bits
    if (out[0]=='1') {
        for (int i=1; i<32; i++) { //starting at 1 flip the bits
            if (out[i]=='1') {
                out[i]='0'; // if its one flip to zero
            }
            else {
                out[i]='1'; //if its zero flip to one
            }
        }
    }
}

void to_twos_complement(const char *dec ,char *out) {

    to_ones_complement(dec,out); // using the ones complement i have the flipped bits and correct sign
    int carry=1; // this is a flag to use to add the one and check for overflow

    if (out[0]=='1') {
            for (int i=31; i>0; i--) { //starting from the least significant bits

                if (carry==1 && out[i]=='1' ) {
                    out[i]='0'; // if you are trying to add 1+1 it equals 0 in binary addition
                }
                else {
                    out[i]='1'; // if the next digit that needs to be added is zero we no longer need to carry
                    carry--; //decrease carry
                }
            }
        }
    }
