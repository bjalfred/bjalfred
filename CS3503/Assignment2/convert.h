#ifndef CONVERT_H
#define CONVERT_H

#include <stdint.h>

/* Octal Conversions */
void oct_to_bin(const char *oct, char *out);
void oct_to_hex(const char *oct, char *out);

/* Hexadecimal Conversions */
void hex_to_bin(const char *hex, char *out);

/* Signed Representations (32-bit) */
void to_sign_magnitude(const char *dec, char *out);
void to_ones_complement(const char *dec, char *out);
void to_twos_complement(const char *dec, char *out);

#endif
