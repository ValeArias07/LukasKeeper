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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdSavingPlan() {
        return idSavingPlan;
    }

    public void setIdSavingPlan(int idSavingPlan) {
        this.idSavingPlan = idSavingPlan;
    }

    public int getIdDebts() {
        return idDebts;
    }

    public void setIdDebts(int idDebts) {
        this.idDebts = idDebts;
    }

}
