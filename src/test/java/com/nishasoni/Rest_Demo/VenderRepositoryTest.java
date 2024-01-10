package com.nishasoni.Rest_Demo;

import com.nishasoni.Rest_Demo.model.Vender;
import com.nishasoni.Rest_Demo.repository.VenderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class VenderRepositoryTest {

    @Autowired
    private VenderRepository venderRepository;
    Vender vender;

    @BeforeEach
    void setUp() {
        vender = new Vender("Amazon","USA", "xxxxx");
        venderRepository.save(vender);
    }

    @AfterEach
    void tearDown() {
        vender = null;
        venderRepository.deleteAll();
    }
    //SUCCESS
    @Test
    void testFindByVenderName_Found(){
        List<Vender> venderList = venderRepository.findByVenderName("Amazon");
        assertThat(venderList.get(0).getVenderAddress())
                .isEqualTo(vender.getVenderName());
    }
    //FAILED
    @Test
    void testFindByVenderName_NotFound(){
        List<Vender> venderList = venderRepository.findByVenderName("GCP");
        assertThat(venderList.isEmpty()).isTrue();
    }

}
