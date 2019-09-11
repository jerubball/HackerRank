#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_STRING_LENGTH 6

struct package
{
    char* id;
    int weight;
};
typedef struct package package;

struct post_office
{
    int min_weight;
    int max_weight;
    package* packages;
    int packages_count;
};
typedef struct post_office post_office;

struct town
{
    char* name;
    post_office* offices;
    int offices_count;
};
typedef struct town town;

void print_all_packages (town t);
void send_all_acceptable_packages (town* source, int source_office_index, town* target, int target_office_index);
town town_with_most_packages (town* towns, int towns_count);
town* find_town (town* towns, int towns_count, char* name);

/*
 * HackerRank C StructsAndEnums 3
 * https://www.hackerrank.com/challenges/post-transition/problem
 * Author: Hasol
 */
int main ()
{
    int towns_count;
    scanf ("%d", &towns_count);
    town* towns = malloc (sizeof (town) * towns_count);
    for (int i = 0; i < towns_count; i++)
    {
        towns[i].name = malloc (sizeof (char) * MAX_STRING_LENGTH);
        scanf ("%s", towns[i].name);
        scanf ("%d", &towns[i].offices_count);
        towns[i].offices = malloc (sizeof (post_office) * towns[i].offices_count);
        for (int j = 0; j < towns[i].offices_count; j++)
        {
            scanf ("%d%d%d", &towns[i].offices[j].packages_count, &towns[i].offices[j].min_weight, &towns[i].offices[j].max_weight);
            towns[i].offices[j].packages = malloc (sizeof (package) * towns[i].offices[j].packages_count);
            for (int k = 0; k < towns[i].offices[j].packages_count; k++)
            {
                towns[i].offices[j].packages[k].id = malloc (sizeof (char) * MAX_STRING_LENGTH);
                scanf ("%s", towns[i].offices[j].packages[k].id);
                scanf ("%d", &towns[i].offices[j].packages[k].weight);
            }
        }
    }

    int queries;
    scanf ("%d", &queries);
    char town_name[MAX_STRING_LENGTH];
    while (queries--)
    {
        int type;
        scanf ("%d", &type);
        switch (type)
        {
            case 1:
                scanf ("%s", town_name);
                town* t = find_town (towns, towns_count, town_name);
                print_all_packages (*t);
                break;
            case 2:
                scanf ("%s", town_name);
                town* source = find_town (towns, towns_count, town_name);
                int source_index;
                scanf ("%d", &source_index);
                scanf ("%s", town_name);
                town* target = find_town (towns, towns_count, town_name);
                int target_index;
                scanf ("%d", &target_index);
                send_all_acceptable_packages (source, source_index, target, target_index);
                break;
            case 3:
                printf ("Town with the most number of packages is %s\n", town_with_most_packages (towns, towns_count).name);
                break;
        }
    }
    return 0;
}

void print_all_packages (town t)
{
    printf ("%s:\n", t.name);
    for (int i = 0; i < t.offices_count; i++)
    {
        printf ("\t%d:\n", i);
        for (int j = 0; j < t.offices[i].packages_count; j++)
            printf ("\t\t%s\n", t.offices[i].packages[j].id);
    }
}

void send_all_acceptable_packages (town* source, int source_office_index, town* target, int target_office_index)
{
    int source_package_count = (*source).offices[source_office_index].packages_count;
    int target_package_count = (*target).offices[target_office_index].packages_count;
    int target_min_weight = (*target).offices[target_office_index].min_weight;
    int target_max_weight = (*target).offices[target_office_index].max_weight;
    package* accepted = calloc (source_package_count, sizeof (package));
    package* rejected = calloc (source_package_count, sizeof (package));
    int accepted_count = 0, rejected_count = 0;
    // move into accepted or rejected
    for (int i = 0; i < source_package_count; i++)
    {
        package item = (*source).offices[source_office_index].packages[i];
        if (item.weight >= target_min_weight && item.weight <= target_max_weight)
            accepted[accepted_count++] = item;
        else
            rejected[rejected_count++] = item;
    }
    // send accepted package
    (*target).offices[target_office_index].packages = realloc ((*target).offices[target_office_index].packages, (target_package_count + accepted_count) * sizeof (package));
    (*target).offices[target_office_index].packages_count = target_package_count + accepted_count;
    for (int i = 0; i < accepted_count; i++)
    {
        (*target).offices[target_office_index].packages[target_package_count + i] = accepted[i];
    }
    // return rejected package
    (*source).offices[source_office_index].packages = realloc ((*source).offices[source_office_index].packages, rejected_count * sizeof (package));
    (*source).offices[source_office_index].packages_count = rejected_count;
    for (int i = 0; i < rejected_count; i++)
    {
        (*source).offices[source_office_index].packages[i] = rejected[i];
    }
    // clean memory
    free (accepted);
    free (rejected);
}

town town_with_most_packages (town* towns, int towns_count)
{
    int max_town_index = 0;
    int max_town_package = 0;
    for (int i = 0; i < towns_count; i++)
    {
        int sum = 0;
        for (int j = 0; j < towns[i].offices_count; j++)
            sum += towns[i].offices[j].packages_count;
        if (sum > max_town_package)
        {
            max_town_index = i;
            max_town_package = sum;
        }
    }
    return towns[max_town_index];
}

town* find_town (town* towns, int towns_count, char* name)
{
    for (int i = 0; i < towns_count; i++)
        if (strcmp (towns[i].name, name) == 0)
            return &towns[i];
    return NULL;
}
