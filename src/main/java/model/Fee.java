package model;

import java.sql.Date;

public class Fee {

    private int id;
    private double value;
    private Date type;

    public Fee(){}

    public Fee(int id, double value, Date type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }


}
