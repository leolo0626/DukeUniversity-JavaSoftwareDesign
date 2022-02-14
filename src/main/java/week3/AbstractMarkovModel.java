package week3;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;

    public AbstractMarkovModel() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        myText = s.trim();
    }

    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows (String key) {
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
