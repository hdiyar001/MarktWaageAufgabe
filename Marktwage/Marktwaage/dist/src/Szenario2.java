
import java.util.ArrayList;
import java.util.Collections;

public class Szenario2 {

    int linkeSeite = 0, rechteSeite = 0;
    String links = "", rechts = "";

    int DifferenceCalculator(int linkeSeite, int rechteSeite, ArrayList<Integer> Gewichte) {

        int differenz = 0;
        Collections.sort(Gewichte, Collections.reverseOrder());
        int temp = rechteSeite;
        for (int i = 0; i < Gewichte.size(); i++) {
            for (int j = i; j < Gewichte.size(); j++) {

                if (Gewichte.get(j) > temp && temp > linkeSeite) {
                    linkeSeite = Gewichte.get(j);
                    links += Gewichte.get(j) + " ";
                } else if (Gewichte.get(j) + linkeSeite < temp || Gewichte.get(j) + linkeSeite >= temp) {
                    linkeSeite += Gewichte.get(j);
                    links += Gewichte.get(j) + " ";
                }

                if (linkeSeite > temp) {
                    for (int k = j; k < Gewichte.size(); k++) {
                        if (temp + Gewichte.get(k) <= linkeSeite) {
                            temp += Gewichte.get(k);
                            rechts += Gewichte.get(k) + " ";

                            Gewichte.remove(k);

                        }

                        if (temp == linkeSeite) {
                            rechteSeite = temp;
                            differenz = Math.abs(linkeSeite - rechteSeite);
                            this.linkeSeite = linkeSeite;
                            this.rechteSeite = rechteSeite;
                            return differenz;
                        }
                    }
                }
            }
            if (temp != linkeSeite) {
                temp = rechteSeite;
                linkeSeite = 0;
            }
        }
        differenz = Math.abs(linkeSeite - rechteSeite);
        this.linkeSeite = linkeSeite;
        this.rechteSeite = rechteSeite;
        return differenz;
    }
}
