#ifndef LIST_H
#define	LIST_H


typedef int entryType;
typedef char keyType;

typedef struct node
{
    entryType info;
    struct node* next;
}Node;

typedef Node* list;

void createList(list* l);
void addElement(list* l, entryType item);

typedef struct map{
    list value;
    keyType key;
    struct map* next;
}multiMap;

typedef multiMap* Map;

//user function
void createMap(Map* m);
void addNewElement(Map *m, keyType key, entryType value);
void removeKey(Map* m, keyType key);
void editValue(Map* m, keyType key, entryType value, entryType updateVal);
void showKeyVals(Map* m, keyType key);

#endif	/* LIST_H */

