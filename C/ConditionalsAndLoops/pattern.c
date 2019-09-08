#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int min (int a, int b, int c, int d);

/*
 * HackerRank C ConditionalsAndLoops 5
 * https://www.hackerrank.com/challenges/printing-pattern-2/problem
 * Author: Hasol
 */
int main ()
{
    int n;
    scanf ("%d", &n);
    int s = n * 2 - 1;
    for (int i = 0; i < s; i++)
    {
        for (int j = 0; j < s; j++)
        {
            int v = n - min (i, j, s - i - 1, s - j - 1);
            printf ("%d ", v);
        }
        printf ("\n");
    }
    return 0;
}

int min (int a, int b, int c, int d)
{
    int m = a;
    if (m > b)
        m = b;
    if (m > c)
        m = c;
    if (m > d)
        m = d;
    return m;
}
