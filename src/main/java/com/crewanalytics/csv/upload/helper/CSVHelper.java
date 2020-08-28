package com.crewanalytics.csv.upload.helper;

import com.crewanalytics.csv.upload.model.Crew;
import com.crewanalytics.csv.upload.model.CrewId;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CSVHelper {

    public static String TYPE = "text/csv";
    static  String[] HEADERS = {"Crew_utilized","Planned"};

    public static boolean isCsvFormat(MultipartFile file){

        if(!TYPE.equals(file.getContentType()))
           return false;

        return true;
    }

    public static List<Crew> csvToCrewDb(InputStream is){

        try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
                ) {

            List<Crew> crews = new ArrayList<Crew>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords){
//                System.out.println("csvToCrewDb");
//                System.out.println(csvRecords);

                // TODO change with params
                Crew crew = new Crew(
                        new CrewId(new Date(csvRecord.get(0)),csvRecord.get("RANK")),
                        csvRecord.get("BASE"),
                        csvRecord.get("FLEET"),
                        Integer.parseInt(csvRecord.get("Planned HSBstandby")),
                        Integer.parseInt(csvRecord.get("Planned ASBY standby")),
                        Integer.parseInt(csvRecord.get("UTILISEDSTNDBYHSBYCNT")),
                        Integer.parseInt(csvRecord.get("UTILISEDSTNDBYASBYCNT")),
                        Integer.parseInt(csvRecord.get("DEPARTURES"))
                );
                crews.add(crew);
            }
            return crews;

        }  catch (IOException e) {
            throw new RuntimeException("Failed to parse CSV file: " + e.getMessage());
        }

    }
}
