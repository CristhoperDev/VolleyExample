package crithoper.vrammdev.com.volleyexample;

/**
 * Created by Administrador on 25/03/2018.
 */

public class Tremor {
    private String place;
    private String datetime;
    private String magnitude;
    private String evaluation;
    private String report;
    private String date;
    private String time;
    private double latitude;
    private double longitude;
    private String profundity;

    public Tremor() {
    }

    public Tremor(String place, String datetime, String magnitude, String evaluation, String report, String date, String time, double latitude, double longitude, String profundity) {
        this.place = place;
        this.datetime = datetime;
        this.magnitude = magnitude;
        this.evaluation = evaluation;
        this.report = report;
        this.date = date;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.profundity = profundity;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getProfundity() {
        return profundity;
    }

    public void setProfundity(String profundity) {
        this.profundity = profundity;
    }
}
