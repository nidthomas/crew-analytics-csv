package com.crewanalytics.csv.upload.repository;

import com.crewanalytics.csv.upload.model.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew,Integer> {
}
