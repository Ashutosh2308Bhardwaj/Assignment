package com.bhardwaj.Assignment.controller;

import com.bhardwaj.Assignment.model.InputDetail;
import com.bhardwaj.Assignment.model.OutputDetail;
import com.bhardwaj.Assignment.repository.InputDetailsRepository;
import com.bhardwaj.Assignment.repository.OutputDetailsRepository;
import com.bhardwaj.Assignment.service.StringModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharactersRemovalController {

    @Autowired
    StringModificationService stringModificationService;

    @RequestMapping("remove")
    public void removeSimilarAdjacentCharacters(){
        stringModificationService.removeSimilarAdjacentCharacters();
    }

}
