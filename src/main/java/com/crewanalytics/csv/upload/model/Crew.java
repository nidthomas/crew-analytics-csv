package com.crewanalytics.csv.upload.model;

import javax.persistence.*;

@Entity
@Table
public class Crew {

//    @GeneratedValue
//    @Column
//    private int Id;

    @Column
    private float Crew_Utilized;

    @Column
    private int Planned;

    @Column
    private String Crew_Rank;

    @Id
    @Column
    private String Base_Station;

    public Crew() {
    }

    public Crew(float crew_utilized, int planned, String rank, String base_Station) {
        this.Crew_Utilized = crew_utilized;
        this.Planned = planned;
        this.Crew_Rank = rank;
        this.Base_Station = base_Station;
    }

    public float getCrew_utilized() {
        return Crew_Utilized;
    }

    public void setCrew_utilized(float crew_utilized) {
        Crew_Utilized = crew_utilized;
    }

    public int getPlanned() {
        return Planned;
    }

    public void setPlanned(int planned) {
        Planned = planned;
    }

    public String getRank() {
        return Crew_Rank;
    }

    public void setRank(String rank) {
        Crew_Rank = rank;
    }

    public String getBase_Station() {
        return Base_Station;
    }

    public void setBase_Station(String base_Station) {
        Base_Station = base_Station;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "Crew_utilized=" + Crew_Utilized +
                ", Planned=" + Planned +
                ", Rank='" + Crew_Rank + '\'' +
                ", Base_Station='" + Base_Station + '\'' +
                '}';
    }
}
