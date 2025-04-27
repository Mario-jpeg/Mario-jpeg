package org.example;

public class brano {
    private String nome;
    private String artista;
    private String genere;
    private int durata;
    private int durataMin;
    private int durataSec;
    private int posizione;
    private int posizioneOriginale;


    //aggiunge le informazioni della traccia
    public brano(String nome, String artista, String genere, int durata, int posizione){
        this.nome = nome;
        this.artista = artista;
        this.genere = genere;
        this.durata = durata;
        this.posizione = posizione;
        this.posizioneOriginale = posizione;
        if(durata>=60){
           this.durataMin = durata / 60;
           this.durataSec = durata - (this.durataMin * 60);
        }else this.durataSec = durata;
    }




    //funzioni di stampa

    public String getTrace(){
        return "\nPosizione: " + posizione + "\ntitolo: " + nome + "\nArtista: " + artista + "\nGenere: " + genere + "\nDurata: " + time();
    }

    public String getName(){return nome;}

    public String time(){
        return  ( (durataMin / 10 ) < 1? "0" : "") + durataMin + ":" + ( (durataSec / 10 ) < 1? "0" : "") + durataSec + "\n";
    }

    public int getPosition(){return posizione;}
    public int getOriginalPosition(){return posizioneOriginale;}

    public void decressposition(){posizione--;}
    public void decreaseOriginalPosition(){posizioneOriginale--;}

}
