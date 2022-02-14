import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    @Override
    public int compare(QuakeEntry o1, QuakeEntry o2) {
        String title1 = o1.getInfo();
        String title2 = o2.getInfo();
        String lastWord1 = title1.substring(title1.lastIndexOf(" ")+1);
        String lastWord2 = title2.substring(title2.lastIndexOf(" ")+1);
        int compareResult = lastWord1.compareTo(lastWord2);
        if (compareResult < 0) {
            compareResult = -1;
        } else if  (compareResult > 0) {
            compareResult = 1;
        } else if (compareResult == 0) {
            compareResult = Double.compare(o1.getMagnitude(), o2.getMagnitude());
        }
        return compareResult;
    }
}
