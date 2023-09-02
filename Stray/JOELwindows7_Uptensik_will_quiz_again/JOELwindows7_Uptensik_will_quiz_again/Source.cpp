 #include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<time.h>
#include<math.h>
#include<iostream>
using namespace std;

//Dota!
// Name MMR(SCORE_AVG) NumberOfPlaying

struct Gamers {
	char nama[10];
	int score;
	int NumPlayer;
} Player[100];

int main() {
	bool flag_found = false;
	int kounter = 0, select, flag=0;
	struct Gamers InsertTemp;
	FILE *fdata;

	printf("Loading data...\n");
	fdata = fopen("data.txt", "r");
	while(fscanf(fdata, "%s %d %d\n", Player[kounter].nama, &Player[kounter].score, &Player[kounter].NumPlayer) != EOF) {
		kounter++;
	};
	fclose(fdata);
	printf("Load Complete!");

	//debug
	/*for(int i=0; i < kounter; i++){
		printf("%s %d %d\n", Player[i].nama, Player[i].score, Player[i].NumPlayer);
	};

	getchar();*/
	//debug end

	system("cls");

	do{
		system("cls");
		for(int i=0; i<17; i++) printf("\n");
		printf("Score Record DotA Player\n");
		printf("========================\n");
		printf("1.View Record\n");
		printf("2.Add Player Record\n");
		printf("3.Add New Player\n");
		printf("4.Delete Player\n");
		printf("5.Save and Exit\n");
		printf("\n");
		printf("Input your choice[1..5]: ");

		scanf("%d", &select);

		switch(select) {
		case 1: //View Record
			system("cls");
			printf		("  Player Name		| MMR		| Number of Playing\n");
			printf		("=======================================================\n");
			for(int i=0; i<kounter; i++){
				printf	("  %s			| %d		| %d	\n", Player[i].nama, Player[i].score, Player[i].NumPlayer);
			}
			printf("\nPress Enter to continue.....");
			getchar(); getchar();
			break;
		case 2: //Add Player Record
			printf		("  Player Name		| MMR		| Number of Playing\n");
			printf		("=======================================================\n");
			for(int i=0; i<kounter; i++){
				printf	("  %s			| %d		| %d	\n", Player[i].nama, Player[i].score, Player[i].NumPlayer);
			}
			printf("\n");

			do{
			printf("Input player name[1..10]: ");
			scanf("%s", InsertTemp.nama); fflush(stdin);
			} while(strlen(InsertTemp.nama) > 10);
			do{
			printf("Input player score[1..3500]: ");
			scanf("%d", &InsertTemp.score); fflush(stdin);
			} while(InsertTemp.score > 3500);

			//search
			for(int i=0; i < kounter; i++){
				if(strcmp(InsertTemp.nama, Player[i].nama) == 0){
					flag = i;
					flag_found = true;
					break;
				}
				else {
					//flag = 1111;
				};
			};
			//end search

			if(flag_found == true){
				//Insert Score
			Player[flag].score += InsertTemp.score;
			Player[flag].score /= 2; //Averaged
				//end Insert

			Player[flag].NumPlayer++;

			printf("\nScore successfully updated^^\n");
			flag_found = false;
			} else if(flag_found == false){
				printf("\nName of %s not found!\n", InsertTemp.nama);
			};

			printf("\nTekan ENTER untuk melanjutkan....");
			getchar(); getchar();
			break;
		case 3: //add new player
			printf("  Player Name		| MMR		| Number of Playing\n");
			printf("=======================================================\n");
			for (int i = 0; i<kounter; i++) {
				printf("  %s			| %d		| %d	\n", Player[i].nama, Player[i].score, Player[i].NumPlayer);
			}

			do {
				printf("Input player name[1..10]: ");
				scanf("%s", InsertTemp.nama); fflush(stdin);
			} while (strlen(InsertTemp.nama) > 10);

			//search already exist
			for (int i = 0; i < kounter; i++) {
				if (strcmp(InsertTemp.nama, Player[i].nama) == 0) {
					flag = i;
					flag_found = true;
					break;
				}
				else {
					//flag = 1111;
				};
			};
			//end search

			if (flag_found == true) {

				printf("\player name already exists in the list!\n");
				flag_found = false;
			}
			else if (flag_found == false) {
				strcpy(Player[kounter].nama, InsertTemp.nama);
				kounter++;
				printf("\nData successfully added..\n");
			};

			printf("\nTekan ENTER untuk melanjutkan.....");
			getchar();

			getchar();
			break;
		case 4: //delete player

			do {
				printf("Input player name[1..10 kar]: ");
				scanf("%s", InsertTemp.nama); fflush(stdin);
			} while (strlen(InsertTemp.nama) > 10);

			for (int i = 0; i < kounter; i++) {
				if (strcmp(InsertTemp.nama, Player[i].nama) == 0) {
					flag = i;
					flag_found = true;
					break;
				}
				else {
					//flag = 1111;
				};
			};
			//end search

			if (flag_found == true) {
				for (int i = flag; i < kounter - 1; i++) {
					Player[i] = Player[i + 1];
				};
				kounter--;

				printf("\n%s successfully deleted..\n", InsertTemp.nama);
				flag_found = false;
			}
			else if (flag_found == false) {
				printf("\nName of %s not found!\n", InsertTemp.nama);
			};

			printf("\nPress Enter to continue....");
			getchar(); getchar();

			break;
		case 5: //exit game
			//exit this area
			break;
		}
		
	}while (select !=5);

	printf("Saving data...\n");
	fdata = fopen("data.txt", "w");
	for(int i=0; i < kounter; i++){
		fprintf(fdata, "%s %d %d\n", Player[i].nama, Player[i].score, Player[i].NumPlayer);
	};
	fclose(fdata);
	printf("Save Complete!");

	//debug
	/*system("cls");
	int debug_kounter = 0;
	struct Gamers debug_Player[100];
	FILE *debug_fdata;

	debug_fdata = fopen("data.txt", "r");

	while(fscanf(debug_fdata, "%s %d %d\n", debug_Player[debug_kounter].nama, &debug_Player[debug_kounter].score, &debug_Player[debug_kounter].NumPlayer) != EOF) {
		//fscanf(debug_fdata, "%s %d %d\n", debug_Player[debug_kounter].nama, &debug_Player[debug_kounter].score, &debug_Player[debug_kounter].NumPlayer);
		debug_kounter++;
	};

	for(int i=0; i < debug_kounter; i++){
		printf("%s %d %d", debug_Player[i].nama, debug_Player[i].score, debug_Player[i].NumPlayer);
	};

	fclose(debug_fdata);
	getchar();*/
	//debug end

	return 0;
}