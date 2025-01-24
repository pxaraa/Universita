package modelli;

public class Macchina {
    private String nome;
    private String marca;
    private String modello;
    private int cilindrata;
    private double capacitàSerbatoio;
    private double consumoLitro;
    private Disponibilità disponibilità;

    public Macchina(String nome, String marca, String modello, double capacitàSerbatoio, int cilindrata, double consumoLitro, Disponibilità disponibilità) {
        this.nome = nome;
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.capacitàSerbatoio = capacitàSerbatoio;
        this.consumoLitro = consumoLitro;
        this.disponibilità = disponibilità;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public double getCapacitàSerbatoio() {
        return capacitàSerbatoio;
    }

    public double getConsumoLitro() {
        return consumoLitro;
    }

    public Disponibilità getDisponibilità() {
        return disponibilità;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public void setDisponibilita(Disponibilità disponibilità) {
        this.disponibilità = disponibilità;
    }
}
