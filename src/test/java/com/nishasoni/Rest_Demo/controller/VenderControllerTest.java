package com.nishasoni.Rest_Demo.controller;

import com.nishasoni.Rest_Demo.model.Vender;
import com.nishasoni.Rest_Demo.service.VenderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VenderControllerTest.class)
class VenderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VenderService service;
    Vender venderOne;
    Vender venderTwo;
    List<Vender> venderList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        venderOne = new Vender("1","Amazon","USA","xxxxx");
        venderTwo = new Vender("2","GCP","Ind","xxxxx");= new Vender("1","Amazon","USA","xxxxx");

        venderList.add(venderOne);
        venderList.add(venderTwo);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetVendorDetails() throws Exception {
        when(service.getVender("1")).thenReturn(venderOne);


        this.mockMvc.perform(get("/vender/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllVendorDetails() throws Exception {
        when(service.getAllVenders()).thenReturn(venderList);


        this.mockMvc.perform(get("/vender/")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    void createVenderDetails() {
    }

    @Test
    void updateVenderDetails() {
    }

    @Test
    void deleteVenderDetails() {
    }
}