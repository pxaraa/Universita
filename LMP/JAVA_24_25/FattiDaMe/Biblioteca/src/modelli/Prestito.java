package modelli;

import java.time.LocalDate;

public class Prestito {
    private LocalDate dataInizio;
    private LocalDate dataPrevista;
    private LocalDate dataEffettiva;
    private String nomeUtente;
    private String cognomeUtente;
    private double costoAffitto;

    public Prestito(LocalDate dataInizio,
                    LocalDate dataPrevista,
                    LocalDate dataEffettiva,
                    String nomeUtente,
                    String cognomeUtente,
                    double costoAffitto) {
        this.dataInizio = dataInizio;
        this.dataPrevista = dataPrevista;
        this.dataEffettiva = dataEffettiva;
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.costoAffitto = costoAffitto;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public LocalDate getDataEffettiva() {
        return dataEffettiva;
    }

    public void setDataEffettiva(LocalDate dataEffettiva) {
        this.dataEffettiva = dataEffettiva;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getCognomeUtente() {
        return cognomeUtente;
    }

    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

    public double getCostoAffitto() {
        return costoAffitto;
    }

    public void setCostoAffitto(double costoAffitto) {
        this.costoAffitto = costoAffitto;
    }

    /**
     * Restituisce la durata del prestito in giorni
     * (dataEffettiva - dataInizio).
     */
    public long getDurataPrestitoInGiorni() {
        if (dataEffettiva != null && dataInizio != null) {
            return java.time.temporal.ChronoUnit.DAYS.between(dataInizio, dataEffettiva);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Prestito [dataInizio=" + dataInizio +
                ", dataPrevista=" + dataPrevista +
                ", dataEffettiva=" + dataEffettiva +
                ", utente=" + nomeUtente + " " + cognomeUtente +
                ", costo=" + costoAffitto + "]";
    }
}
