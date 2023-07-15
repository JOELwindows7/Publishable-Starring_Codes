#include <stdio.h> // i/o
#include <stdlib.h> // malloc, system
#include <string.h> // strlen & string function
#define FULL 10

struct Data
{
	char k;
	struct Data * next;
}*head, *tail, *curr;

void display();
void pushTail(char k);
void popHead();
void popAll();
char peek(); // top(); return top data / last pushed data if exist, else return -1
int size(); // numNodes in stack lists  
int is_empty(); // return 1 if size() == 0, else return 0
int is_full(); // return 1 if size() == FULL, else return 0

int main()
{
	int pilih, i;
	char kata[100]={0};
	do
	{
		system("cls");
		printf("queue\n");
		printf("=====\n\n");
		printf("size() : %d\n", size());
		printf("is_empty() : %d\n", is_empty());
		printf("is_full() : %d\n", is_full());
		puts("");
		display();
		printf("\n\n");
		printf("1. Input Kata, push char ke queue [max 10 kar]\n");
		printf("2. DeQueue\n");
		printf("3. Peek / Front\n");
		printf("0. Exit, PopAll\n");
		printf("Pilih : ");
		scanf("%d", &pilih); fflush(stdin);
		switch(pilih)
		{
		case 1 : printf("Masukkan kata : ");
				 gets(kata); fflush(stdin);
				 if(strlen(kata) + size() <= FULL)
				 {
					 for(i=0; i<strlen(kata); i++)
					 {
						 pushTail(kata[i]);
					 } 
				 }
				 else
				 {
					 printf("jika diinsert FULL!"); 
					 getchar();
				 }
				 break;
		case 2 : popHead(); break;
		case 3 : printf("\npeekChar() : '%c'\n", peek()); getchar(); break;
		}
	} while (pilih != 0);
	popAll();
	return 0;
}

int is_full()
{
	if(size() == FULL)
		return 1;
	else 
		return 0;
}

int is_empty()
{
	if(head==NULL)
		return 1;
	else return 0;
}


int size()
{
	struct Data * curr;
	int n=0;
	curr = head;
	while(curr)
	{
		curr = curr->next;
		n++;
	}
	return n;
}

char peek()
{
	if(head)
		return head->k;
	else return -1;
}

void popAll()
{
	while(head)
	{
		popHead();
	}
}

void popHead()
{
	struct Data *curr;
	curr = head;

	if(head == tail) // data satu-satunya
	{
		head = tail = NULL;
	}
	else
	{
		head = head->next;
	}

	free(curr);
}


void pushTail(char k)
{
	curr = (struct Data *) malloc(sizeof(struct Data));
	curr->k = k;
	curr->next = NULL;

	if(head==NULL) // data pertama
	{
		head = tail = curr;
	}
	else
	{
		tail->next = curr;
		tail = curr;
	}
}

void display()
{
	struct Data *curr;
	curr = head;
	while(curr) // Non-Zero => True
	{
		printf("%c ", curr->k);
		curr = curr->next;
	}
}