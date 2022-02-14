import java.util.ArrayList;

public class SortingAlgorithm {
//    public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
//        QuakeEntry min = quakes.get(0);
//        for (QuakeEntry q : quakes) {
//            if (q.getMagnitude() < min.getMagnitude()) {
//                min = q;
//            }
//        }
//    }

    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from ;
        for (int i = from + 1; i < quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
//
//    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
//        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
//        while (!in.isEmpty()) {
//            QuakeEntry minElement = getSmallestMagnitude(in);
//            in.remove(minElement);
//            out.add(minElement);
//        }
//        return out;
//    }

    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
        for (int i =0 ; i < in.size(); i++ ) {
            int minIdx = getSmallestMagnitude(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);
        }
        return in;
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
        sortByMagnitude(list);
        for(QuakeEntry qe:list) {
            System.out.println(qe);
        }
    }

    public static void main (String[] args) {
        SortingAlgorithm sort = new SortingAlgorithm();
        sort.testSort();
    }

}
