#include <stdio.h>
#include <stdlib.h>

/*
 * HackerRank C ArraysAndStrings 2
 * https://www.hackerrank.com/challenges/reverse-array-c/problem
 * Author: Hasol
 */
int main ()
{
    int num, *arr, i;
    scanf("%d", &num);
    arr = (int*) malloc (num * sizeof (int));
    for (i = 0; i < num; i++)
    {
        scanf ("%d", arr + i);
    }

    int a;
    for (i = 0; i < num / 2; i++)
    {
        a = arr[i];
        arr[i] = arr[num - i - 1];
        arr[num - i - 1] = a;
    }

    for (i = 0; i < num; i++)
        printf ("%d ", *(arr + i));
    return 0;
}
