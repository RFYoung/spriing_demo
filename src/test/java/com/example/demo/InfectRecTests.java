package com.example.demo;

import com.example.demo.model.InfectRec;
import com.example.demo.repository.InfectRecRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.example.demo.controller.InfectRecController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = {InfectRecController.class})
public class InfectRecTests {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private InfectRecRepository<InfectRec> repository;

    public InfectRecTests() {
    }

    @Test
    public void addTest() throws Exception {
        // Remain the test user and let id = 1
        int testUserid = 1;
        Integer maxUserId=repository.getMaxId();
        System.out.printf("Max User ID = %d\n",maxUserId);
        //post to add - correct
        final ResultActions result =
                mvc.perform(
                post("/user/uploadinf")
                                .content("\"userId\" : " +testUserid + "," +
                                        "\"randomId\" : testRandId")
                                .contentType(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk());
        //post to add - wrong
        final ResultActions result2 =
                mvc.perform(
                        post("/user/uploadinf")
                                .content("\"userId\" : "+ maxUserId +"," +
                                        "\"randomId\" : testRandId")
                                .contentType(MediaType.APPLICATION_JSON));
        result2.andExpect(status().isBadRequest());
    }

}
