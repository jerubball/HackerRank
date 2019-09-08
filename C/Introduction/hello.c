#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * HackerRank C Introduction 1
 * https://www.hackerrank.com/challenges/hello-world-c/problem
 * Author: Hasol
 */
int main () 
{
	
    char s[100];
    scanf ("%[^\n]%*c", &s);
  	
    printf ("Hello, World!\n");
    printf ("%s", s);
    return 0;
}

