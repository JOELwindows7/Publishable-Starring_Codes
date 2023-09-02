#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<ctype.h>

int main(){
	int select, x, y, turne=1, gamestat=0;
	char nama[22], table[3][3], turns = 'X', winner='?';
	bool gameon = false, tfilled[3][3], progress = false;

	system("cls");

	for(int i=0;i<14;i++){
		printf("\n");
	};

	do{
	printf("Input your name[1..20]: ");
	scanf("%[^\n]", nama); fflush(stdin);
	} while(strlen(nama) > 20);

	do{
		gamestat = 0;
		system("cls");

		for(int t=0; t<3; t++){
			for(int u=0; u<3; u++){
				table[t][u] = '-';
			};
		};

		for(int tf=0; tf<3; tf++){
			for(int uf=0; uf<3; uf++){
				tfilled[tf][uf] = false;
			};
		};

		for(int i=0;i<25;i++){
				printf("\n");
		};

		printf("Welcome to XOTG, %s\n", nama);
		printf("1. Change your name\n");
		printf("2. Play game\n");
		printf("3. Exit\n");
		printf("Please input your choice: ");

		scanf("%d", &select); fflush(stdin);

		switch(select){
		case 1:
			do{
				printf("Input your name[1..20]: ");
				getchar();
				scanf("%[^\n]", nama);
				fflush(stdin);
				getchar();
			} while(strlen(nama) > 20);

			break;
		case 2:
			do{
				if (gamestat == 0) {
					gameon = true;
				};

				system("cls");

				if (gamestat == 0) {
					for (int i = 0; i < 25; i++) {
						printf("\n");
					};
				}
				else if (gamestat != 0) {
					for (int i = 0; i < 5; i++) {
						printf("\n");
					};
				};

				printf("XOTG Table\n");
				printf("__________\n");
				printf("\n");
				printf("    1 2 3\n\n");
				for(int t=0; t<3; t++){
					printf("  %d ", t+1);
					for(int u=0; u<3; u++){
						printf("%c ", table[t][u]);
					};
					printf("\n");
					if(t < 3){
						printf("\n");
					};
				};

				if (gamestat != 0) {
					for (int e = 0; e < 3; e++) {
						printf("\n");
					};
					printf("Game Over...\n\n");
					if (gamestat == 1) {
						printf("Congratulations, players \"%c\" win!!\n", winner);
						gameon = false;
						//getchar();
					}
					else if (gamestat == 2) {
						printf("Draw!\n");
						gameon = false;
						//getchar();
					};
					for (int f = 0; f < 7; f++) {
						printf("\n");
					};
					printf("Press ENTER to continue...");
					getchar();
				}
				else if (gamestat == 0) {
					printf("__________\n");
					printf("\n");
					printf("Player %c Turns\n", turns);

					do {
						progress = true;
						printf("Please input X Coordinate[1..3]: ");
						do {
							scanf("%d", &x); fflush(stdin);
						} while (x > 3);

						printf("Please input Y Coordinate[1..3]: ");
						do {
							scanf("%d", &y); fflush(stdin);
						} while (y > 3);

						if (tfilled[y - 1][x - 1] == false) {
							table[y - 1][x - 1] = turns;
							tfilled[y - 1][x - 1] = true;
							/*if(turns = 'X'){
								turns = 'O';
							}
							else if(turns= 'O'){
								turns = 'X';
							}*/


							if		((((table[0][0] != '-'		&& table[0][1] != '-')		&& table[0][2] != '-')		|| ((table[1][0] != '-'		&& table[1][1] != '-')		&& table[1][2] != '-')		|| ((table[2][0] != '-'		&& table[2][1] != '-')		&& table[2][2] != '-'))		|| /*(ornar)*/ (((table[0][0] != '-'	&& table[1][0] != '-')		&& table[2][0] != '-')		|| ((table[0][1] != '-'		&& table[1][1] != '-')		&& table[2][1] != '-')		|| ((table[0][2] != '-'		&& table[1][2] != '-')		&& table[2][2] != '-'))		|| /*(Ordara)*/ (((table[0][0] != '-'	&& table[1][1] != '-')		&& table[2][2] != '-')		|| ((table[0][2] != '-'		&& table[1][1] != '-')		&& table[2][0] != '-'))) {
								if	((((table[0][0] == turns	&& table[0][1] == turns)	&& table[0][2] == turns)	|| ((table[1][0] == turns	&& table[1][1] == turns)	&& table[1][2] == turns)	|| ((table[2][0] == turns	&& table[2][1] == turns)	&& table[2][2] == turns))	|| /*(ornar)*/ (((table[0][0] == turns	&& table[1][0] == turns)	&& table[2][0] == turns)	|| ((table[0][1] == turns	&& table[1][1] == turns)	&& table[2][1] == turns)	|| ((table[0][2] == turns	&& table[1][2] == turns)	&& table[2][2] == turns))	|| /*(Ordara)*/ (((table[0][0] == turns && table[1][1] == turns)	&& table[2][2] == turns)	|| ((table[0][2] == turns	&& table[1][1] == turns)	&& table[2][0] == turns))) {
									/*printf("winner");
									getchar();*/
									gamestat = 1;
									winner = turns;
								}
								else if (((tfilled[0][0] == true && tfilled[0][1] == true) && tfilled[0][2] == true) && /*(andar)*/ ((tfilled[1][0] == true && tfilled[1][1] == true) && tfilled[1][2] == true) && /*(andar)*/ ((tfilled[2][0] == true && tfilled[2][1] == true) && tfilled[2][2] == true)) {
									//printf("draw");
									gamestat = 2;
								};
							};

							switch (turne) {
							case 1:
								turns = 'O';
								turne = 2;
								break;
							case 2:
								turns = 'X';
								turne = 1;
								break;
							}
							progress = false;
							//printf("posint\n");

						}
						else if (tfilled[y - 1][x - 1] == true) {
							printf("\nPositions has been filled..\n\n");
						};
					} while (progress);
				};
				
			} while(gameon == true);

			//printf("cleanup");

			getchar();
			break;
		case 3:
			//exit
			break;
		};
	} while(select != 3);

	return 0;
}