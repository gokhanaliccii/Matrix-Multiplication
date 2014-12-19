package server.model;

/**
 * Created by Gökhan on 11/10/2014.
 */
public class Part {

    private long creationTime;
    private long serverReachTime;
    private long serverLeftTime;
    private long calculationTime;
    private long clientReachTime;

    public long getCalculationTime() {
        return clientReachTime - creationTime;
    }

    public long getClientReachTime() {
        return clientReachTime;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Oluşum zamanı" + creationTime + "\n");
        sb.append("Servera ulaştıgı zaman" + serverReachTime + "\n");
        sb.append("Serverdan ayrıldıgı zamanı" + serverLeftTime + "\n");
        sb.append("Clienta ulaştıgı zaman" + clientReachTime + "\n");
        sb.append("Hesaplanma Süresi:" + getCalculationTime() + "\n");

        return sb.toString();
    }
}
