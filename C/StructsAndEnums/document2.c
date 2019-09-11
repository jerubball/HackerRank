#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#define MAX_CHARACTERS 1005
#define MAX_PARAGRAPHS 5

struct word
{
    char* data;
};

struct sentence
{
    struct word* data;
    int word_count; //denotes number of words in a sentence
};

struct paragraph
{
    struct sentence* data;
    int sentence_count; //denotes number of sentences in a paragraph
};

struct document
{
    struct paragraph* data;
    int paragraph_count; //denotes number of paragraphs in a document
};

struct document get_document (char* text);
struct word kth_word_in_mth_sentence_of_nth_paragraph (struct document Doc, int k, int m, int n);
struct sentence kth_sentence_in_mth_paragraph (struct document Doc, int k, int m);
struct paragraph kth_paragraph (struct document Doc, int k);
void print_word (struct word w);
void print_sentence (struct sentence sen);
void print_paragraph (struct paragraph para);
void print_document (struct document doc);
char* get_input_text ();

int main ()
{
    char* text = get_input_text ();
    struct document Doc = get_document (text);

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
            struct word w = kth_word_in_mth_sentence_of_nth_paragraph (Doc, k, m, n);
            print_word (w);
        }
        else if (type == 2)
        {
            int k, m;
            scanf ("%d %d", &k, &m);
            struct sentence sen = kth_sentence_in_mth_paragraph (Doc, k, m);
            print_sentence (sen);
        }
        else
        {
            int k;
            scanf ("%d", &k);
            struct paragraph para = kth_paragraph (Doc, k);
            print_paragraph (para);
        }
        printf ("\n");
    }
}

struct document get_document (char* text)
{
    char *para_delim = "\n", *sent_delim = ".", *word_delim = " ";
    int para_count = 0;
    char* raw_para[MAX_PARAGRAPHS];
    char* para = strtok (text, para_delim);
    while (para != NULL)
    {
        raw_para[para_count++] = para;
        para = strtok (NULL, para_delim);
    }
    struct document Doc;
    Doc.paragraph_count = para_count;
    Doc.data = calloc (para_count, sizeof (struct paragraph));
    for (int i = 0; i < para_count; i++)
    {
        int sent_count = 0;
        char** raw_sent = NULL;
        char* sent = strtok (raw_para[i], sent_delim);
        while (sent != NULL)
        {
            raw_sent = realloc (raw_sent, (sent_count + 1) * sizeof (char*));
            raw_sent[sent_count++] = sent;
            sent = strtok (NULL, sent_delim);
        }
        Doc.data[i].sentence_count = sent_count;
        Doc.data[i].data = calloc (sent_count, sizeof (struct sentence));
        for (int j = 0; j < sent_count; j++)
        {
            int word_count = 0;
            char** raw_word = NULL;
            char* word = strtok (raw_sent[j], word_delim);
            while (word != NULL)
            {
                raw_word = realloc (raw_word, (word_count + 1) * sizeof (char*));
                raw_word[word_count++] = word;
                word = strtok (NULL, word_delim);
            }
            Doc.data[i].data[j].word_count = word_count;
            Doc.data[i].data[j].data = calloc (word_count, sizeof (struct word));
            for (int k = 0; k < word_count; k++)
                Doc.data[i].data[j].data[k].data = raw_word[k];
            free (raw_word);
        }
        free (raw_sent);
    }
    //free (raw_para);
    return Doc;
}

struct word kth_word_in_mth_sentence_of_nth_paragraph (struct document Doc, int k, int m, int n)
{
    return Doc.data[n - 1].data[m - 1].data[k - 1];
}

struct sentence kth_sentence_in_mth_paragraph (struct document Doc, int k, int m)
{
    return Doc.data[m - 1].data[k - 1];
}

struct paragraph kth_paragraph (struct document Doc, int k)
{
    return Doc.data[k - 1];
}

void print_word (struct word w)
{
    printf ("%s", w.data);
}

void print_sentence (struct sentence sen)
{
    for (int i = 0; i < sen.word_count; i++)
    {
        print_word (sen.data[i]);
        if (i != sen.word_count - 1)
            printf (" ");
    }
}

void print_paragraph (struct paragraph para)
{
    for (int i = 0; i < para.sentence_count; i++)
    {
        print_sentence (para.data[i]);
        printf (".");
    }
}

void print_document (struct document doc)
{
    for (int i = 0; i < doc.paragraph_count; i++)
    {
        print_paragraph (doc.data[i]);
        if (i != doc.paragraph_count - 1)
            printf("\n");
    }
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
            strcat (doc, "\n");
    }

    char* returnDoc = (char*) malloc ((strlen (doc) + 1) * sizeof (char));
    strcpy (returnDoc, doc);
    return returnDoc;
}
