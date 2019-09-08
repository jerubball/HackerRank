#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void calculate_the_maximum (int n, int k);

/*
 * HackerRank C ConditionalsAndLoops 4
 * https://www.hackerrank.com/challenges/bitwise-operators-in-c/problem
 * Author: Hasol
 */
int main ()
{
    int n, k;
  
    scanf ("%d %d", &n, &k);
    calculate_the_maximum (n, k);
 
    return 0;
}

void calculate_the_maximum (int n, int k)
{
    int and = 0, or = 0, xor = 0;
    int and1, or1, xor1;
    for (int a = 1; a <= n; a++)
    {
        for (int b = a + 1; b <= n; b++)
        {
            and1 = a & b;
            or1 = a | b;
            xor1 = a ^ b;
            and = (and1 > and && and1 < k) ? and1 : and;
            or = (or1 > or && or1 < k) ? or1 : or;
            xor = (xor1 > xor && xor1 < k) ? xor1 : xor;
        }
    }
    printf ("%d\n%d\n%d", and, or, xor);
}
