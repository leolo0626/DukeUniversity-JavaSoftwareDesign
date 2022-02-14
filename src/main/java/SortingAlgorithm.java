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

//    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
//        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
//        while (!in.isEmpty()) {
//            QuakeEntry minElement = getSmallestMagnitude(in);
//            in.remove(minElement);
//            out.add(minElement);
//        }
//        return out;
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

    public int getLargestDepth(ArrayList<QuakeEntry> quakes, int from) {
        int maxIdx = from ;
        for (int i = from + 1; i < quakes.size(); i++) {
            if (quakes.get(i).getDepth() > quakes.get(maxIdx).getDepth()) {
                maxIdx = i ;
            }
        }
        return maxIdx;
    }

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

    public ArrayList<QuakeEntry> sortByLargestDepth(ArrayList<QuakeEntry> in) {
        for(int i = 0; i< in.size(); i++) {
            int maxIdx = getLargestDepth(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmax = in.get(maxIdx);
            in.set(i, qmax);
            in.set(maxIdx, qi);
        }
        return in;
    }

    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted) {
        for (int n = 0; n < numSorted; n++) {
            for (int i = 0; i < quakeData.size()-1; i++) {
                QuakeEntry curr = quakeData.get(i);
                QuakeEntry next = quakeData.get(i+1);
                if (curr.getMagnitude() > next.getMagnitude()) {
                    quakeData.set(i+1, curr);
                    quakeData.set(i, next);
                }
            }
        }
    }

    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> quakeData) {
        onePassBubbleSort(quakeData, quakeData.size()-1);
    }


    public boolean checkInSortedOrder (ArrayList<QuakeEntry> quakes) {
        boolean answer = true;

        for (int i=1; i < quakes.size(); i++) {
            QuakeEntry firstElem = quakes.get(i-1);
            QuakeEntry secondElem = quakes.get(i);

            if (firstElem.getMagnitude() > secondElem.getMagnitude()) {
                answer = false;
                break;
            }
        }
        return answer;
    }


    public void sortByMagnitudeWithCheck (ArrayList<QuakeEntry> in) {
        int numSorted = 0;
        for (int i=0; i < in.size(); i++) {
            int minIdx = getSmallestMagnitude(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);

            boolean checkIfSorted = checkInSortedOrder(in);
            numSorted += 1;

            if (checkIfSorted == true) {
                break;
            }
        }
        System.out.println("numbers of passes needed to sort the elements: " + numSorted);
    }

    public void sortByDepthWithCheck(ArrayList<QuakeEntry> in) {
        int numSorted = 0;
        for(int i = 0; i< in.size(); i++) {
            int maxIdx = getLargestDepth(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmax = in.get(maxIdx);
            in.set(i, qmax);
            in.set(maxIdx, qi);
            boolean checkIfSorted = checkInSortedOrder(in);
            numSorted += 1;

            if (checkIfSorted == true) {
                break;
            }
        }
        System.out.println("numbers of passes needed to sort the elements: " + numSorted);

    }

    public void sortByMagnitudeWithBubbleSortWithSort(ArrayList<QuakeEntry> quakeData, int numSorted) {
        int numOfPass = 0;
        for (int n = 0; n < numSorted; n++) {
            for (int i = 0; i < quakeData.size()-1; i++) {
                QuakeEntry curr = quakeData.get(i);
                QuakeEntry next = quakeData.get(i+1);
                if (curr.getMagnitude() > next.getMagnitude()) {
                    quakeData.set(i+1, curr);
                    quakeData.set(i, next);
                }
            }
            boolean checkIfSorted = checkInSortedOrder(quakeData);
            numOfPass += 1;

            if (checkIfSorted == true) {
                break;
            }
        }
        System.out.println("numbers of passes needed to sort the elements: " + numOfPass);
    }


    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\Leo Lo\\Desktop\\program\\DukeUniversity-JavaSoftwareDesign" +
                "\\src\\main\\java\\data\\earthQuakeDataDec6sample1.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
        sortByMagnitudeWithBubbleSortWithSort(list, list.size()-1);


    }

    public static void main (String[] args) {
        SortingAlgorithm sort = new SortingAlgorithm();
        sort.testSort();
    }

}
