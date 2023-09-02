#include<stdio.h>
#include<string.h>

int main(){
	int N;
	int tc, ts, tv;
	
	do{
	scanf("%d", &N);
	}while(N<1||N>100000);
	int c;
	c=0;
	for(int i=0; i<N; i++){
		
		do{
		scanf("%d %d %d", &tc, &ts, &tv);
		fflush(stdin);
		}while(tv<tc||
				(tc<0)||(tc>300)||
				(ts<0)||(ts>300)||
				(tv<0)||(tv>300));
		
		if(ts>tv){
			c++;
		}
	}
	
	printf("%d", c);
	
	
	
	return 0;
}
