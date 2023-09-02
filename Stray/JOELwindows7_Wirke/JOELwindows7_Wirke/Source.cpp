#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<string.h>
#include<math.h>
#include<time.h>
#include<iostream>
#include<Windows.h>
#include<algorithm>

using namespace std;

enum winter {snow, snowy} cold;

struct alamat {
	char nama_jalan[20];
	char no[5];

};

struct mahasiswa{
	int nilai;
	char nama[20];
	struct alamat addr;
	//char nim[11];
	//char alamat[50];
	//char telepon[12];
};

int main(){
	srand(time(NULL));

	int angka;
	struct mahasiswa mhs1;
	struct mahasiswa mhs[20];
	/*maha mhs1;
	maha mhs[20];*/

	mhs1.nilai = 100;
	strcpy(mhs1.nama, "Budi");

	mhs[0].nilai = 90;
	strcpy(mhs[0].nama, "Andi");
	strcpy(mhs[0].addr.nama_jalan, "Jalan Jeffry");
	strcpy(mhs[0].addr.no, "69");

	mhs[1] = mhs[0];

	printf("nama	: %s\n", mhs1.nama);
	printf("nilai	: %d\n", mhs1.nilai);

	printf("nama	: %s\n", mhs[0].nama);
	printf("nilai	: %d\n", mhs[0].nilai);
	printf("jalan	: %s\n", mhs[0].addr.nama_jalan);
	printf("no	: %s\n", mhs[0].addr.no);

	printf("nama	: %s\n", mhs[1].nama);
	printf("nilai	: %d\n", mhs[1].nilai);
	printf("jalan	: %s\n", mhs[1].addr.nama_jalan);
	printf("no	: %s\n", mhs[1].addr.no);

	printf("masukan nama mahasiswa : ");
	scanf("%[^\n]", mhs[2].nama); fflush(stdin);
	printf("masukan nilai mahasiswa : ");
	scanf("%d", &mhs[2].nilai); fflush(stdin);

	printf("nama	: %s\n", mhs[2].nama);
	printf("nilai	: %d\n", mhs[2].nilai);

	getchar();
	return 0;
}