#include<stdio.h>
#include<string.h>

int T,N[101];
int main(){
	char win[101][101];
	
	do{
	scanf("%d", &T);
	fflush(stdin);
	}while(T<1||T>100); //validasi
	
	for(int i=0; i<T; i++){
		scanf("%d", &N[i]);
		scanf("%s", win[i]);
	}
	
	int L,B;
	for(int i=0; i<T; i++){
		L = 0;
		B = 0;
		for(int j=0; j<strlen(win[i]); j++){
			if(win[i][j]=='L'){
				L++;
			}
			else if(win[i][j]=='B'){
				B++;
			}
		}
		if(L>B){
			printf("Lili\n");
		}
		else if(B>L){
			printf("Bibi\n");
		}
		else if(L==B){
			printf("None\n");
		}
	}
	
	
	
	
	return 0;
}
