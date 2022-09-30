package com.bmszcpatrik.bejegyzes;

import java.time.LocalDateTime;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
    }

    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public void setLikeok(int likeok) {
        this.likeok = likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public void setLetrejott(LocalDateTime letrejott) {
        this.letrejott = letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void setSzerkesztve(LocalDateTime szerkesztve) {
        this.szerkesztve = szerkesztve;
    }

    @Override
    public String toString() {
        if (this.getSzerkesztve().isAfter(this.getLetrejott())){
            return String.format("\n\n%s - %d - %s\nSzerkesztve: %s\n%s",this.getSzerzo(),this.getLikeok(),this.getLetrejott(),this.getSzerkesztve(),this.getTartalom());
        }else {
            return String.format("\n\n%s - %d - %s\nSzerkesztve: Nem szerkesztett\n%s",this.getSzerzo(),this.getLikeok(),this.getLetrejott(),this.getTartalom());
        }
    }

    public void Like(){
        likeok += 1;

    }


}
