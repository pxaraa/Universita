package modelli;

public class Allestimento extends Macchina {
    private String nomeAllestimento;

    //costruttore
    public Allestimento(String nome, String marca, String modello, double capacitàSerbatoio, int cilindrata, double consumoLitro, String nomeAllestimento, Disponibilità disponibilità) {
        super(nome, marca, modello, capacitàSerbatoio, cilindrata, consumoLitro, disponibilità);
        this.nomeAllestimento = nomeAllestimento;

    }

    public void setNomeAllestimento(String nomeAllestimento) {
        this.nomeAllestimento = nomeAllestimento;
    }
    public void setCilindrata(int cilindrata) {
        super.setCilindrata(cilindrata);
    }
    public void setDisponibilità(Disponibilità disponibilità) {
        super.setDisponibilita(disponibilità);
    }
}
