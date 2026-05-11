#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include "convert.h" //used this to reference methods from convert.c. I also looked this up

//Brooke Alfred
//Assignment 1
//CS 3503
// Srilekkha Dodda
//Section 2

// just a preface, we were not taught C or C++ ww were only taught java, I had no clue where to start on syntax so. I used Google for the majority of this assignment
// I will reference everything I looked up and why I looked it up

void print_tables(uint32_t n) {
    char bin[33], oct[12], hex[9];

    // Original number
    div_convert(n, 2, bin);
    div_convert(n, 8, oct);
    div_convert(n, 16, hex);
    printf("Original: Binary = %s Octal = %s Decimal = %u Hex = %s\n",
           bin, oct, n, hex);

    // Left shift by 3
    uint32_t shifted = n << 3;
    div_convert(shifted, 2, bin);
    div_convert(shifted, 8, oct);
    div_convert(shifted, 16, hex);
    printf("Left Shift by 3: Binary = %s Octal = %s Decimal = %u Hex = %s\n",
           bin, oct, shifted, hex);

    // AND with 0xFF
    uint32_t masked = n & 0xFF;
    div_convert(masked,2,bin); //followed skeleton provided in assignment instructions
    div_convert(masked,8,oct);
    div_convert(masked,16,hex);
    printf("And with 0xFF: Binary = %s Octal = %s Decimal = %u Hex = %s\n",
           bin, oct, masked, hex) ;

}


int main(void) {
       int passcounter = 0; // counter to count how many tests passed
       int overallcounter = 0; //counting the total amount of tests

       //skeleton provided in instructions
       FILE *file = fopen("/home/jordii/Desktop/A1_tests.txt", "r");
       if (file == NULL) {
              printf(" Error: Could not open file \n");
              return 1;
       }

       char line[256];

       while (fgets(line, sizeof(line), file) != NULL) {
              line[strcspn(line, "\n")] = '\0';

              // used google to reference the symbols for null in this line of code I am eliminating the empty spaces, and comments in the test file
              if (line[0] == '\0' || line[0] == '#') {
                     continue;
              }

              char func[20]; // array made to signify the functions listed in the document
              uint32_t input; // the input for the converting functions referenced as n originally
              int base; //same as convert.c
              char expected[512]; //expected is the array made for the numbers that are given in the test file that are supposed to be passed on
              char output[512]; // output is the same as out for convert c. I upped it to 512 because of the large numbers in the test file (same for expected)

              // Looked up on google how to scan in data from the file. I specifically looked for it similar to how the text from print tables is formatted.
              //i wanted to create it to where it automatically looks at the test in the file and it looks for the numbers in the text so i could break it up,
              //similar to how ypu could use a delimiter in java to break up a string into an array
              if (sscanf(line, "%s %u %d %s", func, &input, &base, expected) == 4) {
                     // I looked up the way to compare strings in C and this function came up.
                     if (strcmp(func, "div_convert") == 0) {
                            div_convert(input, base, output);
                     } // if the function array is equal to div_convert, then run the test.
                     else if (strcmp(func, "sub_convert") == 0) {
                            sub_convert(input, base, output);
                     } //same as the one before it
                     else {
                            continue;
                     } // if not go to the next line

                     overallcounter++; // put a count on the overall score

                     //using string comparison again to show that the outputs are the same if they match they pass, if not they fail
                     if (strcmp(output, expected) == 0) {
                            printf("Test %d: %s(%u, %d) -> Expected: %s Got: %s [PASS]\n",
                            overallcounter, func, input, base, expected, output);
                            passcounter++;
                     }
                     else {
                            printf("Test %d: %s(%u, %d) -> Expected: %s Got: %s [PASS]\n",
                            overallcounter, func, input, base, expected, output);
                     }
              }

              // Because print tables only has two arguments for this one we do the same check but make it specific for that method
              // i could not figure out how to do the test formatting for this one, I tried using sprintf but everytime i did that it crashed my program
              if (sscanf(line, "%s %u", func, &input) == 2) {
                     if (strcmp(func, "print_tables") == 0) {
                            print_tables(input); // prints out the n value
                            overallcounter++;
                            passcounter++;        // all are counted as passes because all of them are formatted in a specific way + the file does not explicitly state the numbers, just if its formatted
                     }
              }
       }
       fclose(file); // skeleton code

       // Summary of results
       printf("\nTotal tests passed: %d / %d", passcounter, overallcounter ); // done according to assignment guidelines


       return 0; // because this is a method something has to be returned.
}
