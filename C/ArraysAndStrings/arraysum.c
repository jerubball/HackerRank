#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * HackerRank C ArraysAndStrings 1
 * https://www.hackerrank.com/challenges/1d-arrays-in-c/problem
 * Author: Hasol
 */
int main ()
{
    int n;
    scanf ("%d", &n);
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        scanf ("%d", &arr[i]);
    }
    int sum = 0;
    for (int i = 0; i < n; i++)
    {
        sum += arr[i];
    }
    printf ("%d", sum);
    return 0;
}
