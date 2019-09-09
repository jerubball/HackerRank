#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * HackerRank C ArraysAndStrings 4
 * https://www.hackerrank.com/challenges/frequency-of-digits-1/problem
 * Author: Hasol
 */
int main ()
{
    char s[1000];
    scanf ("%s", s);
    int n = strlen (s);
    int arrlength = 10; // sizeof(arr) / sizeof(int)
    int arr[arrlength];
    for (int i = 0; i < arrlength; i++)
    {
        arr[i] = 0;
    }
    for (int i = 0; i < n; i++)
    {
        char c = s[i];
        if (c >= '0' && c <= '9')
            arr[c - '0']++; // arr[atoi (&c)]++;
    }
    for (int i = 0; i < arrlength; i++)
    {
        printf ("%d ", arr[i]);
    }
    return 0;
}
