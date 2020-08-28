package com.crewanalytics.csv.upload.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class MLModel {

    @EmbeddedId
    private CrewId Id;

    @Column
    private int predicted_HSBY;

    @Column
    private int predicted_ASBY;

    public MLModel() {
    }

    public MLModel(CrewId id, int predicted_HSBY, int predicted_ASBY) {
        Id = id;
        this.predicted_HSBY = predicted_HSBY;
        this.predicted_ASBY = predicted_ASBY;
    }

    public int getPredicted_HSBY() {
        return predicted_HSBY;
    }

    public void setPredicted_HSBY(int predicted_HSBY) {
        this.predicted_HSBY = predicted_HSBY;
    }

    public int getPredicted_ASBY() {
        return predicted_ASBY;
    }

    public void setPredicted_ASBY(int predicted_ASBY) {
        this.predicted_ASBY = predicted_ASBY;
    }
}
