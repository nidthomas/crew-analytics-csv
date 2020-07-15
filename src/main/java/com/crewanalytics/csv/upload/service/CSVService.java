package com.crewanalytics.csv.upload.service;

import com.crewanalytics.csv.upload.helper.CSVHelper;
import com.crewanalytics.csv.upload.model.Crew;
import com.crewanalytics.csv.upload.repository.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    CrewRepository repository;

    public void save(MultipartFile file){

        try {
            List<Crew> crews = CSVHelper.csvToCrewDb(file.getInputStream());
            repository.saveAll(crews);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store csv data: " + e.getMessage());
        }
    }

    public List<Crew> getAllCrew(){
        return repository.findAll();
    }
}
