package week3;

import java.util.ArrayList;
import java.util.Random;

public class MarkovOne extends AbstractMarkovModel{

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        sb.append(myText.charAt(index));
        String key = myText.substring(index, index+1);
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

}
