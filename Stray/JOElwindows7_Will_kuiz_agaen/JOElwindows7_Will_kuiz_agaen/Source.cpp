#include<stdio.h>
#include<string.h>
#include<math.h>
#include<ctype.h>
#include<time.h>
#include<stdlib.h>
#include<iostream>
using namespace std;

struct MovieList {
	char Movie[100];
	int Airtime[2];
	int Seats;
} Films[100];

void swapy(int *angka, int *angka2){
	int temp;
	temp = *angka;
	*angka = *angka2;
	*angka2 = temp;
}

//void swapStruct(struct MovieList Place1, struct MovieList Place2) {
//	struct MovieList tempor;
//	tempor = Place1;
//	Place1 = Place2;
//	Place2 = tempor;
//}

int main() {
	struct MovieList InsertTemp;
	struct MovieList PutTemp;
	int Sekonds[100], Minuten[100];
	int max = 0, min = 0, y = 0;
	int select, kounter = 0;
	int flag = 0, l = 0;
	bool flag_found = false;
	bool changed = false;
	FILE *filem;

	printf("Opening Save file...\n");
	filem = fopen("soal10.txt", "r");

	printf("Loading Save file...\n");
	while(fscanf(filem, "%s %d.%d %d\n", &Films[kounter].Movie, &Films[kounter].Airtime[0], &Films[kounter].Airtime[1], &Films[kounter].Seats) != EOF){
		printf("Loaded File %d: [Title] %s, [Airtime] %d.%d, [Seat]%d\n", kounter, Films[kounter].Movie, Films[kounter].Airtime[0], Films[kounter].Airtime[1], Films[kounter].Seats);
		kounter++;
	};
	printf("Load Complete!\n");
	printf("Closing File...\n");
	fclose(filem);

	for (int i = 0; i < kounter; i++) {
		Sekonds[i] = (Films[i].Airtime[0] * 3600) + (Films[i].Airtime[1] * 60);
		Minuten[i] = (Films[i].Airtime[0] * 60) + (Films[i].Airtime[1]);
	}
	
	do{
		system("cls");
		for(int i = 0; i < 23; i++) printf("\n");
		printf("Bluejack Theater\n");
		printf("============================\n");
		printf("1.Movie List\n");
		printf("2.Sort ascending by airtime\n");
		printf("3.Sort descending by movie title\n");
		printf("4.Add movie\n");
		printf("5.Ticket reservation\n");
		printf("6.Exit\n");
		printf("\n");
		printf("input your choice [1..6]: ");

		scanf("%d", &select); fflush(stdin);

		switch(select){
		default: //out of statements
			break;
		case 1111:
			for (int i = 0; i < kounter; i++) {
				Sekonds[i] = (Films[i].Airtime[0] * 3600) + (Films[i].Airtime[1] * 60);
				Minuten[i] = (Films[i].Airtime[0] * 60) + (Films[i].Airtime[1]);
			}
			printf("\n		----=Movie List=----\n");
			printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			printf("\n");
			printf(" No| Movie_Title    	| AirMinute	| Available_seat\n");
			printf("=========================================================\n");
			for (int i = 0; i < kounter; i++) {
				printf(" %d | %-25s| %04d	| %-2d\n", i + 1, Films[i].Movie, Minuten[i], Films[i].Seats);
			}
			printf("=========================================================\n");

			printf("\npress enter to continue.."); getchar(); getchar();
			break;
		case 1000:
			for (int i = 0; i < kounter; i++) {
				Sekonds[i] = (Films[i].Airtime[0] * 3600) + (Films[i].Airtime[1] * 60);
				Minuten[i] = (Films[i].Airtime[0] * 60) + (Films[i].Airtime[1]);
			}
			printf("\n		----=Movie List=----\n");
			printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			printf("\n");
			printf(" No| Movie_Title    	| AirSecond	| Available_seat\n");
			printf("=========================================================\n");
			for (int i = 0; i < kounter; i++) {
				printf(" %d | %-20s| %05d	| %-2d\n", i + 1, Films[i].Movie, Sekonds[i], Films[i].Seats);
			}
			printf("=========================================================\n");

			printf("\npress enter to continue.."); getchar(); getchar();
			break;
		case 1: //movie list
			printf("\n		----=Movie List=----\n");
			printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			printf("\n");
			printf(" No| Movie_Title    	| Airtime	| Available_seat\n");
			printf("=========================================================\n");
			for(int i = 0; i < kounter; i++){
				printf(" %d | %-20s| %02d.%02d	| %-2d\n", i+1, Films[i].Movie, Films[i].Airtime[0], Films[i].Airtime[1], Films[i].Seats);
			}
			printf("=========================================================\n");
			
			printf("\npress enter to continue.."); getchar(); getchar();
			break;
		case 2: //sort ascend airtime
			for (int i = 0; i < kounter; i++) {
				Sekonds[i] = (Films[i].Airtime[0] * 3600) + (Films[i].Airtime[1] * 60);
				Minuten[i] = (Films[i].Airtime[0] * 60) + (Films[i].Airtime[1]);
			}
			//bubbled
			/*for (int i = 0; i < kounter; i++) {
				for (int j = 0; j < kounter - 2; j++) {
					if (Sekonds[j] > Sekonds[j + 1]) {
						InsertTemp = Films[j];
						Films[j] = Films[j+1];
						Films[j + 1] = InsertTemp;
						swapy(&Minuten[j], &Minuten[j+1]);
						swapy(&Sekonds[j], &Sekonds[j+1]);
					};
				};
			};*/

			//selected
			for (int i = 0; i < kounter - 1; i++) {
				min = i;
				for (int j = i + 1; j < kounter; j++) {
					if (Minuten[min] > Minuten[j]) {
						min = j;
					};
				};
				if (Minuten[min] > i) {
					PutTemp = Films[i];
					Films[i] = Films[min];
					Films[min] = PutTemp;
					swapy(&Minuten[i], &Minuten[min]);
					swapy(&Sekonds[i], &Sekonds[min]);
				};
			};

			printf("\nsuccessfully sort..\n");
			printf("\nto view movie list : Menu '1'\n");
			changed = true;

			printf("\npress enter to continue.."); getchar(); getchar();
			break;
		case 3: //sort descend title
			for (int i = 0; i < kounter; i++) {
				Sekonds[i] = (Films[i].Airtime[0] * 3600) + (Films[i].Airtime[1] * 60);
				Minuten[i] = (Films[i].Airtime[0] * 60) + (Films[i].Airtime[1]);
			}
			//selected
			for (int i = 0; i < kounter - 1; i++) {
				max = i;
				for (int j = i; j < kounter; j++) {
					if (strcmp(Films[max].Movie, Films[j].Movie) < 0) {
						max = j;
					};
				};
				if (strcmp(Films[i].Movie, Films[max].Movie) < 0) {
					PutTemp = Films[i];
					Films[i] = Films[min];
					Films[min] = PutTemp;
					swapy(&Minuten[i], &Minuten[min]);
					swapy(&Sekonds[i], &Sekonds[min]);
				};
			};

			//Inserted
			/*for (int i = 1; i < kounter; i++) {
				y = Film[i];
			}*/

			//bubbled-flag
			/*flag = 0; l = 1;
			while ((l < kounter) && (!flag)) {
				flag = 1;
				for (int j = kounter - 1; j >= l; j--) {
					if (strcmp(Films[j + 1].Movie, Films[j].Movie) < 0) {
						PutTemp = Films[j+1];
						Films[j+1] = Films[j];
						Films[j] = PutTemp;
						flag = 0;
					}
				}
				l += 1;
			}*/

			//bubbled
			/*for (int i = 0; i < kounter; i++) {
				for (int j = kounter - 1; j >= i; j--) {
					if (strcmp(Films[j].Movie, Films[j+1].Movie) > 0) {
						InsertTemp = Films[j];
						Films[j] = Films[j + 1];
						Films[j + 1] = InsertTemp;
						swapy(&Minuten[j], &Minuten[j + 1]);
						swapy(&Sekonds[j], &Sekonds[j + 1]);
					};
				};
			};*/


			printf("\nsuccessfully sort..\n");
			printf("\nto view movie list : Menu '1'\n");
			changed = true;

			printf("\npress enter to continue.."); getchar(); getchar();
			break;
		case 4: //add movie
			printf("\n");
			do{
			printf("insert new movie title [1..10 char]: ");
			scanf("%s", InsertTemp.Movie); fflush(stdin);
			} while(strlen(InsertTemp.Movie) > 10);
			do{
			printf("insert airtime movie (hour) [1..23] : ");
			scanf("%d", &InsertTemp.Airtime[0]); fflush(stdin);
			} while(InsertTemp.Airtime[0] < 0 || InsertTemp.Airtime[0] > 23);
			do{
			printf("insert airtime movie (minutes) [0..59] : ");
			scanf("%d", &InsertTemp.Airtime[1]); fflush(stdin);
			} while(InsertTemp.Airtime[1] < 0 || InsertTemp.Airtime[1] > 59);

			strcpy(Films[kounter].Movie, InsertTemp.Movie);
			Films[kounter].Airtime[0] = InsertTemp.Airtime[1];
			Films[kounter].Airtime[1] = InsertTemp.Airtime[1];
			Films[kounter].Seats = 100;

			kounter++;

			printf("successfully add movie\n");
			changed = true;

			printf("\npress enter to continue.."); getchar(); getchar();
			break;
		case 5: //ticket reservation
			printf("\n");
			printf("insert movie titles that will be ordered [1..20 kar]: ");
			do {
				scanf("%s", InsertTemp.Movie); fflush(stdin);
			} while (strlen(InsertTemp.Movie) > 20);

			//search
			for(int i = 0; i < kounter; i++){
				if(strcmp(InsertTemp.Movie, Films[i].Movie) == 0){
					flag = i;
					flag_found = true;
					break;
				} else{

				}
			}

			if(flag_found == true){
				if(Films[flag].Seats > 0){
				do{
					printf("insert number of seats that will be ordered [1..%d]: ", Films[flag].Seats);
					scanf("%d", &InsertTemp.Seats); fflush(stdin);
				} while(InsertTemp.Seats < 0 || InsertTemp.Seats > Films[flag].Seats);

				Films[flag].Seats -= InsertTemp.Seats;

				printf("\nsuccessful order\n");
				changed = true;
				} else {
					printf("\nsorry, available of seat has been exhausted\n");
				}

			} else if (flag_found == false){
				printf("this movie can't play in bluejack theater..\n");
			}

			printf("\npress enter to continue.."); getchar(); getchar();
			break;
		case 6: //exit
			//exit area
			break;
		case 2222:
			system("cls");
			printf("treating changed to true!\n");
			changed = true;
			printf("Changes treated to true!\n");

			printf("\npress enter to continue.."); getchar(); getchar();
			break;
		};

	} while(select !=6);

	if (changed == false) {
		printf("No change were made! ignoring save...!\n");
	}
	else if (changed == true) {
		printf("Changes were made! Saving file...!\n");
		printf("Opening Save file...\n");
		filem = fopen("soal10.txt", "w");
		for (int i = 0; i < kounter; i++) {
			printf("Saving File %d: [Title] %s, [Airtime] %d.%d, [Seat]%d\n", i, Films[i].Movie, Films[i].Airtime[0], Films[i].Airtime[1], Films[i].Seats);
			fprintf(filem, "%s %d.%d %d\n", Films[i].Movie, Films[i].Airtime[0], Films[i].Airtime[1], Films[i].Seats);
		};
		fclose(filem);
	}

	//getchar();
	return 0;
}