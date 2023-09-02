#include<stdio.h>

int main(){
	int T;
	char C[101];
	int N[101];
	
	scanf("%d", &T);
	fflush(stdin);
	
	for(int t=0; t<T; t++){
		scanf("%c %d", &C[t], &N[t]);
		fflush(stdin);
	}
	
	
	for(int t=0; t<T; t++){	
		printf("Case #%d:\n", t+1);
		if(C[t] =='>'){
			for(int i=0; i<N[t]; i++){
				for(int j=0; j<N[t]+(N[t]/2+1); j++){
					if(j==(i*2)){
						printf("*");
					}
					else{
						printf("_");
					}
				}
				printf("\n");
			}
			for(int i=0; i<N[t]; i++){
				for(int j=0; j<N[t]+(N[t]/2+1); j++){
					if(j==N[t]+(N[t]/2+1)-(i*2+1)){
						printf("*");
					}
					else{
						printf("_");
					}
				}
				printf("\n");
			}
			
			printf("\n");
		}
		else if(C[t] =='<'){
			for(int i=0; i<N[t]; i++){
				for(int j=0; j<N[t]+(N[t]/2+1); j++){
					if(j==N[t]+(N[t]/2+1)-(i*2+1)){
						printf("*");
					}
					else{
						printf("_");
					}
				}
				printf("\n");
			}
			for(int i=0; i<N[t]; i++){
				for(int j=0; j<N[t]+(N[t]/2+1); j++){
					if(j==(i*2)){
						printf("*");
					}
					else{
						printf("_");
					}
				}
				printf("\n");
			}
			printf("\n");
		}
		
		
		
	}	
	
	
	return 0;
}
