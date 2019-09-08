#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * HackerRank C ConditionalsAndLoops 3
 * https://www.hackerrank.com/challenges/sum-of-digits-of-a-five-digit-number/problem
 * Author: Hasol
 */
int main ()
{
    int n;
    scanf ("%d", &n);

    int sum = 0;
    while (n > 0)
    {
        sum += n % 10;
        n /= 10;
    }

    printf ("%d", sum);

    return 0;
}
