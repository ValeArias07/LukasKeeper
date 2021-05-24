package model;

import java.util.Date;

public class Fee {

    private int id;
    private double value;
    private Date date;
    private int idSavingPlan;
    private int idDebts;

    public Fee(){}

    public Fee(double value, Date date, int idSavingPlan, int idDebts) {
        this.value = value;
        this.date = date;
        this.idSavingPlan = idSavingPlan;
        this.idDebts = idDebts;
    }

    public Fee(int id, double value, Date date, int idSavingPlan, int idDebts) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.idSavingPlan = idSavingPlan;
        this.idDebts = idDebts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public int getIdSavingPlan() {
        return idSavingPlan;
    }

    public int getIdDebts() {
        return idDebts;
    }
}
