#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <string.h>
#include "convert.h" //used this to reference methods from convert.c. I also looked this up

//Brooke Alfred
//Assignment 2
//CS 3503
// Srilekkha Dodda
//Section 2




int main(void) {
       int passcounter = 0; // counter to count how many tests passed
       int overallcounter = 0; //counting the total amount of tests

       //skeleton provided in instructions
       FILE *file = fopen("/home/jordii/Desktop/A2_test.txt", "r");
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
              char input[256]; // the input for the converting functions referenced as const char
              char expected[512]; //expected is the array made for the numbers that are given in the test file that are supposed to be passed on
              char output[512]; // output is the same as out for convert c. I upped it to 512 because of the large numbers in the test file (same for expected)

              // Looked up on google how to scan in data from the file. I specifically looked for it similar to how the text from print tables is formatted.
              //i wanted to create it to where it automatically looks at the test in the file and it looks for the numbers in the text so i could break it up,
              //similar to how ypu could use a delimiter in java to break up a string into an array
              if (sscanf(line, "%s %s %s", func, input, expected) == 3) {
                     // I looked up the way to compare strings in C and this function came up.
                     if (strcmp(func, "oct_to_bin") == 0) {
                            oct_to_bin(input, output);
                     }
                     else if (strcmp(func, "oct_to_hex") == 0) {
                            oct_to_hex(input, output);
                     }
                     else if (strcmp(func, "hex_to_bin") == 0) {
                            hex_to_bin(input, output);
                     }
                     else if (strcmp(func, "to_sign_magnitude") == 0) {
                            to_sign_magnitude(input, output);
                     }
                     else if (strcmp(func, "to_ones_complement") == 0) {
                            to_ones_complement(input, output);
                     }
                     else if (strcmp(func, "to_twos_complement") == 0) {
                            to_twos_complement(input, output);
                     }
                     else {
                            continue;
                     } // if not go to the next line

                     overallcounter++; // put a count on the overall score

                     //using string comparison again to show that the outputs are the same if they match they pass, if not they fail
                     if (strcmp(output, expected) == 0) {
                            printf("Test %d: %s(%s) -> Expected: %s Got: %s [PASS]\n",
                            overallcounter, func, input, expected, output);
                            passcounter++;
                     }
                     else {
                            printf("Test %d: %s(%s) -> Expected: %s Got: %s [FAIL]\n",
                            overallcounter, func, input, expected, output);
                     }
              }

       }
       fclose(file); // skeleton code
       // Summary of results
       printf("\nTotal tests passed: %d / %d", passcounter, overallcounter ); // done according to assignment guidelines


       return 0; // because this is a method something has to be returned.
}