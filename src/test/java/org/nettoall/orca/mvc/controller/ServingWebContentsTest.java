package org.nettoall.orca.mvc.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.nettoall.orca.hateoas.controller.GreetingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers= GreetingController.class)
public class ServingWebContentsTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * response의 content의 해당 string 이 있는지 검사
     *
     * @throws Exception
     */
    @Test
    public void greeting() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andExpect(content().string(containsString("Hello, World!")));
    }

    @Test
    public void greetingWithUser() throws Exception {
        mockMvc.perform(get("/greeting").param("name","Greg"))
                .andExpect(content().string(containsString("Hello, Greg!")));
    }
}
