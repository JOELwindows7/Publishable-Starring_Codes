// C program to implement interpolation search
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

// If x is present in arr[0..n-1], then returns
// index of it, else returns -1.
int interpolationSearch(int arr[], int n, int x)
{
	// Find indexes of two corners
	int lo = 0, hi = (n - 1);

	// Since array is sorted, an element present
	// in array must be in range defined by corner
	while (lo <= hi && x >= arr[lo] && x <= arr[hi])
	{
		// Probing the position with keeping
		// uniform distribution in mind.
		int pos = lo + (((double)(hi - lo) /
			(arr[hi] - arr[lo]))*(x - arr[lo]));

		// Condition of target found
		if (arr[pos] == x)
			return pos;

		// If x is larger, x is in upper part
		if (arr[pos] < x)
			lo = pos + 1;

		// If x is smaller, x is in lower part
		else
			hi = pos - 1;
	}
	return -1;
}

// Driver Code
int main()
{
	// Array of items on which search will
	// be conducted.
	int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21, 22, 23,
		24, 33, 35, 42, 47 };
	int arr2[10];
	int *dynamic_arr;
	int *Refference, *Supply;
	int D, Y;
	int Size_D, Size_Y;
	int n = sizeof(arr) / sizeof(arr[0]);
	printf("n size: %d\n", n);
	int k;
	int l = sizeof(arr2) / sizeof(arr2[0]);
	printf("l size: %d\n", l);

	dynamic_arr = (int*) malloc(10 * sizeof(int));
	//k = sizeof(dynamic_arr) / sizeof(dynamic_arr[0]);
	k = 10;
	printf("k size: %d\n", k);

	/*dynamic_arr[0] = 10;
	dynamic_arr[1] = 12;
	dynamic_arr[2] = 13;
	dynamic_arr[3] = 16;
	dynamic_arr[4] = 18;
	dynamic_arr[5] = 19;*/

	for (int i = 0; i < 10; i++) {
		printf("Enter Value %d for Dynamic Array: ", i);
		scanf("%d", &dynamic_arr[i]); fflush(stdin);
	}

	for (int i = 0; i < 10; i++) {
		printf("Enter Value %d for Static Array: ", i);
		scanf("%d", &arr2[i]); fflush(stdin);
	}

	int x = 18; // Element to be searched
	int index = interpolationSearch(arr, n, x);

	printf("(arr) ");
	// If element was found
	if (index != -1)
		printf("Element found at index %d", index);
	else
		printf("Element not found.");

	printf("\n");

	index = interpolationSearch(dynamic_arr, k, x);

	printf("(dynamic_arr) ");
	if (index != -1)
		printf("Element found at index %d", index);
	else
		printf("Element not found.");

	free(dynamic_arr);

	printf("\n");

	index = interpolationSearch(arr2, l, x);

	printf("(arr2) ");
	if (index != -1)
		printf("Element found at index %d", index);
	else
		printf("Element not found.");

	printf("\n");

	printf("(N) How many Refferences we have: ");
	scanf("%d", &D); fflush(stdin);

	printf("(N) How many Supply available: ");
	scanf("%d", &Y); fflush(stdin);

	Refference = (int*)malloc(D * sizeof(int));
	Supply = (int*)malloc(Y * sizeof(int));

	Size_D = D;
	Size_Y = Y;

	for (int i = 0; i < D; i++) {
		printf("Insert Refference %d: ", i);
		scanf("%d", &Refference[i]); fflush(stdin);
	}

	for (int i = 0; i < Y; i++) {
		printf("Insert Supply %d: ", i);
		scanf("%d", &Supply[i]); fflush(stdin);
	}

	for (int i = 0; i < Y; i++) {
		index = interpolationSearch(Refference, Size_D, Supply[i]);

		printf("(Supply %d) ", i);
		if (index != -1)
			printf("Element found at index %d", index);
		else
			printf("Element not found.");

		printf("\n");
	}

	getchar();
	getchar();
	return 0;
}