package com.bhardwaj.Assignment.service;

import com.bhardwaj.Assignment.model.InputDetail;
import com.bhardwaj.Assignment.model.OutputDetail;
import com.bhardwaj.Assignment.repository.InputDetailsRepository;
import com.bhardwaj.Assignment.repository.OutputDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class StringModificationService {

    @Autowired
    InputDetailsRepository inputDetailsRepository;

    @Autowired
    OutputDetailsRepository outputDetailsRepository;

    public void removeSimilarAdjacentCharacters(){

        List<InputDetail> inputDetails = inputDetailsRepository.findAll();

        List<OutputDetail> outputDetails = new ArrayList<>();

        for(InputDetail inputDetail : inputDetails){
            String input = inputDetail.getInputString();
            StringBuilder output = new StringBuilder();
            Integer count=0;
            for (char c : input.toCharArray()) {
                int size = output.length();
                if (size > 0 && output.charAt(size - 1) == c) {
                    count++;
                    output.deleteCharAt(size - 1);
                } else {
                    output.append(c);
                }
            }
            OutputDetail outputDetail = new OutputDetail(input,output.toString(),count,new Timestamp(System.currentTimeMillis()));
            outputDetails.add(outputDetail);
        }

        outputDetailsRepository.saveAll(outputDetails);

    }

}
