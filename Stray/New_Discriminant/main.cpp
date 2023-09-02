#define _CRT_SECURE_NO_WARNINGSs
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>
#include<string>



int main(){
	double a, b, c, d, x1, x2;
	auto Reaction="";
	printf("Diskriminan {(d = b^2-4*a*c)}.\n");

	printf("Masukan a: ");
	scanf("%lf", &a);
	fflush(stdin);

	printf("Masukan b: ");
	scanf("%lf", &b);
	fflush(stdin);

	printf("Masukan c: ");
	scanf("%lf", &c);
	fflush(stdin);

	d=(b*b)-(4*a*c);

	printf("Diskriminan {(d = b^2-4*a*c)}: %.3f = (%.3f)*(%.3f) - 4 * %.3f * %.3f \n", d, b, b, a, c);
	printf("Realities: Real (d>0); Imaginer (d<=0)\n");

	x1 = (-b + pow(d, 0.5)) / (2 * a);
	x2 = (-b - pow(d, 0.5)) / (2 * a);

	printf("x1 {(-b + sqrt(d)) / (2 * a)}: %.3lf = (- %.3lf + sqrt(%.3lf))/(2 * %.3lf)\n", x1, b, d, a);
	printf("x2 {(-b + sqrt(d)) / (2 * a)}: %.3lf = (- %.3lf + sqrt(%.3lf))/(2 * %.3lf)\n", x2, b, d, a);

	if (d >= 0) {
		//printf("Real\n");
		Reaction = "Real (d>0)";
	}
	else if (d < 0) {
		//printf("Imaginer\n");
		Reaction = "Imaginer (d<=0)";
	};

	printf("Reality: %s", Reaction);

	getchar();
	getchar();
	return(0);
};

//use e.g. 1 3 2 to get real, use other else who knows which cause nan on x1 & x2 to get imaginer
//by JOELwindows7
//