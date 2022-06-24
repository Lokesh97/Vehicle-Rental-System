package main.java.com.vrs.entity;

import java.util.Date;

public class Booking {

    private String id;
    private Date start;
    private Date end;

    public Booking(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
