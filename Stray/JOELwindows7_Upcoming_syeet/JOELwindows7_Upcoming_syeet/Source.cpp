#include<stdio.h>
#include<math.h>
#include<string.h>
#include<ctype.h>
#include<time.h>
#include<iostream>
using namespace std;

struct ipkmhs {
	char nim[11];
	char name[30];
	float gpa;
} mhs[5];

int main(){
	int N = 5;//how many
	int Filled[2] = {0, 0};
	char ipklist[2][5][30]; //[0] Best, [1] worst; [N] how many; [C] Char limit

	for(int i = 0; i < N; i++){
		printf("Student %d\n==================\n", i);
		
		printf("Insert Name	: ");
		do{
			scanf("%[^\n]", mhs[i].name);
		} while(strlen(mhs[i].name) < 0 || strlen(mhs[i].name) > 30); 

		printf("Insert NIM	: ");
		do{
			scanf("%s", mhs[i].nim);
		} while(strlen(mhs[i].nim) < 0 || strlen(mhs[i].nim) > 11);

		printf("Insert GPA	: ");
		do{
			scanf(" %f", &mhs[i].gpa);
		} while(mhs[i].gpa < 0 || mhs[i].gpa > 4.00);
	};

	for(int i = 0; i < N; i++){
		if(mhs[i].gpa >= 3.00) strcpy(ipklist[0][Filled[0]], mhs[i].name);
		Filled[0]++;

		if(mhs[i].gpa < 3.00) strcpy(ipklist[0][Filled[1]], mhs[i].name);
		Filled[1]++;
	};

	printf("Mahasiswa GPA >=3\n");
	for(int i = 0; i < Filled[0]; i++){
		printf("%s\n", ipklist[0][i]);
	};

	printf("Mahasiswa GPA <3\n");
	for(int i = 0; i < Filled[1]; i++){
		printf("%s\n", ipklist[1][i]);
	};

	getchar();
	return 0;
}