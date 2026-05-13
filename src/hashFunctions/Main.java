package hashFunctions;

import hashFunctions.MurmurHash.MurmurHash;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hash Rechner" + "\n" +
                "\n" +
                "Gib deinen ersten Key ein und wähle ein geeignetes Hash Verfahren!");
        do {
            System.out.println("Key: ");
            String key = sc.nextLine();
            System.out.println(" ");
            System.out.println("Hash Verfahren: \n" +
                    "[1] MurmurHash \n" +
                    "[2] ");
            int hash = switch (sc.nextInt()) {
                case 1 -> MurmurHash.hash(key);

                default -> throw new IllegalStateException("Unexpected value: " + sc.nextInt());
            };
            System.out.println("Der berechnete Wert lautet: " + hash);
            System.out.println(" ");
            System.out.println("Noch eine Rechnung? \n" +
                    "[y] Ja \n" +
                    "[n] Nein");
        } while (sc.nextLine().equals("y"));
    }
}