package de.neuefische.controller;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTestsForShopController {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    OrderRepo orderRepo;
    @Test
   // @DirtiesContext
    void getAllOrders_thenReturnEmptyOdderList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    void getProductMethode_thenReturnProduct_withID1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                    {"id" : 1,
                                     "name" : "Apfel"
                                    }             
                                            """));
    }

    
}