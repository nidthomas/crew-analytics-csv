package com.crewanalytics.csv.upload.controller;

import com.crewanalytics.csv.upload.helper.CSVHelper;
import com.crewanalytics.csv.upload.message.ResponseMessage;
import com.crewanalytics.csv.upload.model.Crew;
import com.crewanalytics.csv.upload.service.CSVService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//@CrossOrigin("http://localhost:8081")
@Controller
@RequestMapping("/api/csv")
public class CSVController {

    Logger log = LoggerFactory.getLogger(CSVController.class);

    @Autowired
    CSVService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadCSV(@RequestParam("file")MultipartFile file){

        String message = "";

        if(CSVHelper.isCsvFormat(file)){
            try {
                fileService.save(file);
                message = "Uploaded the file successfully:" + file.getOriginalFilename();
                log.info(message);
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            }catch (Exception e){
                message = "Couldn't upload file:" + file.getOriginalFilename();
                log.warn(message);
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }

        }
        message = "Please upload a CSV file!!";
        log.warn(message);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/crews")
    public ResponseEntity<List<Crew>> getAllCrew(){

        try {
            List<Crew> crews = fileService.getAllCrew();

            if (crews.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(crews, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/reset")
    public ResponseEntity<ResponseMessage> deleteAll(){

        try {
                if(!fileService.getAllCrew().isEmpty()) {
                    fileService.deleteAll();
                    log.warn("Deleted all entries");
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Deleted all entries!!"));
                }
                log.warn("Nothing to delete");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage("No entries to delete!!"));
            } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
