package com.crewanalytics.csv.upload.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class CrewId implements Serializable {

    @Column
    private Date Date;

    @Column
    private String Crew_Rank;

    public CrewId() {

    }

    public CrewId(Date date, String crew_Rank) {
        Date = date;
        Crew_Rank = crew_Rank;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public String getCrew_Rank() {
        return Crew_Rank;
    }

    public void setCrew_Rank(String crew_Rank) {
        Crew_Rank = crew_Rank;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof CrewId)) return false;
        CrewId that = (CrewId) o;
        return Objects.equals(getCrew_Rank(), that.getCrew_Rank()) &&
                Objects.equals(getDate(), that.getDate());

    }

    @Override
    public int hashCode() {

        return Objects.hash(getCrew_Rank(), getDate());
    }
}
