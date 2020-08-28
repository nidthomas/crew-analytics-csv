package com.crewanalytics.csv.upload.model;

import javax.persistence.*;

@Entity
@Table
public class Crew {

    @EmbeddedId
    private CrewId Id;

    @Column
    private String Base_Station;

    @Column
    private String Fleet;

    @Column
    private int Planned_home_standby;

    @Column
    private int Planned_airport_standby;

    @Column
    private int Utilized_home_standby;

    @Column
    private int Utilized_airport_standby;

    @Column
    private int Departures;

    public Crew() {
    }

    public Crew(CrewId id,String base_Station, String fleet, int planned_home_standby, int planned_airport_standby,
                int utilized_home_standby, int utilized_airport_standby, int departures) {
        Id = id;
        Base_Station = base_Station;
        Fleet = fleet;
        Planned_home_standby = planned_home_standby;
        Planned_airport_standby = planned_airport_standby;
        Utilized_home_standby = utilized_home_standby;
        Utilized_airport_standby = utilized_airport_standby;
        Departures = departures;
    }


    public CrewId getId() {
        return Id;
    }

    public void setId(CrewId id) {
        Id = id;
    }

    public String getBase_Station() {
        return Base_Station;
    }

    public void setBase_Station(String base_Station) {
        Base_Station = base_Station;
    }

    public String getFleet() {
        return Fleet;
    }

    public void setFleet(String fleet) {
        Fleet = fleet;
    }

    public int getPlanned_home_standby() {
        return Planned_home_standby;
    }

    public void setPlanned_home_standby(int planned_home_standby) {
        Planned_home_standby = planned_home_standby;
    }

    public int getPlanned_airport_standby() {
        return Planned_airport_standby;
    }

    public void setPlanned_airport_standby(int planned_airport_standby) {
        Planned_airport_standby = planned_airport_standby;
    }

    public int getUtilized_home_standby() {
        return Utilized_home_standby;
    }

    public void setUtilized_home_standby(int utilized_home_standby) {
        Utilized_home_standby = utilized_home_standby;
    }

    public int getUtilized_airport_standby() {
        return Utilized_airport_standby;
    }

    public void setUtilized_airport_standby(int utilized_airport_standby) {
        Utilized_airport_standby = utilized_airport_standby;
    }

    public int getDepartures() {
        return Departures;
    }

    public void setDepartures(int departures) {
        Departures = departures;
    }
}
