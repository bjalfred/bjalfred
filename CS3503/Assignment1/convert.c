#include <stdio.h>
#include <stdint.h>
#include <string.h>
//Brooke Alfred
//Assignment 1
//CS 3503
// Srilekkha Dodda
//Section 2
void div_convert( uint32_t n, int base , char *out) {
        char temp [65]; // Temporary buffer
        int pos = 0;
        // Handle zero case
        if (n == 0) {
            strcpy (out, "0");
            return ;
        }

        // Extract digits from right to left
        while (n > 0) {
            int remainder = n % base ;
            n = n / base ;
            // Convert digit to character
            if ( remainder < 10)
                temp [pos++] = '0' + remainder;
            else
                temp [pos++] = 'A' + ( remainder - 10);
        }

        // putting the digits from bottom to top in an array
        int i;
        for (i = 0; i < pos; i++) {
            out[i] = temp[pos - i - 1]; //start from the last character in the array
        }
        out[pos] = '\0';
    }

void sub_convert( uint32_t n, int base , char *out) {
        char temp [65]; // Temporary buffer
        int pos = 0;
        // Handle zero case
        if (n == 0) {
            strcpy (out, "0");
            return ;
        }

        // Extract digits from right to left
    //looked up unit_64_t my code kept crashing during the testing because the 32 bit was not big enough. Parsed it to that to make it run smoothly
        uint64_t highest = base;

        while (highest<n) {
            highest= highest*(uint64_t)base;
        }

        highest=highest/(uint64_t)base;

        while (highest>0) {
            uint64_t digit= n/highest;
            n-= digit*highest;

            if ( digit < 10)
                temp [pos++] = '0' + digit;
            else
                temp [pos++] = 'A' + ( digit - 10);

            highest/=base;
        }


        // putting the digits top to bottom in the array
        int i;
        for (i = 0; i < pos; i++) {
            out[i] = temp[i]; //start from the last character in the array
        }
        out[pos] = '\0';
    }


