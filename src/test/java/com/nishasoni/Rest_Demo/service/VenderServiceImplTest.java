package com.nishasoni.Rest_Demo.service;

import com.nishasoni.Rest_Demo.model.Vender;
import com.nishasoni.Rest_Demo.repository.VenderRepository;
import com.nishasoni.Rest_Demo.service.VenderService;
import com.nishasoni.Rest_Demo.service.VenderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DataJpaTest
public class VenderServiceImplTest {

    @Mock
    private VenderRepository repository;
    private VenderService service;
    AutoCloseable autoCloseable;
    Vender vender;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        service = new VenderServiceImpl(repository);
        vender = new Vender("1","Amazon","USA","xxxxx");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();

    }

    @Test
    void createVender(){
        mock(Vender.class);
        mock(VenderRepository.class);

        when(repository.save(vender)).thenReturn(vender);
        assertThat(service.createVender(vender)).isEqualTo("SUCCUSS");
    }

    @Test
    void testUpdateVender(){
        mock(Vender.class);
        mock(VenderRepository.class);

        when(repository.save(vender)).thenReturn(vender);
        assertThat(service.updateVender(vender)).isEqualTo("SUCCUSS");
    }

    @Test
    void deleteVender(){
        mock(Vender.class);
        mock(VenderRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(
                Answers.CALLS_REAL_METHODS
        ).when(repository).deleteById(any());
        assertThat(service.deleteVender("1")).isEqualTo("Succuss");
    }

    @Test
    void testGetVender(){
        mock(Vender.class);
        mock(VenderRepository.class);

        when(repository.findById("1")).thenReturn(Optional.ofNullable(vender));
        assertThat(service.getVender("1").getVenderName()).isEqualTo(vender.getVenderName());
    }

//    @Test
//    void testyGetByVenderName(){
//        mock(Vender.class);
//        mock(VenderRepository.class);
//
//        when(repository.findByVenderName("Amazon")).thenReturn(new ArrayList<Vender>(Collections.singleton(vender)));
//        assertThat(service.getVender("1").get(0).getVederId()).isEqualTo(vender.getVenderId());
//    }

    @Test
    void getAllVenders(){
        mock(Vender.class);
        mock(VenderRepository.class);

        when(repository.findAll()).thenReturn(new ArrayList<Vender>(Collections.singleton(vender)));
        assertThat(service.getAllVenders().get(0).getVenderPhonenumber()).isEqualTo(vender.getVenderPhonenumber());

    }





}
