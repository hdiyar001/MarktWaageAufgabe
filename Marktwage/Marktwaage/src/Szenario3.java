
import java.util.ArrayList;
import java.util.Collections;

public class Szenario3 {

    int linkeSeite = 0;
    String sum = "";

    public int DifferenceCalculator(int linkeSeite, int rechteSeite, ArrayList<Integer> Gewichte) {
        Collections.sort(Gewichte, Collections.reverseOrder());
        int temp = 0, temp2 = 0;

        for (int i = 0; i < Gewichte.size(); i++) {
            for (int j = i; j < Gewichte.size(); j++) {
                if (Gewichte.get(j) > rechteSeite) {
                    linkeSeite = Gewichte.get(j);
                    j = Gewichte.size();

                } else if (temp + Gewichte.get(j) <= rechteSeite) {
                    temp += Gewichte.get(j);
                } else if (temp + Gewichte.get(j) > rechteSeite) {
                    temp += Gewichte.get(j);
                    if (temp2 == 0 || temp < temp2) {
                        temp2 = temp;
                        linkeSeite = temp2;
                        sum += Gewichte.get(j) + " ";
                        temp -= Gewichte.get(j);
                    } else if (temp >= temp2) {
                        temp -= Gewichte.get(j);
                    }
                }
                if (j == Gewichte.size()) {
                    temp = 0;
                }
            }
        }
        if (sum == "") {
            sum += linkeSeite + " ";
        }
        int differenz = Math.abs(linkeSeite - rechteSeite);
        this.linkeSeite = linkeSeite;
        return differenz;
    }

}
