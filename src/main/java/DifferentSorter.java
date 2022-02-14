import java.util.ArrayList;
import java.util.Collections;

public class DifferentSorter {

    public void sortByTitleAndDepth(ArrayList<QuakeEntry> list) {
        Collections.sort(list, new TitleComparator());
    }

    public void sortByLastWordInTitleThenByMagnitude(ArrayList<QuakeEntry> list) {
        Collections.sort(list, new TitleLastAndMagnitudeComparator());
    }

    public void sortByMagnitudeThenByDepth(ArrayList<QuakeEntry> list) {
        Collections.sort(list);
    }

    public static void main (String [] args) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\Leo Lo\\Desktop\\program\\DukeUniversity-JavaSoftwareDesign" +
                "\\src\\main\\java\\data\\earthQuakeDataWeekDec6sample2.atom";

        ArrayList<QuakeEntry> list = parser.read(source);

        DifferentSorter sorter = new DifferentSorter();
        sorter.sortByLastWordInTitleThenByMagnitude (list);

        System.out.println(list.get(500));
    }
}
