package it.uniroma2.info.lmp;

public enum CdS {

    INFORMATICA("INF"),
    PSICOLOGIA("PSY");
    private String codice;
    private CdS(String codice){
        this.codice = codice;
    }
    public String getCodice(){
        return codice;
    }
}
