#include<stdio.h>
#include<stdlib.h>
//include<_dbdao.h>
#include<string.h>

int main(){
	//selection
	/*
		pilihan apa bercabang
	*/

	float ipk;
	int pilih=0;

	/*do{
		printf("masukan ipk: ");
		scanf("%f", &ipk);
		fflush(stdin);
	} while(ipk > 4 || ipk < 0);

	if(ipk >= 3.5) 
		printf("Cumlaude");
	else if (ipk >= 3)
		printf("Outstanding");
	else if (ipk >= 2.5)
		printf("Very good");
	else if(ipk >= 2)
		printf("Good");
	else printf("Poor");*/


	/*scanf("%d", &pilih); fflush(stdin);

	switch(pilih){
	case 1:
		printf("menu 1");
		break;
	case 2:
		printf("menu 2");
		break;
	} */

	/*for(int i = 1; i<= 5;i++)
		printf("%d ", i);

	printf("\n");

	int i=1;
	while(i <= 5){
		printf("%d ", i);
		i++;
	};

	do{
		printf("%d", i);
		i++;
	} while (i <= 5);*/

	for(int j=0; j < 5; j++){
		for(int i=0; i <= j; i++){
			printf("*");
		};
		printf("\n");
	};

	getchar();
	return 0;
}