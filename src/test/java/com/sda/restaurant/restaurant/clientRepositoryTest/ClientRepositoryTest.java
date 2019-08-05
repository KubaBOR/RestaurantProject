package com.sda.restaurant.restaurant.clientRepositoryTest;

import com.sda.restaurant.restaurant.model.ClientEntity;
import com.sda.restaurant.restaurant.repositories.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private ClientRepository repository;

    @Test
    public void findByEmailTest() {
        //this.entityManager.persist(new ClientEntity("Jan","Kowalski","JK@wp.pl","666666666"));
        ClientEntity clientEntity=this.repository.findByEmail("f.brooown2@gmail.com");
        assertThat(clientEntity.getEmail()).isEqualTo("f.brooown2@gmail.com");

    }

}
