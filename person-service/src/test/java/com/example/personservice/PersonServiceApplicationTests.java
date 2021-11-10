//package com.example.personservice;
//
//import com.example.personservice.model.persons.Director;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultHandler;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import java.util.List;
//
//import static org.hamcrest.core.StringContains.containsString;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//class PersonServiceApplicationTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    public void saveUser() throws Exception {
//        this.mockMvc.perform(post("/director").param("Ivan", "Ivanovich",
//                        "Ivanov", "33", "M", "2021", "2022"))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//
////    @Test
////    void test() throws Exception {
////        this.mockMvc.perform(get("/director/alldirectors"))
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(content().json({}));
////    }
//
//    }
//}
//
