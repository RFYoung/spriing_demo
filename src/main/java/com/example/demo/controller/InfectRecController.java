package com.example.demo.controller;

import com.example.demo.model.InfectRec;
import com.example.demo.repository.InfectRecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


@RestController
public class InfectRecController {

    // Set the repository
    @Autowired
    private InfectRecRepository<InfectRec> repository;

    @PostMapping("/user/uploadinf")
    public String uploadInfection(@RequestParam Integer userId,
                                  @RequestParam String randomId,
                                  HttpServletResponse response) {
        // get the time on server
        OffsetDateTime now = OffsetDateTime.now( ZoneOffset.UTC );

        try{
            // make a new object and try to insert it to the server
            InfectRec newRec = new InfectRec();
            // we use the server time to improve data validation
            newRec.setCreateDateTime(now.toLocalDateTime());
            newRec.setUserId(userId);
            newRec.setRandomId(randomId);
            repository.save(newRec);
            return "Add Success!";
        }
        catch(Exception e){
            // change the response code
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            return "Sorry Add Fail.\n";
        }
    }

}

