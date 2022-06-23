#include<stdio.h>

//test 1

void main(){
	
	/*int a,t;
	float l;*/
	//
	//printf("alas: ");//cetak tulisan
	//scanf("%d",&a);
	//fflush(stdin);
	//
	//printf("tinggi: ");//cetak tulisan
	//scanf("%d",&t);
	//fflush(stdin);
	//
	////l = (float)a*t/2;//parsing
	//l = a*t/2.0;//parsing

	//printf("Luas segitiga: %.1f",l);
	
	/*int nilai;*/

	/*printf("Masukkan Nilai Anda: ");
	scanf("%d",&nilai);
	fflush(stdin);*/

	/*if (nilai>=90 && nilai<=100){
		printf("Nilai anda A");
	}
	else if(nilai >=0 && nilai<=89){
		printf("Anda tidak lulus");
	}
	else{
		printf("Masukin nilai yang benar donk!!!");
	}
	*/

	//switch(nilai){
	//case 1:
	//	printf("Anda tidak lulus");
	//	break;
	//case 2:
	//	printf("Anda lulus");
	//	break;
	//}
	
	int i,j,k,l;
	
	printf("Masukkan angka vertical: ");
	scanf("%d",&j);
	fflush(stdin);

	printf("Masukkan angka horizontal: ");
	scanf("%d",&k);
	fflush(stdin);

	printf("Masukkan angka perkalian: ");
	scanf("%d",&l);
	fflush(stdin);
	
	for(i=1;i<j;i++){
		for(j=0;j<k;j++){
			printf("*");
		}
		printf("\n");
	}

	for(i=0;i<=k;i++){
		for(j=0;j<i;j++){
			printf("*");
		}
		printf("\n");
	}

	/*do{
		printf("*");
		i=i+1;
	}while(i<j);*/

	for(i=0;i<=10;i++){
		printf("%d x %d = %d\n",i,l,i*l);
	}
	getchar();
}
