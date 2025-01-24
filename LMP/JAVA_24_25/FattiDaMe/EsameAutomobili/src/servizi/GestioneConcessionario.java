package servizi;
import modelli.Macchina;
import java.util.HashMap;
import modelli.Disponibilità;
import modelli.Allestimento;
import modelli.PersonaAzienda;

public class GestioneConcessionario {
    private HashMap<Macchina, Disponibilità> magazzinoMacchine = new HashMap<>();

    public void aggiungiMacchinaInMagazzino(String nome, String marca, String modello, double capacitàSerbatoio, int cilindrata, double consumoLitro, Disponibilità disponibilità) {
        magazzinoMacchine.put(new Macchina(nome, marca, modello, capacitàSerbatoio, cilindrata, consumoLitro, disponibilità), disponibilità);
    }

    public void aggiungiAllestimentoInMagazzino(String nome, String marca, String modello, String nomeAllestimento, int cilindrata) {
        for (Macchina m : magazzinoMacchine.keySet()) {
            if (m.getNome().equals(nome) && m.getMarca().equals(marca) && m.getModello().equals(modello)) {
                Allestimento allestimento = new Allestimento(nome, marca, modello, m.getCapacitàSerbatoio(), cilindrata, m.getConsumoLitro(), nomeAllestimento, Disponibilità.IN_MAGAZZINO);
                allestimento.setCilindrata(cilindrata);
                magazzinoMacchine.put(allestimento, Disponibilità.IN_MAGAZZINO);

            } else {
                System.out.println("Macchina non presente in magazzino");
            }
        }
    }

    public void calcolaAutonomia(String nome, String marca, String modello) {
        for (Macchina m : magazzinoMacchine.keySet()) {
            if (m.getNome().equals(nome) && m.getMarca().equals(marca) && m.getModello().equals(modello)) {
                double serbatoio = m.getCapacitàSerbatoio();
                double kmLitro = m.getConsumoLitro();
                double autonomia = serbatoio * kmLitro;
                System.out.println("La macchina " + nome + " ha autonomia con il pieno: " + autonomia + "km");

            } else {
                System.out.println("Macchina non presente in magazzino, quindi non è possibile ricavare l' autonomia");
            }
        }
    }

    public void recuperaDisponibiltà(String nome, String marca, String modello, String nomeAllestimento, int cilindrata) {
        for (Macchina m : magazzinoMacchine.keySet()) {
            if ((m.getNome().equals(nome) && m.getMarca().equals(marca) && m.getModello().equals(modello))
                    || (m.getNome().equals(nome) && m.getMarca().equals(marca) && m.getModello().equals(modello) && m.getModello().equals(cilindrata))) {
                System.out.println("La macchina si trova in: " + magazzinoMacchine.get(m));
            }
            break;
        }
    }

    public void vendiMacchina(String nome, String marca, String modello, String nomeAllestimento, int cilindrata, PersonaAzienda personaAzienda) {
        {
            boolean found = false;
            for (Macchina m : magazzinoMacchine.keySet()) {
                if ((m.getNome().equals(nome) && m.getMarca().equals(marca) && m.getModello().equals(modello))
                        || (m.getNome().equals(nome) && m.getMarca().equals(marca) && m.getModello().equals(modello) && m.getModello().equals(cilindrata))) {
                    m.setDisponibilita(Disponibilità.VENDUTA);
                    System.out.println("Macchina venduta a: " + personaAzienda.getNome() + " " + personaAzienda.getCognome());
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Macchina non presente in magazzino");
            }
        }


    }
}