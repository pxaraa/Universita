public class GestioneEsami {
    private double coefficienteOOP;
    private double coefficienteLogicaFunzionale;
    private int maxBonus;

    public GestioneEsami(double coefficienteOOP, double coefficienteLogicaFunzionale, int maxBonus) {
        this.coefficienteOOP = coefficienteOOP;
        this.coefficienteLogicaFunzionale = coefficienteLogicaFunzionale;
        this.maxBonus = maxBonus;
    }

    public double calcolaVotoFinale(int votoOOP, int votoLogica, int votoFunzionale, int votoOraleOOP, int votoOraleLogicaFunzionale, int bonus) {
        double votoParzialeOOP = ((votoOOP + votoOraleOOP)* coefficienteOOP) / 2;
        double votoParzialeLogicaFunzionale =( (votoLogica + votoFunzionale) / 2  + votoOraleLogicaFunzionale )* coefficienteLogicaFunzionale;
        double votoFinale = (votoParzialeOOP + votoParzialeLogicaFunzionale) / 2 + Math.min(bonus, maxBonus);
        if(votoFinale > 30) {
            votoFinale = 30 ;
            return votoFinale;
        }else {
            return votoFinale;
        }
    }
}