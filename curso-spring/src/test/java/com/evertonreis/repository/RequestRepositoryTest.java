package com.evertonreis.repository;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.RequestStage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestRepositoryTest {

    @Autowired RequestRepository repository;

    @Test
    public void AsaveTest(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Request request = new Request(null, "Notebook Samsung", "procurando notebooks", new Date(), RequestStage.ABERTO,usuario,null);
        Request createdRequest = repository.save(request);

        assertThat(createdRequest.getId()).isEqualTo(1L);
    }

    @Test
    public void updateTest(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Request request = new Request(1L, "Notebook Samsung,SSD 256GN", "procurando notebooks", new Date(), RequestStage.ABERTO,usuario,null);
        Request updateRequest = repository.save(request);

        assertThat(updateRequest.getSubject()).isEqualTo("Notebook Samsung,SSD 256GN");

    }

    @Test
    public void getByIdTest(){
        Optional<Request> result = repository.findById(1l);
        Request request = result.get();

        assertThat(request.getDescricao()).isEqualTo("procurando notebooks");
    }

    @Test
    public void listTest(){
        List<Request> requests = repository.findAll();
        assertThat(requests.size()).isEqualTo(1);
    }

//    @Test
//    public void listByUsuarioIdTest(){
//        List<Request> requests = repository.findAllByUsuarioId(1L);
//        assertThat(requests.size()).isEqualTo(1);
//    }

    @Test
    public void updateStatusTest(){
        int affectedRows = repository.updateStatus(1L, RequestStage.EM_PROGRESSO);
        assertThat(affectedRows).isEqualTo(1);
    }
}
