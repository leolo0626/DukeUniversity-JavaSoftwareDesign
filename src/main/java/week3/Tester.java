package week3;

import edu.duke.FileResource;

public class Tester {
    public void testGetFollows () {
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining("this is a test yes this is a test.");
        System.out.println(markovOne.getFollows("e").toString());
    }

    public void testGetFollowsWithFile() {
        FileResource fr = new FileResource("/Users/leolo/Desktop/Java/JavaSoftwareDesign/src/main/java/" +
                "week3/data/melville.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(st);
        System.out.println(markovOne.getFollows("th").size());
    }

    public static void main(String[] args) {
        Tester tester = new Tester() ;
        tester.testGetFollowsWithFile();
    }
}
