#include <stdio.h>
#include <stdlib.h>
#include <math.h>

struct triangle
{
	int a;
	int b;
	int c;
};

typedef struct triangle triangle;

double area_of_triangle (triangle t);
int compare_triangle (triangle t1, triangle t2);
void sort_by_area(triangle* tr, int n);

/*
 * HackerRank C StructsAndEnums 2
 * https://www.hackerrank.com/challenges/small-triangles-large-triangles/problem
 * Author: Hasol
 */
int main ()
{
    int n;
    scanf ("%d", &n);
    triangle *tr = malloc (n * sizeof (triangle));
    for (int i = 0; i < n; i++)
    {
        scanf ("%d%d%d", &tr[i].a, &tr[i].b, &tr[i].c);
    }
    sort_by_area (tr, n);
    for (int i = 0; i < n; i++)
    {
        printf ("%d %d %d\n", tr[i].a, tr[i].b, tr[i].c);
    }
    return 0;
}

double area_of_triangle (triangle t)
{
    double p = ((double) (t.a + t.b + t.c)) / 2;
    return sqrt(p * (p - t.a) * (p - t.b) * (p - t.c));
}

int compare_triangle (triangle t1, triangle t2)
{
    double a1 = area_of_triangle (t1), a2 = area_of_triangle (t2);
    return a1 > a2 ? 1 : a1 < a2 ? -1 : 0;
}

void sort_by_area (triangle* tr, int n)
{
    triangle t;
	for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (compare_triangle (tr[i], tr[j]) > 0)
            {
                t = tr[i];
                tr[i] = tr[j];
                tr[j] = t;
            }
        }
    }
}
