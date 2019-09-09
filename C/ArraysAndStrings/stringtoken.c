#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * HackerRank C ArraysAndStrings 3
 * https://www.hackerrank.com/challenges/printing-tokens-/problem
 * Author: Hasol
 */
int main ()
{
    char *s;
    s = malloc(1024 * sizeof(char));
    scanf("%[^\n]", s);
    s = realloc(s, strlen(s) + 1);

    int n = strlen(s);
    for (int i = 0; i < n; i++)
    {
        if (s[i] != ' ')
            printf ("%c", s[i]);
        else
            printf ("\n");
    }

    return 0;
}
