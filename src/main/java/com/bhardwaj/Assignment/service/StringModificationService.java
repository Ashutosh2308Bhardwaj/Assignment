package com.bhardwaj.Assignment.service;

import com.bhardwaj.Assignment.model.InputDetail;
import com.bhardwaj.Assignment.model.OutputDetail;
import com.bhardwaj.Assignment.repository.InputDetailsRepository;
import com.bhardwaj.Assignment.repository.OutputDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class StringModificationService {

    private static final Logger log = LoggerFactory.getLogger(StringModificationService.class);

    @Autowired
    InputDetailsRepository inputDetailsRepository;

    @Autowired
    OutputDetailsRepository outputDetailsRepository;

    public void removeSimilarAdjacentCharacters(){

        List<InputDetail> inputDetails = inputDetailsRepository.findAll();   // Get all data in input_details table

        log.info("input details data {}",inputDetails);

        List<OutputDetail> outputDetails = new ArrayList<>();

        for(InputDetail inputDetail : inputDetails){

            String input = inputDetail.getInputString();    // Original String

            StringBuilder output = new StringBuilder();     // modifiedString stringBuilder

            Integer count=0;

            for (char c : input.toCharArray()) {
                int size = output.length();
                if (size > 0 && output.charAt(size - 1) == c) {    // Check if current character is same as last character of output string formed till now
                    count++;                                       // increment count
                    output.deleteCharAt(size - 1);                 // remove same adjacent characters
                } else {
                    output.append(c);
                }
            }

            OutputDetail outputDetail = new OutputDetail(input,output.toString(),count,new Timestamp(System.currentTimeMillis()));
            outputDetails.add(outputDetail);
        }

        log.info("output details data {}",outputDetails);

        outputDetailsRepository.saveAll(outputDetails);         // insert data in ashutosh_bhardwaj_java_output table

    }

}
