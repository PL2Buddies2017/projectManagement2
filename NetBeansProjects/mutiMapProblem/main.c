#include <stdio.h>
#include <stdlib.h>
#include "list.h"
int main() 
{
    Map m;
    createMap(&m);
    addNewElement(&m,'a',10);
    addNewElement(&m,'a',20);
    addNewElement(&m,'a',30);
    showKeyVals(&m,'a');
    
    /*list l;
    createList(&l);
    addElement(&l,1);
    addElement(&l,2);
    addElement(&l,3);
    addElement(&l,4);
    printf("%d",l->info);
     */
    return 0;
}

