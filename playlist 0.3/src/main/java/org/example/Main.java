package org.example;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        playlist [] lista = new playlist[100];

        int scelta;

        String TraceName;
        String TraceArtist;
        String TraceGenere;
        String playlistName;
        int TraceDuration;
        int nPlaylist = 0; //serve a sapere quante playlist esistono
        int playlistCorrente = -1; //tiene conto su quale playlist lavorare
        int nTracce; //tiene conto del numero di tracce presenti nella singola playlist corrente
        int nTracceDaAggiungere; //tiene conto di quante tracce vanno aggiunte
        int nTraccia; //tiene conto della posizione della traccia attuale
        int nEliminazione;//tiene conto della posizione della traccia da eliminare o della playlist

        System.out.print("Questo programma gestisce playlist di brani inseriti dall'utente.\n");

        do{
            System.out.print("\n///////////MENU//////////////\n0)esci dal programma\n1) creazione di una playlist.\n2) inserimento di un brano nella playlist.\n3) Inserimento di più brani nella playlist.\n");
            System.out.print("4) Eliminazione di una brano dalla playlist\n5) Eliminazione playlist\n6) Ordinamento playlist per durata crescente\n7) Ordina playlist per durata decrescente.\n");
            System.out.print("8) ordina per ultime aggiunto.\n9) ordina per primo aggiunto\n10) Stampa playlist\n11) Seleziona la playlist da visualizzare e da lavorare\n");
            scelta = sc.nextInt();
            sc.nextLine();

            switch(scelta){

                //uscita
                case 0:
                    System.out.print("Ok, ciao ciao.\n");
                    break;
                //creazione playlist
                case 1:
                    lista[nPlaylist] = new playlist();
                    nPlaylist++;
                    playlistCorrente++;
                    System.out.print("Dammi il nome della playlist.\n");
                    playlistName = sc.nextLine();
                    lista[playlistCorrente].setName(playlistName);
                    if(lista[playlistCorrente] == null){
                        System.out.println("Errore nella creazione!\n");
                    }else{
                        System.out.println("Playlist Creata!\n");
                    }
                    break;
                //inserimento brano
                case 2:
                    System.out.print("Dammi il titolo del brano: \n");
                    TraceName = sc.nextLine();
                    System.out.print("Dammi il nome dell'artista: \n");
                    TraceArtist = sc.nextLine();
                    System.out.print("Dammi il genere: \n");
                    TraceGenere = sc.nextLine();
                    System.out.print("Dammi quanto dura in secondi: \n");
                    TraceDuration = sc.nextInt();
                    sc.nextLine();

                    lista[playlistCorrente].traceAdded();
                    nTraccia = lista[playlistCorrente].getNLastTrace();
                    lista[playlistCorrente].trace[nTraccia] = new brano(TraceName, TraceArtist, TraceGenere, TraceDuration, lista[playlistCorrente].getPosition());
                    break;
                //inserimento di più brani
                case 3:
                    System.out.print("Quante brani vuoi aggiungere? \n");
                    nTracceDaAggiungere = sc.nextInt();
                    sc.nextLine();

                    for(int i = 0; i < nTracceDaAggiungere; i++){
                        System.out.print("\nTocca alla " + (i + 1) + "° canzone:\n");
                        System.out.print("Dammi il titolo del brano: \n");
                        TraceName = sc.nextLine();
                        System.out.print("Dammi il nome dell'artista: \n");
                        TraceArtist = sc.nextLine();
                        System.out.print("Dammi il genere: \n");
                        TraceGenere = sc.nextLine();
                        System.out.print("Dammi quanto dura in secondi: \n");
                        TraceDuration = sc.nextInt();
                        sc.nextLine();

                        lista[playlistCorrente].traceAdded();
                        nTraccia = lista[playlistCorrente].getNLastTrace();
                        lista[playlistCorrente].trace[nTraccia] = new brano(TraceName, TraceArtist, TraceGenere, TraceDuration, lista[playlistCorrente].getPosition());
                    }
                    break;
                //eliminazione di un brano
                case 4:
                    System.out.println("\n||||||||Ora ti stampo la playlist in questione: \n");
                    lista[playlistCorrente].print();
                    System.out.print("\n||||||||Segli quale canzone eliminare a seconda della posizione assegnata: \n");
                    nEliminazione = sc.nextInt();
                    sc.nextLine();

                    if(lista[playlistCorrente].deletTrace(nEliminazione))
                        System.out.println("L'eliminazione è andata a buon fine.\n");
                    else
                        System.out.println("L'eliminazione non è andata a buon fine.\nProva con un altro brano.\n");
                    break;
                //eliminazione playlist
                case 5:
                    System.out.println("Ora ti stampo i nomi delle playlist, tu indicami quale vuoi eliminare digitandomi la posizione.\n");
                    for(int i = 0; i < nPlaylist; i++)
                        System.out.println( "N: " + (i + 1) + "\nNome: " + lista[i].getName() + "Tracce: " + lista[i].getPosition() + "\n");
                    nEliminazione = sc.nextInt();
                    sc.nextLine();

                    for(int i = nEliminazione - 1; i < nPlaylist; i++){
                        playlist temp = lista[i];
                        lista[i] = lista[i + 1];
                        lista[i + 1] = temp;
                    }
                    nPlaylist--;
                    lista[nPlaylist] = null;

                    break;
                //ordinamento playlist per durata crescente
                case 6:
                    System.out.println("Ecco la playlist attuale: ");
                    lista[playlistCorrente].print();
                    lista[playlistCorrente].traceCreOrderer();
                    System.out.println("Ed ecco una volta ordinata: ");
                    lista[playlistCorrente].print();

                    break;
                //ordina per durata decrescente
                case 7:
                    System.out.println("Ecco la playlist attuale: ");
                    lista[playlistCorrente].print();
                    lista[playlistCorrente].traceDecOrderd();
                    System.out.println("Ed ecco una volta ordinata: ");
                    lista[playlistCorrente].print();
                    break;
                //ordina per ultimo aggiunto
                case 8:
                    System.out.println("Ecco la playlist attuale: ");
                    lista[playlistCorrente].print();
                    lista[playlistCorrente].traceLastReorder();
                    System.out.println("Ed ecco una volta ordinata: ");
                    lista[playlistCorrente].print();
                    break;
                //ordina per primo aggiunto
                case 9:
                    System.out.println("Ecco la playlist attuale: ");
                    lista[playlistCorrente].print();
                    lista[playlistCorrente].tracefirstReorder();
                    System.out.println("Ed ecco una volta ordinata: ");
                    lista[playlistCorrente].print();
                    break;
                //stampa playlist
                case 10:
                    if(lista[playlistCorrente] != null)
                        lista[playlistCorrente].print();
                    else
                        System.out.println("Playlist insesistente.\n");
                    break;
                //Selettore playlist
                case 11:
                    if(lista[playlistCorrente] != null){
                        System.out.println("Ora ti stampo le playlist create e poi digita la posizione della playlist da lavorare: \n");
                        for(int i = 0; i < nPlaylist; i++)
                            System.out.println( "N: " + (i + 1) + "\nNome: " + lista[i].getName() + "Tracce: " + lista[i].getPosition() + "\n");
                        playlistCorrente = (sc.nextInt() - 1);
                        sc.nextLine();
                        System.out.println("Ok allora ora lavoreremo su questa playlist : " + "\nNome: " + lista[playlistCorrente].getName() + "Tracce: " + lista[playlistCorrente].getPosition() + "\n");
                    }
                    else
                        System.out.println("Playlist insesistente.\n");
                    break;
                default:
                    System.out.print("||||||VALORE NON VALIDO, RITENTA||||||.\n");
            }
        }while(scelta != 0);
    }
}