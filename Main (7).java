import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        String[] parole = new String[100];
        String parola;
        int ripetizioni=0;
        String sostituto;
        String ripetuta;
        String max = "";
        String min = "";
        int conta = 0;
        int opzione;
        int posizione = 0;

        do {
            System.out.println("scegli  opzione:");
            System.out.println("1-Aggiunta di un nome;");
            System.out.println("2-Cancellazione del singolo nome;");
            System.out.println("3-Ricerca sequenziale di un nome;");
            System.out.println("4-Visualizza nomi ripetuti con numero ripetizioni");
            System.out.println("5-Modifica di un nome;");
            System.out.println("6-Visualizzazione di tutti i nomi presenti;");
            System.out.println("7-Ricerca del nome più lungo e più corto;");
            System.out.println("8-Cancellazione di tutte le occorrenze di un nome;");
            System.out.println("0-esci");
            opzione = t.nextInt();
            t.nextLine();
            switch (opzione) {
                case 1:
                    conta++;
                    System.out.println("dammi un parola da aggiungere");
                    parola = t.nextLine();
                    IsAggiunta(parole, parola, conta);

                    break;
                case 2:
                    System.out.println("dammi parola da cancellare");
                    parola = t.nextLine();
                    IsCancellazzione(parole, parola, conta);
                    conta--;

                    break;
                case 3:
                    System.out.println("dammi parola da cercare");
                    parola = t.nextLine();
                    System.out.println("la parola si trova in posizione " + IsRicerca(parole, parola, conta, posizione));
                    break;
                case 4:
                    ripetuta=parole[0];
                    for(int i=0; i<conta; i++){
                        System.out.println("la parola " + parole[i] + " é ripetuta " + IsRipetizioni(parole, ripetuta, ripetizioni, conta) + " volte");
                        ripetuta=parole[i];
                    }

                    break;
                case 5:
                    System.out.println("quale parola vuoi sostituire?");
                    parola = t.nextLine();
                    System.out.println("con cosa la vuoi sostituire?");
                    sostituto = t.nextLine();
                    IsSostituzione(parole, parola, conta);
                    break;
                case 6:
                    System.out.println(IsVisualizza(parole, conta));

                    break;
                case 7:
                    System.out.println("il nome piu lungo è " + IsMax(parole, max, conta));
                    System.out.println("il nome piu corto è " + IsMin(parole, min, conta));
                    break;
                case 8:


                    break;
                case 0:


                    System.out.println("grazie per aver usate il servizio cortinovis, alla prossima!");
                    break;
                default:
                    System.out.println("metti una tra le opzioni richieste");

            }
        } while (opzione != 0);
    }

    private static String[] IsAggiunta(String[] nome, String parola, int conta) {
        nome[conta - 1] = parola;
        return nome;
    }

    private static String[] IsCancellazzione(String[] nome, String parola, int conta) {
        for (int i = 0; i < conta; i++) {
            if (nome[i].equals(parola)) {
                for (int p = i + 1; p < conta; p++) {
                    nome[p - 1] = nome[p];
                }
            }
        }
        return nome;
    }

    private static int IsRicerca(String[] nome, String parola, int conta, int posizione) {
        for (int i = 0; i < conta; i++) {
            if (nome[i].equals(parola)) ;
            posizione = i;
        }
        return posizione;
    }
    private static int IsRipetizioni (String[] nome, String ripetuta, int ripetizioni, int conta) {
        ripetizioni = 0;
        for (int i = 0; i < conta; i++) {
            if (nome[i].equals(ripetuta)) {
                ripetizioni = ripetizioni + 1;
            }
        }return ripetizioni;
    }

    private static void IsSostituzione(String[] nome, String parola, int conta) {
        for (int i = 0; i < conta; i++) {
            if (nome[i].equals(parola)) ;
            nome[i] = parola;
        }
    }

    private static String[] IsVisualizza(String[] nome, int conta) {
        for (int i = 0; i < conta; i++) {
            System.out.println(nome[i]);
        }
        return nome;
    }

    private static String IsMax(String[] nome, String max, int conta){
        max = nome[0];
        for (int i = 1; i < conta; i++) {
            if (max.length() < nome[i].length()) {
                max = nome[i];
            }

        }
        return max;
    }
    private static String IsMin(String[] nome, String min, int conta){
        min = nome[0];
        for (int i = 1; i < conta; i++) {
            if (min.length() > nome[i].length()) {
                min = nome[i];
            }

        }
        return min;
    }
}
