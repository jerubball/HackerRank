#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int lexicographic_sort (const char* a, const char* b);
int lexicographic_sort_reverse (const char* a, const char* b);
int sort_by_number_of_distinct_characters (const char* a, const char* b);
int sort_by_length (const char* a, const char* b);

/*
 * HackerRank C Functions 3
 * https://www.hackerrank.com/challenges/sorting-array-of-strings/problem
 * Author: Hasol
 */
int main () 
{
    int n;
    scanf ("%d", &n);
    char** arr;
    arr = (char**) malloc (n * sizeof (char*));
    for (int i = 0; i < n; i++)
    {
        *(arr + i) = malloc(1024 * sizeof(char));
        scanf("%s", *(arr + i));
        *(arr + i) = realloc (*(arr + i), strlen (*(arr + i)) + 1);
    }
    
    string_sort (arr, n, lexicographic_sort);
    for (int i = 0; i < n; i++)
        printf ("%s\n", arr[i]);
    printf ("\n");
    string_sort (arr, n, lexicographic_sort_reverse);
    for (int i = 0; i < n; i++)
        printf ("%s\n", arr[i]); 
    printf ("\n");
    string_sort (arr, n, sort_by_length);
    for (int i = 0; i < n; i++)
        printf ("%s\n", arr[i]);    
    printf ("\n");
    string_sort (arr, n, sort_by_number_of_distinct_characters);
    for (int i = 0; i < n; i++)
        printf ("%s\n", arr[i]); 
    printf ("\n");
    
    return 0;
}

int lexicographic_sort (const char* a, const char* b)
{
    return strcmp (a, b);
}

int lexicographic_sort_reverse (const char* a, const char* b)
{
    return strcmp (b, a);
}

int sort_by_number_of_distinct_characters (const char* a, const char* b)
{
    int max_char = 127;
    int alist[max_char], blist[max_char];
    for (int i = 0; i < max_char; i++)
    {
        alist[i] = 0;
        blist[i] = 0;
    }
    int alen = strlen (a), blen = strlen (b);
    for (int i = 0; i < alen; i++)
        alist[a[i]] = 1;
    for (int i = 0; i < blen; i++)
        blist[b[i]] = 1;
    int asum = 0, bsum = 0;
    for (int i = 0; i < max_char; i++)
    {
        asum += alist[i];
        bsum += blist[i];
    }
    return asum < bsum ? -1 : asum > bsum ? 1 : strcmp (a, b);
}

int sort_by_length (const char* a, const char* b)
{
    int alen = strlen (a), blen = strlen (b);
    return alen < blen ? -1 : alen > blen ? 1 : strcmp (a, b);
}

void string_sort (char** arr, const int len, int (*cmp_func) (const char* a, const char* b))
{
    for (int i = 0; i < len - 1; i++)
        for (int j = i + 1; j < len; j++)
            if (cmp_func (arr[i], arr[j]) > 0)
            {
                char* s = arr[i];
                arr[i] = arr[j];
                arr[j] = s;
            }
}
