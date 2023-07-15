#include <stdio.h>
#include <stdlib.h>

struct Data{
	int val;
	struct Data *next, *prev;
}*head, *tail, *curr;

void pushTail(int val)
{
	curr = (struct Data*)malloc(sizeof(struct Data));
	curr->val = val;
	curr->next = curr->prev = NULL;
	
	if(head == NULL)
	{
		head = tail = curr;
	}
	else
	{
		tail->next = curr;
		curr->prev = tail;
		tail = tail->next;
	}
	
	head->prev = tail;
	tail->next = head;
}

void display()
{
	curr = head;	
	while(curr){
		printf("%d", curr->val);
		curr = curr->next;		
		
		if(curr != head) printf(" => ");
		else {
			printf("\n"); 
			break;	
		}
	}	
}

void popTail(){
	
	if(head){
		curr = tail;
		if(head == tail)
		{
			head = tail = NULL;
		}
		else
		{
			tail = tail->prev;	
			tail->next = head;
		}		
		free(curr);		
	}
}

void popAll(){	
	while(head){
		popTail();		
	}	
}

int main(){
	pushTail(5);
	pushTail(15);
	pushTail(25);
	pushTail(35);
	
	display();
	puts("");
	
	popTail();
	display();
	puts("");
	
	popAll();
	return 0;
}
