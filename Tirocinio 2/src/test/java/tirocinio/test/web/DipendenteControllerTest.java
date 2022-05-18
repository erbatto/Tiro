package tirocinio.test.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Optional;

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
import tirocinio.persistence.DipendenteRepository;
import tirocinio.service.DipendenteServiceImpl;
import tirocinio.web.DipendenteController;

@ExtendWith(MockitoExtension.class)
public class DipendenteControllerTest {

    private MockMvc mvc;

  
    @Mock
    @Autowired
    private DipendenteServiceImpl service;

    @InjectMocks
    private DipendenteController dipendenteController;

    
    private JacksonTester<Dipendente> jsonDipendente;

    @BeforeEach
    public void setup() {
   
        JacksonTester.initFields(this, new ObjectMapper());
       
        mvc = MockMvcBuilders.standaloneSetup(dipendenteController)
                .build();
    }

    @Test
    public void getDipendenteTest() throws Exception {
        // given
        when(service.getDipendente(2L))
                .thenReturn(new Dipendente(2L,"matricola2", "cognome2", "nome2", "codicefiscale2", null, 1,1, 0, 0));
        		
        // when
        MockHttpServletResponse response = mvc.perform(
                get("/dipendente/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                jsonDipendente.write(new Dipendente(2L,"matricola2", "cognome2", "nome2", "codicefiscale2", null, 1,1, 0, 0)).getJson()
        );
    }



    @Test
    public void createDipendenteTest() throws Exception {
        // when
        MockHttpServletResponse response = mvc.perform(
                post("/dipendente")
                .contentType(MediaType.APPLICATION_JSON).content(
                jsonDipendente.write(new Dipendente(2L,"matricola2", "cognome2", "nome2", "codicefiscale2", null, 1,1, 0, 0))
                .getJson()))
        		.andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }
}
