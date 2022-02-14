import java.util.ArrayList;
import java.util.Collections;

public class DistanceSorter {
    public static void main (String [] args) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\Leo Lo\\Desktop\\program\\DukeUniversity-JavaSoftwareDesign" +
                "\\src\\main\\java\\data\\nov20quakedata.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));

        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
}
