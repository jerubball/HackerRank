#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * HackerRank C Introduction 3
 * https://www.hackerrank.com/challenges/sum-numbers-c/problem
 * Author: Hasol
 */
int main ()
{
    int a, b;
    float c, d;
    scanf ("%d %d%*[\r\n]", &a, &b);
    scanf ("%f %f%*[\r\n]", &c, &d);
    printf ("%d %d\n", a+b, a-b);
    printf ("%.1f %.1f", c+d, c-d);
    return 0;
}
