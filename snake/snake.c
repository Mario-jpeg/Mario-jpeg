#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <time.h>
#include <conio.h>



int riemp = 20;
int i = 0;
int j = 0;
int ri, rj;
int lung=-1;




struct posizione{
	int x;
	int y;
};





void generazione_mappa(char [riemp][riemp]);

void stampa(struct posizione [100],char [riemp] [riemp]);

void up(struct posizione [100],char [riemp][riemp]);

void down(struct posizione [100], char [riemp][riemp]);

void left(struct posizione [100],char [riemp][riemp]);

void right(struct posizione [100], char [riemp][riemp]);

void shift_x(struct posizione [100]);

void shift_y(struct posizione [100]);

void mela(char [riemp][riemp]);

int main(){
    srand(time(NULL));
	struct posizione snake[lung];
	char mappa[riemp][riemp];
	char tasto;
	snake[lung].x=0;
	snake[lung].y=0;
	
    int fps,confronto=-1;
    
    time_t now = time(NULL);
    struct tm *local = localtime(&now);

    fps=local->tm_sec;
    
    printf("AAAAAAAAAAAHHHHHHHHHH   %i   HHHHHHHHHHH",fps);
	
	
	
	
	
	
	generazione_mappa(mappa);
	    //snake
    mappa[0][0]='1';
    
    //mela
	mela(mappa);
	
	stampa(snake,mappa);
	printf("\n\n%i %i\n\n",ri,rj);
	
	int o = 0;
	
	do{
		time_t now = time(NULL);
    	struct tm *local = localtime(&now);

		if(_kbhit()){
			tasto = _getch();
			system("cls");
			stampa(snake,mappa);
			switch(tasto){
/*				case 'w':
					up(snake,mappa);
					break;
				
				case 'a':
					left(snake,mappa);
					break;
					
				case 's':
					down(snake,mappa);
					break;
					
				case 'd':
					right(snake,mappa);
					break;*/
			}

			system("cls");
			stampa(snake,mappa);		
		}else if(confronto!=fps){
			system("cls");
			stampa(snake,mappa);
			confronto = fps;
		}
    	fps=local->tm_sec;
    	
	}while(tasto!='0');
	
	
	return 0;	
}

void generazione_mappa(char vettore [riemp][riemp]){
	for(i=0;i<riemp;i++){
		for(j=0;j<riemp;j++){
			vettore [i] [j] = '.';
		}
	}	
}

void stampa(struct posizione snake[lung], char vettore [riemp] [riemp]){
	for(i=0;i<riemp;i++){
		for(j=0;j<riemp;j++){
			printf("%c ",vettore [j] [i]);
		}
		printf("\n");
	}	
	
}

void up(struct posizione snake[100], char mappa[riemp][riemp]){
	
	mappa[snake[0].x][snake[0].y]='.';

	//metti uno shit verso sinistra di tutti i valori
	if(lung>0){
		shift_y(snake);
	}


	if( (snake[lung].y-1)<0){
		snake[lung].y=riemp-1;
	}else{
		snake[lung].y--;
	}
	mappa[snake[lung].x][snake[lung].y]='1';
}

void down(struct posizione snake[100], char mappa[riemp][riemp]){

	mappa[snake[0].x][snake[0].y]='.';

	if(lung>0){
		shift_y(snake);
	}	
	
	if( (snake[lung].y + 1) >= riemp){
		snake[lung].y = 0;
	}else{
		snake[lung].y++;
	}
	mappa[snake[lung].x][snake[lung].y]='1';
}

void left(struct posizione snake[100], char mappa[riemp][riemp]){

	mappa[snake[0].x][snake[0].y]='.';
	
	if(lung>0){
		shift_x(snake);
	}
	
	if( (snake[lung].x-1)<0){
		snake[lung].x=riemp-1;
	}else{
		snake[lung].x--;
	}
	mappa[snake[lung].x][snake[lung].y]='1';
}

void right(struct posizione snake[100], char mappa[riemp][riemp]){

	mappa[snake[0].x][snake[0].y]='.';
	
	if(lung>0){
		shift_x(snake);
	}
	
	if( (snake[lung].x + 1) >= riemp){
		snake[lung].x = 0;
	}else{
		snake[lung].x++;
	}
	mappa[snake[lung].x][snake[lung].y]='1';
}

void shift_x(struct posizione snake[100]){
	for(i = 0; i < lung; i++){
		snake[i].x = snake[i+1].x;
	}
}

void shift_y(struct posizione snake[100]){
	for(i = 0; i < lung; i++){
		snake[i].y = snake[i+1].y;
	}
}

void mela(char mappa[riemp][riemp]){
	
	lung++;
    do{
		ri=(rand()% riemp);
    	rj=(rand()% riemp);	
	}while( (ri == 0) && (rj == 0) );
	
    mappa [ri] [rj] = '8';	
}






