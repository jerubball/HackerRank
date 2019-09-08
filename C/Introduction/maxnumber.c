#include <stdio.h>

int sum_of_four (int a, int b, int c, int d);
int max_of_four (int a, int b, int c, int d);

/*
 * HackerRank C Introduction 4
 * https://www.hackerrank.com/challenges/functions-in-c/problem
 * Author: Hasol
 */
int main() {
    int a, b, c, d;
    scanf ("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four (a, b, c, d);
    printf ("%d", ans);
    
    return 0;
}

int sum_of_four (int a, int b, int c, int d)
{
    return a + b + c + d;
}

int max_of_four (int a, int b, int c, int d)
{
    int max = a;
    if (max < b)
        max = b;
    if (max < c)
        max = c;
    if (max < d)
        max = d;
    return max;
}
