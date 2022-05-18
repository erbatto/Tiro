package tirocinio.test.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import tirocinio.model.Dipendente;
import tirocinio.model.Recapito;
import tirocinio.service.DipendenteServiceImpl;
import tirocinio.service.RecapitoServiceImpl;
import tirocinio.web.DipendenteController;
import tirocinio.web.RecapitoController;

@ExtendWith(MockitoExtension.class)
public class RecapitoControllerTest {

    private MockMvc mvc;

  
    @Mock
    @Autowired
    private RecapitoServiceImpl service;

    @InjectMocks
    private RecapitoController recapitoController;

    
    private JacksonTester<Recapito> jsonRecapito;

    @BeforeEach
    public void setup() {
   
        JacksonTester.initFields(this, new ObjectMapper());
       
        mvc = MockMvcBuilders.standaloneSetup(recapitoController)
                .build();
    }

    @Test
    public void getRecapitoTest() throws Exception {
        // given
        when(service.getRecapito(2L))
                .thenReturn(new Recapito(2L, "test@gmail.com", 0, 0, "Roma","00152", "via paola", "33","3334445566", 1L));
        		
      
        MockHttpServletResponse response = mvc.perform(
                get("/recapito/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonRecapito.write(new Recapito(2L, "test@gmail.com", 0, 0, "Roma","00152", "via paola", "33","3334445566", 1L)).getJson());
        		
    }



    @Test
    public void createRecapitoTest() throws Exception {
        // when
        MockHttpServletResponse response = mvc.perform(
                post("/recapito")
                .contentType(MediaType.APPLICATION_JSON).content(
                jsonRecapito.write(new Recapito(2L, "test@gmail.com", 0, 0, "Roma","00152", "via paola", "33","3334445566", 1L))
                .getJson()))
        		.andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }
}
