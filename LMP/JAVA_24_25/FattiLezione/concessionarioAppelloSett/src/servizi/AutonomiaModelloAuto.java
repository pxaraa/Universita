package servizi;

public class AutonomiaModelloAuto {
    private String marca;
    private String nome;
    private int cilindrata;
    private int litriSerbatoio;
    private int kmPerLitro;

    public AutonomiaModelloAuto(String marca, String nome, int cilindrata, int litriSerbatoio, int kmPerLitro) {
        this.marca = marca;
        this.nome = nome;
        this.cilindrata = cilindrata;
        this.litriSerbatoio = litriSerbatoio;
        this.kmPerLitro = kmPerLitro;
    }

    public int calcolaAutonomia() {
        return litriSerbatoio * kmPerLitro;
    }

    public AutonomiaModelloAuto clonaConCilindrataDiversa(int nuovaCilindrata) {
        return new AutonomiaModelloAuto(this.marca, this.nome, nuovaCilindrata, this.litriSerbatoio, this.kmPerLitro);
    }




    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getCapacitaSerbatoio() {
        return litriSerbatoio;
    }

    public void setCapacitaSerbatoio(int capacitaSerbatoio) {
        this.litriSerbatoio = capacitaSerbatoio;
    }

    public int getKmPerLitro() {
        return kmPerLitro;
    }

    public void setKmPerLitro(int kmPerLitro) {
        this.kmPerLitro = kmPerLitro;
    }

    @Override
    public String toString() {
        return "ModelloAuto{" +
                "marca='" + marca + '\'' +
                ", nome='" + nome + '\'' +
                ", cilindrata=" + cilindrata +
                ", litriSerbatoio=" + litriSerbatoio +
                ", kmPerLitro=" + kmPerLitro +
                '}';
    }
}
