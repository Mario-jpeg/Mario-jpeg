package org.example;

public class playlist {
    private String nomePlaylist;
    private int nTraces = 0;
    private int nLastTrace = -1;

    brano[] trace = new brano[100];

    public int getPosition(){
        return nTraces;
    }

    public void setName(String nome){
        this.nomePlaylist = nome;
    }

    public String getName(){
        return nomePlaylist + "\n";
    }

    public int getNTraces(){
        return nTraces;
    }

    public int getNLastTrace(){
        return nLastTrace;
    }

    public void traceAdded(){
        nTraces++;
        nLastTrace++;
    }

    public void print(){
        System.out.print("\nNome playlist: " + nomePlaylist + "\n");
        for(int i = 0; i < nTraces; i++){
            System.out.print(trace[i].getTrace());
        }
    }

    public Boolean deletTrace(int index){
        Boolean deleted = false;
        for(int i = 0; i < nTraces; i++){
            if(trace[i].getPosition() == index){
                nTraces--;
                nLastTrace--;
                for(int j = 0; j < nTraces; j++)
                    if(trace[j].getOriginalPosition() > trace[i].getOriginalPosition())
                        trace[j].decreaseOriginalPosition();

                for(int j = i; j < nTraces; j++){
                    brano temp = trace[j];
                    trace[j] = trace[j+1];
                    trace[j+1] = temp;
                    trace[j].decressposition();
                }
                trace[nLastTrace + 1] = null;
                return deleted;
            }
        }
        return deleted;
    }

    public void traceCreOrderer(){
        boolean ohno = false;
        do {
            if (ohno) ohno = false;
            for (int i = 0; i < nTraces - 1; i++) {
                int a = trace[i].getRawTime(), b = trace[i + 1].getRawTime();
                if (a > b) {
                    ohno = true;
                    brano temp = trace[i];
                    trace[i] = trace[i + 1];
                    trace[i + 1] = temp;
                }
            }
        }while(ohno);
    }

    public void traceDecOrderd(){
        boolean ohno = false;
        do {
            if (ohno) ohno = false;
            for (int i = 0; i < nTraces - 1; i++) {
                int a = trace[i].getRawTime(), b = trace[i + 1].getRawTime();
                if (a < b) {
                    ohno = true;
                    brano temp = trace[i];
                    trace[i] = trace[i + 1];
                    trace[i + 1] = temp;
                }
            }
        }while(ohno);
    }

    public void traceLastReorder(){
        boolean ohno = false;
        do {
            if (ohno) ohno = false;
            for (int i = 0; i < nTraces - 1; i++) {
                int a = trace[i].getPosition(), b = trace[i + 1].getPosition();
                if (a < b) {
                    ohno = true;
                    brano temp = trace[i];
                    trace[i] = trace[i + 1];
                    trace[i + 1] = temp;
                }
            }
        }while(ohno);
    }

    public void tracefirstReorder(){
        boolean ohno = false;
        do {
            if (ohno) ohno = false;
            for (int i = 0; i < nTraces - 1; i++) {
                int a = trace[i].getPosition(), b = trace[i + 1].getPosition();
                if (a > b) {
                    ohno = true;
                    brano temp = trace[i];
                    trace[i] = trace[i + 1];
                    trace[i + 1] = temp;
                }
            }
        }while(ohno);
    }

}










/*    private String nome;
    private String artista;
    private String genere;
    private int durata;
    private int durataMin;
    private int durataSec;
    private int posizione;*/