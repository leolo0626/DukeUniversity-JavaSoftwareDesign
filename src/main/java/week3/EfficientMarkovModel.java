package week3;

import java.util.ArrayList;
import java.util.HashMap;

public class EfficientMarkovModel extends AbstractMarkovModel{
    int N ;
    HashMap<String, ArrayList<String>> follows ;
    public EfficientMarkovModel(int numOfChar) {
        N = numOfChar;
        follows = new HashMap<String, ArrayList<String>>();
    }

    public String toString() {
        return "Efficient Markov Model of order : " + N;
    }

    public void buildMap() {

    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-N);
        String key = myText.substring(index, index+N);
        sb.append(key);

        for(int k=0; k < numChars-N; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) break ;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }

        return sb.toString();
    }
}
