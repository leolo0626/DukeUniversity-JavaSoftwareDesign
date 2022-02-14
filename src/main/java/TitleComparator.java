import java.util.Comparator;

public class TitleComparator implements Comparator<QuakeEntry> {
    @Override
    public int compare(QuakeEntry o1, QuakeEntry o2) {
        int compareResult = o1.getInfo().compareTo(o2.getInfo());
        if (compareResult < 0) {
            compareResult = -1;
        } else if  (compareResult > 0) {
            compareResult = 1;
        } else if (compareResult == 0) {
            compareResult = Double.compare(o1.getDepth(), o2.getDepth());
        }
        return compareResult;
    }
}
