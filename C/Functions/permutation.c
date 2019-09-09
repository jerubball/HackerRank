#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int next_permutation (int n, char **s);
int next_permutation_1 (int n, char **s);
int next_permutation_2 (int n, char **s);

/*
 * HackerRank C Functions 4
 * https://www.hackerrank.com/challenges/permutations-of-strings/problem
 * Author: Hasol
 */
int main ()
{
	char **s;
	int n;
	scanf ("%d", &n);
	s = calloc (n, sizeof (char*));
	for (int i = 0; i < n; i++)
	{
		s[i] = calloc (11, sizeof (char));
		scanf ("%s", s[i]);
	}
	do
	{
		for (int i = 0; i < n; i++)
			printf ("%s%c", s[i], i == n - 1 ? '\n' : ' ');
	}
    while (next_permutation (n, s));
	for (int i = 0; i < n; i++)
		free (s[i]);
	free (s);
	return 0;
}

int next_permutation (int n, char **s)
{
    int last = n - 1;
    int dest = last - 1;
    // scan from last for lesser string relative to next
    while (strcmp (s[dest], s[dest + 1]) >= 0)
        if (dest == 0)
            return 0;
        else
            dest--;
    
    char* ss = s[dest];
    int found = dest + 1;
    // search for next greater string relative to dest
    while (found < n && strcmp (s[found], ss) > 0)
        found++;
    found--;
    // swap destination and found string
    s[dest] = s[found];
    s[found] = ss;
    // reverse right portion.
    for (int i = dest + 1, j = n - 1; i < j; i++, j--)
    {
        ss = s[i];
        s[i] = s[j];
        s[j] = ss;
    }
    return 1;
}

int next_permutation_1 (int n, char **s)
{
    // scan from last
    int last = n - 1;
    int dest = last - 1;
    char* ss = s[last];
    // look for next lesser string relative to last
    while (strcmp (s[dest], ss) >= 0)
        if (dest == 0)
            return 0;
        else
            dest--;
    // shift right portion
    for (int i = last; i > dest; i--)
        s[i] = s[i - 1];
    // insert last into destination
    s[dest] = ss;
    return 1;
}

int next_permutation_2 (int n, char **s)
{
    int last = n - 1;
    int dest = last - 1;
    // scan from last for lesser string relative to next
    while (strcmp (s[dest], s[dest + 1]) >= 0)
        if (dest == 0)
            return 0;
        else
            dest--;
    char* ss = s[dest];
    int found = dest + 1;
    // search for minimum greater string relative to dest
    for (int i = found + 1; i < n; i++)
        if (strcmp (s[i], ss) > 0 && strcmp (s[i], s[found]) < 0)
            found = i;
    // swap destination and found string
    s[dest] = s[found];
    s[found] = ss;
    // sort right portion.
    for (int i = dest + 1; i < n + 1; i++)
        for (int j = i + 1; j < n; j++)
            if (strcmp (s[i], s[j]) > 0)
            {
                ss = s[i];
                s[i] = s[j];
                s[j] = ss;
            }
    return 1;
}
