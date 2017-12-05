#include "list.h"
#include <stdio.h>
#include <stdlib.h>


void createList(list* l)
{
   *l = NULL;
}

void addElement(list* l, entryType item)
{
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->info = item;
    newNode->next = *l;
    *l = newNode;
}

void createMap(Map* m)
{
    *m = NULL;
   
}
void addNewElement(Map *m, keyType key, entryType value)
{
    multiMap* trav = *m;
    int found = 0;
    while(trav)
    {
        if(trav->key == key)
        {
            addElement(&trav->value, value);
            found = 1;
            break;
        }
        trav = trav->next;
    }
    if (found == 0)
    {
        multiMap* newNode = (multiMap*)malloc(sizeof(multiMap));
        newNode->key = key;
        createList(&newNode->value);
        addElement(&newNode->value, value);
        newNode->next = *m;
        *m = newNode;
    }
}


void removeKey(Map* m, keyType key)
{
    multiMap* trav = *m, *temp;
    if(trav->key == key)
    {
        temp = trav;
        *m = trav->next;
        free(temp);
    }
    else
    {
        while(trav->next)
        {
            if(trav->next->key == key)
            {
                temp = trav->next;
                trav->next = temp->next;
                free(temp);
                break;
            }
            trav = trav->next;
        }
    }
}

void editValue(Map* m, keyType key, entryType value, entryType updateVal)
{
    multiMap* mval = *m;
    while(mval)
    {
        if(mval->key == key)
            break;
        mval = mval->next;
    }
    Node* trav = mval->value;
    while(trav)
    {
        if(trav->info == value)
        {
            trav->info = updateVal;
            break;
        }
        trav = trav->next;
    }
}

void showKeyVals(Map* m, keyType key)
{
    multiMap* trav = *m;
    int found = 0;
    while(trav)
    {
        if(trav->key == key)
        {
            found = 1;
            Node* vals = trav->value;
            while(vals)
            {
                printf("%d ",vals->info);
                vals = vals->next;
            }
        }
        trav = trav->next;
    }
    if (found == 0)
    {
        printf("Key Not Found");
    }
}
