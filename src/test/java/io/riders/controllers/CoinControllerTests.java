package io.riders.controllers;

import io.riders.services.HistoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by tommy on 5/17/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CoinController.class)
@WebAppConfiguration
public class CoinControllerTests {

    @MockBean
    HistoryService historyService;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void testUnsignedUserPostToCoin() throws Exception {
        this.mvc.perform(post("/coin"))
                .andExpect(status().is(401));
    }

    @Test
    public void testUnsignedUserGetToCoin() throws Exception {
        this.mvc.perform(get("/coin"))
                .andExpect(status().is(401));
    }

    @Test
    public void testSignedInUserPostToCoin() throws Exception {
        this.mvc.perform(post("/coin")
                .with(user("user")).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void testSignedInUserGetToCoin() throws Exception {
        this.mvc.perform(get("/coin")
                .with(user("user")).accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.parseMediaType("text/html;charset=UTF-8")));
    }
}
