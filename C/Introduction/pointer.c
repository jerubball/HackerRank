#include <stdio.h>

void update (int *a, int *b);

/*
 * HackerRank C Introduction 5
 * https://www.hackerrank.com/challenges/pointer-in-c/problem
 * Author: Hasol
 */
int main ()
{
    int a, b;
    int *pa = &a, *pb = &b;
    
    scanf ("%d %d", &a, &b);
    update (pa, pb);
    printf ("%d\n%d", a, b);

    return 0;
}

void update (int *a, int *b)
{
    int va = *a, vb = *b;
    *a = va + vb;
    *b = va > vb ? va - vb : vb - va;
}
