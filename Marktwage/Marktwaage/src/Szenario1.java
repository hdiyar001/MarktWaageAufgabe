
import java.util.ArrayList;
import java.util.Collections;

public class Szenario1 {

    int linkeSeite = 0;
    String sum = "";

    public int DifferenceCalculator(int linkeSeite, int rechteSeite, ArrayList<Integer> Gewichte) {
        Collections.sort(Gewichte, Collections.reverseOrder());
        int temp1 = 0, temp2 = 0;

        for (int i = 0; i < Gewichte.size(); i++) {
            for (int j = i; j < Gewichte.size(); j++) {

                if (temp1 + Gewichte.get(j) <= rechteSeite) {
                    temp1 += Gewichte.get(j);

                    if (temp2 == 0 || temp1 > temp2) {
                        sum += Gewichte.get(j) + " ";
                        temp2 = temp1;
                        linkeSeite = temp2;
                        if (linkeSeite == rechteSeite) {

                            break;
                        }
                    }
                }
                if (j == Gewichte.size() - 1) {
                    temp1 = 0;
                }
            }
        }
        int differenz = Math.abs(linkeSeite - rechteSeite);
        this.linkeSeite = linkeSeite;
        return differenz;
    }
}
