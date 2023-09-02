#include<stdio.h>
#include<string.h>
int main(){
	char angka[31];
	
	scanf("%s", angka);
	int N = strlen(angka);
	
	for(int i=0; i<30-N; i++){
		printf("0");
	}
	printf("%s", angka);
	
	
	
	return 0;
}
