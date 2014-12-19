package server.model;

import java.util.ArrayList;

/**
 * Created by Gökhan on 11/10/2014.
 */
public class MasterNode {

    long creationTime;
    long completedTime;
    ArrayList<Part> parts;

    public long getCompletedTime() {


        return findPartMaxTime();
    }



    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public void addPart(Part part) {
        if (parts == null)
            parts = new ArrayList<Part>();

        parts.add(part);
    }

    public long findPartMinimumTime(){
        if (parts==null)
            return -1;

        if (parts.size()<1)
            return  parts.get(0).getCreationTime();

        long first=parts.get(0).getCalculationTime();
        for (int i = 1; i <parts.size() ; i++) {
            if(parts.get(i).getCalculationTime()<first)
                first=parts.get(i).getCalculationTime();
        }

        return  first;
    }

    public long findPartMaxTime(){
        if (parts==null)
            return -1;

        if (parts.size()<1)
            return  parts.get(0).getClientReachTime();

        long first=parts.get(0).getClientReachTime();
        for (int i = 1; i <parts.size() ; i++) {
            if(parts.get(i).getClientReachTime()>first)
                first=parts.get(i).getClientReachTime();
        }

        return  first;
    }
}
