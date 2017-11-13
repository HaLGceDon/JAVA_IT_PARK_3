package com.company;

public class Broadcast extends Channel {
    private String broadcastName;
    private int timeToStart;
    private int timeToEnd;

    public Broadcast(String broadcastName, int timeToStart, int timeToEnd) {
        super();
        this.broadcastName = broadcastName;
        this.timeToStart = timeToStart;
        this.timeToEnd = timeToEnd;
    }

    public String getBroadcastName() {
        return broadcastName;
    }

    public int getTimeToStart() {
        return timeToStart;
    }

    public int getTimeToEnd() {
        return timeToEnd;
    }
}
