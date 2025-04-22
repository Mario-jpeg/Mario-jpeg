#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <time.h>
#include <conio.h>


int riemp = 10;
int i=0,j=0;
int nmax=100;

struct posizione{
	int x;
	int y;	
};


void generazione_mappa(char [riemp][riemp]);

void stampa(char [riemp] [riemp]);

void prova(struct posizione [], char [riemp][riemp]);

void down(struct posizione [], char [riemp][riemp]);

void quadrato(struct posizione [nmax]);

int main(int argc, char *argv[]) {
	
	struct posizione blocco[nmax];
	
	
    srand(time(NULL));
	char mappa[riemp][riemp];
	char tasto;

    int fps,confronto=-1;
    
    time_t now = time(NULL);
    struct tm *local = localtime(&now);

    fps=local->tm_sec;
    
	
	
	
	
	
	
	generazione_mappa(mappa);
	    //snake
    
	
	quadrato(blocco);
	prova(blocco, mappa);
	stampa(mappa);

	
	do{
		time_t now = time(NULL);
    	struct tm *local = localtime(&now);

			
		if(_kbhit()){
			tasto = _getch();
			system("cls");
			stampa(mappa);
			
			

			switch (tasto){
/*				case 'w':
					up(mappa);
					break;
				
				case 'a':
					left(mappa);
					break; */
					
				case 's':
					down(blocco,mappa);
					break;
				/*	
				case 'd':
					right(mappa);
					break;*/
			}


			system("cls");
			stampa(mappa);		
		}else if(confronto!=fps){
			system("cls");
			stampa(mappa);
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

void stampa(char vettore [riemp] [riemp]){
	for(i=0;i<riemp;i++){
		for(j=0;j<riemp;j++){
			printf("%c ",vettore [j] [i]);
		}
		printf("\n");
	}	
	
}

void down(struct posizione blocco[], char mappa[riemp][riemp]){
	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '.';
	}
	
	for( i = 0; i < 4; i++){
		blocco[i].y += 1;

	}
	
	prova(blocco, mappa);
}

void quadrato(struct posizione blocco[]){
	
	blocco[0].x = 4;	 
	blocco[0].y = 0;
		 
	blocco[1].x = 5;	 
	blocco[1].y = 0;
	
	blocco[2].x = 4;	 
	blocco[2].y = 1;
		 
	blocco[3].x = 5;	 
	blocco[3].y = 1;
	
}

void prova(struct posizione blocco[], char mappa[riemp][riemp]){
	
	for(i = 0; i < 4; i++){
		mappa[blocco[i].x][blocco[i].y] = '#';
	}
	
	
	
	
}







































