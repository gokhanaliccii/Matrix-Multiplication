package listener;

/**
 * Created by Gökhan on 11/19/2014.
 */
public interface MatrixResponseListener {
    public void onServiceReplied(int [][]result);
    public void onServiceReplied(String result);
    public void onPassedTime(long time);
}