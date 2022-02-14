package week3;

import edu.duke.FileResource;
import week3.IMarkovModel;
import week3.MarkovModel;

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size) {
        System.out.println(markov);
        String st = text;
        st = st.replace('\n', ' ');
        markov.setRandom(365);
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String outputText= markov.getRandomText(size);
            printOut(outputText);
        }
    }

    public void runMarkov(int seed) {
        FileResource fr = new FileResource("/Users/leolo/Desktop/Java/JavaSoftwareDesign/src/main/java/" +
                "week3/data/confucius.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');

        MarkovModel markov = new MarkovModel(8);
        markov.setRandom(seed);
        runModel(markov, st, 500);


    }
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    public static void main (String [] args) {
        MarkovRunnerWithInterface mr = new MarkovRunnerWithInterface();
        mr.runMarkov(8);
    }
}
