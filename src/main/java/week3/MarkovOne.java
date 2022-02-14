package week3;

import java.util.ArrayList;
import java.util.Random;

public class MarkovOne {
    private String myText;
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length());
        sb.append(myText.charAt(index));
        String key = sb.substring(0);
        for(int k=1; k < numChars-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) break ;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }

        return sb.toString();
    }

    public ArrayList<String> getFollows(String key) {
        int i = myText.indexOf(key, 0);;
        int keyLength = key.length();
        ArrayList<String> follows = new ArrayList<String>();
        while (i < myText.length()) {
            String nextChar = myText.substring(i+keyLength, i+keyLength+1);
            follows.add(nextChar);
            i = myText.indexOf(key, i+keyLength);
            if (i == -1 ) {
                break;
            }
            if (i+keyLength >= myText.length()) {
                break;
            }
        }
        return follows;
    }

}
