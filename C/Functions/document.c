#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

#define MAX_CHARACTERS 1005
#define MAX_PARAGRAPHS 5

char* kth_word_in_mth_sentence_of_nth_paragraph (char**** document, int k, int m, int n);
char** kth_sentence_in_mth_paragraph (char**** document, int k, int m);
char*** kth_paragraph (char**** document, int k);
char**** get_document (char* text);
char* get_input_text ();
void print_word (char* word);
void print_sentence (char** sentence);
void print_paragraph (char*** paragraph);

/*
 * HackerRank C Functions 6
 * https://www.hackerrank.com/challenges/querying-the-document/problem
 * Author: Hasol
 */
int main ()
{
    char* text = get_input_text ();
    char**** document = get_document (text);

    int q;
    scanf ("%d", &q);

    while (q--)
    {
        int type;
        scanf ("%d", &type);

        if (type == 3)
        {
            int k, m, n;
            scanf ("%d %d %d", &k, &m, &n);
            char* word = kth_word_in_mth_sentence_of_nth_paragraph (document, k, m, n);
            print_word (word);
        }
        else if (type == 2)
        {
            int k, m;
            scanf ("%d %d", &k, &m);
            char** sentence = kth_sentence_in_mth_paragraph (document, k, m);
            print_sentence (sentence);
        }
        else
        {
            int k;
            scanf ("%d", &k);
            char*** paragraph = kth_paragraph (document, k);
            print_paragraph (paragraph);
        }
        printf("\n");
    }
}

char* kth_word_in_mth_sentence_of_nth_paragraph (char**** document, int k, int m, int n)
{
    return document[n - 1][m - 1][k - 1];
}

char** kth_sentence_in_mth_paragraph (char**** document, int k, int m)
{
    return document[m - 1][k - 1];
}

char*** kth_paragraph (char**** document, int k)
{
    return document[k - 1];
}

char**** get_document (char* text)
{
    char* text_copy = malloc ((strlen (text) + 1) * sizeof (char));
    strcpy (text_copy, text);
    int para_len = 0;
    char** raw_para = NULL;
    char* para_delim = "\n";
    // convert each paragraph to string
    char* para = strtok (text_copy, para_delim);
    while (para != NULL)
    {
        raw_para = realloc (raw_para, (para_len + 1) * sizeof (char*));
        //raw_para[para_len] = calloc ((strlen (para) + 1), sizeof (char));
        //strcpy (raw_para[para_len++], para);
        raw_para[para_len++] = para;
        para = strtok (NULL, para_delim);
    }
    char*** raw_sent = calloc (para_len, sizeof (char**));
    char**** raw_word = calloc (para_len, sizeof (char***));
    char* sent_delim = ".";
    char* word_delim = " ";
    // for each paragraph
    for (int i = 0; i < para_len; i++)
    {
        int sent_len = 0;
        raw_sent[i] = NULL;
        // convert each sentence to string
        char* sent = strtok (raw_para[i], sent_delim);
        while (sent != NULL)
        {
            raw_sent[i] = realloc (raw_sent[i], (sent_len + 1) * sizeof (char*));
            //raw_sent[i][sent_len] = calloc ((strlen (sent) + 1),  sizeof (char));
            //strcpy (raw_sent[i][sent_len++], sent);
            raw_sent[i][sent_len++] = sent;
            sent = strtok (NULL, sent_delim);
        }

        raw_word[i] = calloc (sent_len, sizeof (char**));
        // for each sentence
        for (int j = 0; j < sent_len; j++)
        {
            int word_len = 0;
            raw_word[i][j] = NULL;
            // convert each word to string
            char* word = strtok (raw_sent[i][j], word_delim);
            while (word != NULL)
            {
                raw_word[i][j] = realloc (raw_word[i][j], (word_len + 1) * sizeof (char*));
                //raw_word[i][j][word_len] = calloc ((strlen (word) + 1),  sizeof (char));
                //strcpy (raw_word[i][j][word_len++], word);
                raw_word[i][j][word_len++] = word;
                word = strtok (NULL, word_delim);
            }
        }
    }
    return raw_word;
}

char* get_input_text ()
{
    int paragraph_count;
    scanf ("%d", &paragraph_count);

    char p[MAX_PARAGRAPHS][MAX_CHARACTERS], doc[MAX_CHARACTERS];
    memset (doc, 0, sizeof (doc));
    getchar ();
    for (int i = 0; i < paragraph_count; i++)
    {
        scanf ("%[^\n]%*c", p[i]);
        strcat (doc, p[i]);
        if (i != paragraph_count - 1)
            strcat(doc, "\n");
    }

    char* returnDoc = (char*) malloc ((strlen (doc) + 1) * (sizeof (char)));
    strcpy (returnDoc, doc);
    return returnDoc;
}

void print_word (char* word)
{
    printf ("%s", word);
}

void print_sentence (char** sentence)
{
    int word_count;
    scanf ("%d", &word_count);
    for (int i = 0; i < word_count; i++)
    {
        printf ("%s", sentence[i]);
        if (i != word_count - 1)
            printf (" ");
    }
} 

void print_paragraph (char*** paragraph)
{
    int sentence_count;
    scanf ("%d", &sentence_count);
    for (int i = 0; i < sentence_count; i++)
    {
        print_sentence (*(paragraph + i));
        printf (".");
    }
}
