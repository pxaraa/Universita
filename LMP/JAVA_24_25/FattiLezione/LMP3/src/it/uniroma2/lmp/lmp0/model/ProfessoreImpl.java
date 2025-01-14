/**
 *
 */
package it.uniroma2.lmp.lmp0.model;

/**
 *
 */
public class ProfessoreImpl extends PersonaImpl implements Professore {

    String cattedra;

    /**
     * @param nome
     * @param cognome
     * @param codiceFiscale
     * @param cattedra
     */
    public ProfessoreImpl(String nome, String cognome, String codiceFiscale, String cattedra) {
        super(nome, cognome, codiceFiscale);
        this.cattedra = cattedra; //e' cio' che fa setCattedra
    }

    @Override
    public String getCattedra() {
        return this.cattedra; //e' meglio this.cattedra
    }

    @Override
    public void setCattedra(String cattedra) {
        this.cattedra = cattedra;
    }

}
