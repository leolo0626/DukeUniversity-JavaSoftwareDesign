package week3;

public interface IMarkovModel {
    public void setTraining(String text);

    public String getRandomText(int size);

    public void setRandom(int seed);

}
