package com.evertonreis.repository;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.RequestStage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StageRepositoryTest {

    @Autowired private StageRepository repository;

    @Test
    public void saveTest(){
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Request request = new Request();
        request.setId(1L);

        Stage stages = new Stage(null,"Foi cmmprado um notebook Samsung com HD de 1T", new Date(), RequestStage.CLOSED,request,usuario);
        Stage createdStage = repository.save(stages);

        assertThat(createdStage.getId()).isEqualTo(1L);
    }

    @Test
    public void getByIdTest(){
        Optional<Stage> result = repository.findById(1L);
        Stage stage = result.get();

        assertThat(stage.getDescricao()).isEqualTo("Foi cmmprado um notebook Samsung com HD de 1T");
    }

    @Test
    public void listByRequestIdTest(){
        List<Stage> stages = repository.findAllByRequestId(1L);
        assertThat(stages.size()).isEqualTo(1);
    }
}
