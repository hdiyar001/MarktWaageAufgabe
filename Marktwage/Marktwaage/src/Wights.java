
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Daten und Methoden fuer das Aufgaben-Modell. Klasse und Methoden fuer die
 * Loesung des Aufgabenproblems.
 *
 * @author RBBK-21ItaO2_Teamname
 */
public class Wights {

    ArrayList<Integer> lighterW;
    ArrayList<Integer> wights;

    public Wights(String[] lines) {
        this.wights = new ArrayList<>();
        String wightsS = "";
        for (String line : lines) {
            wightsS += line + "\n";
        }

        Scanner input = new Scanner(wightsS.substring(0, wightsS.length()));

        while (input.hasNext()) {
            String thisLine = input.nextLine();
            int wight = 0, quantity = 0;
            for (int i = 0; i < thisLine.length(); i++) {
                if (thisLine.charAt(i) == ' ') {
                    wight = Integer.parseInt(thisLine.substring(0, i));
                    quantity = Integer.parseInt(thisLine.substring(i + 1, thisLine.length()));
                }
                if (wight != 0 && quantity != 0) {
                    for (int j = 0; j < quantity; j++) {
                        wights.add(wight);
                    }
                    wight = 0;
                    quantity = 0;
                }
            }
        }

    }

    ArrayList<Integer> GetlightW(int rechteSeite) {
        lighterW = new ArrayList<>();
        for (int i = 0; i < wights.size(); i++) {
            if (wights.get(i) < rechteSeite) {
                lighterW.add(wights.get(i));
            } else {
                lighterW.add(wights.get(i));

                return lighterW;
            }
        }

        return lighterW;
    }

}
