import java.util.ArrayList;
import java.util.Collections;

public class AssignmentOne {
    private ArrayList<QuakeEntry> list ;
    public AssignmentOne(String source) {
        list = readFile(source);
    }
    private ArrayList<QuakeEntry> readFile(String source) {
        EarthQuakeParser parser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("Found " + list.size() +" quakes in the file");
        return list ;
    }

    public ArrayList<QuakeEntry> quakesOfDepth(Double minDepth, Double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : list) {
            Double depth = qe.getDepth() ;
            if (depth > minDepth && depth < maxDepth) {
                answer.add(qe) ;
            }
        }
        System.out.println("Found " + answer.size() +" quakes in the quakeOfDepth");
        return answer ;
    }

    public ArrayList<QuakeEntry> quakesByPhrase(String where, String phrase){
        /*This method checks the quake info for a given phrase, and if it is at the start, end, or any,
         * depending on the parameter, adds the quake to the Arraylist "answer" and returns it.
         */
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : list){
            if(where.equals("start")){
                if (qe.getInfo().startsWith(phrase)){
                    answer.add(qe);
                }
            }
            if(where.equals("end")){
                if (qe.getInfo().endsWith(phrase)){
                    answer.add(qe);
                }
            }
            if(where.equals("any")){
                if (qe.getInfo().contains(phrase)){
                    answer.add(qe);
                }
            }
        }
        System.out.println("Found " + answer.size() +" quakes in the quakesByPhrase");
        return answer;
    }

    private int findLargestQuakes (ArrayList<QuakeEntry> data) {
        Double maxMag = Double.NEGATIVE_INFINITY ;
        int maxIndex = -1 ;
        for (QuakeEntry qe: data) {
            Double mag = qe.getMagnitude() ;
            if (mag >  maxMag) {
                maxIndex = data.indexOf(qe) ;
                maxMag = mag ;
            }
        }

        return maxIndex ;
    }

    public QuakeEntry findNthLargestQuakes(int nth){
            ArrayList<QuakeEntry> newList = new ArrayList<QuakeEntry>(list) ;
        QuakeEntry qe = null ;
        for (int i = 1 ; i <= nth ; i++) {
            int index = findLargestQuakes(newList) ;
            qe = newList.get(index);
            newList.remove(index) ;

        }
        return qe;
    }

    public static void main(String[] args) {
        AssignmentOne assignment = new  AssignmentOne("data/nov20quakedata.atom");
        assignment.quakesOfDepth(-10000.0, -8000.0);
        assignment.quakesByPhrase("start","Explosion");
        assignment.quakesByPhrase("end","California");
        assignment.quakesByPhrase("any","Creek");
        System.out.println(assignment.findNthLargestQuakes(5));
        System.out.println(assignment.findNthLargestQuakes(3));

    }
}
