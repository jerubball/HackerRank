#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * HackerRank C ConditionalsAndLoops 2
 * https://www.hackerrank.com/challenges/for-loop-in-c/problem
 * Author: Hasol
 */
int main ()
{
    int a, b;
    scanf ("%d\n%d", &a, &b);
    
    for (int i = a; i <= b; i++)
    {
        char* result;
        switch (i)
        {
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
            default:
                if (i % 2 == 0)
                    result = "even";
                else
                    result = "odd";
                break;
        }
        printf ("%s\n", result);
    }

    return 0;
}
