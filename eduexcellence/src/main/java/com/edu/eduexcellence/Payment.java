package com.edu.eduexcellence;

import jakarta.persistence.*;

@Entity
public class Payment {


    //@GeneratedValue(strategy = GenerationType.AUTO)/
    @Id
    private String id;

    private String studentName;
    private String Amount;

    private String ManualDate;


    public String getManualDate() {
        return ManualDate;
    }

    public void setManualDate(String manualDate) {
        ManualDate = manualDate;
    }

    public Payment(String paid) {
        Paid = paid;
    }

    private String UPI;

    public String getPaid() {
        return Paid;
    }

    public void setPaid(String paid) {
        Paid = paid;
    }

    private String Paid;


   public String getId() {
        return id;
    }

   public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getUPI() {
        return UPI;
    }

    public void setUPI(String UPI) {
        this.UPI = UPI;
    }

    public Payment(String id, String studentName, String Amount, String UPI, String ManualDate) {
        this.id = id;
        this.studentName = studentName;
        this.Amount = Amount;
        this.UPI = UPI;
        this.ManualDate = ManualDate;
    }

    public Payment(String studentName, String Amount, String UPI, String ManualDate) {
        this.studentName = studentName;
        this.Amount = Amount;
        this.UPI = UPI;
        this.ManualDate = ManualDate;
    }

    public Payment() {

        super();
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", Amount='" + Amount + '\'' +
                ", ManualDate='" + ManualDate + '\'' +
                ", UPI='" + UPI + '\'' +
                ", Paid='" + Paid + '\'' +
                '}';
    }
}
