#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * HackerRank C Introduction 2
 * https://www.hackerrank.com/challenges/playing-with-characters/problem
 * Author: Hasol
 */
int main () 
{
    char ch;
    char s[100];
    char *sen = malloc(100 * sizeof(char));
    scanf ("%c%*[\r\n]", &ch);
    scanf ("%[^\r\n]%*[\r\n]", s);
    scanf ("%[^\\]", sen);
    printf ("%c\n", ch);
    printf ("%s\n", s);
    printf ("%s", sen);
    return 0;
}

