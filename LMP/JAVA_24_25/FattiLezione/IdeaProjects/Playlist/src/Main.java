import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int x;
        x=45;
        x=100;
        double temperatura;

        temperatura=34.23;

        int y=34;// inizzializzazione, no numeri con la virgola
        int etaPersona = 25; //low camel case
    /*Tipi di dati
    b0olean
    byte=da - 128 a 127| 1 byte     PRIMITIVE invece non si puo
    short=da -32768 a 32767|2 bytes
    int=-2 miliardi a a 2 miliardi|4 bytes
    long=-9 qintilioni a 9 quintilioni| 8 bytes
    float=6-7 cifre decimali|4 bytes
    double=15 cifre decimali|8 bytes
    char=va scritto con le apici| 2 bytes
    Sring= scritto con doppie apici REFERENCE(iniziale grande) possiamo usare tanti metodi
     */
        System.out.println(x);

        Scanner scanner  = new Scanner(System.in);

        System.out.println("quale è il tuo nome?");
        String nome = scanner.nextLine();

        System.out.println(nome);

        //Array

        int[]  numeri = new int[3];

        numeri[0]= 10;
        numeri[1]= 20;
        numeri[2]= 30;

        System.out.println(numeri[1]);

    }
}



