package com.evertonreis.dto;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.RequestStage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class RequestSavedto {

    @NotBlank
    private String subject;
    private String descricao;

    @NotNull
    private Usuario user;
    private List<Stage> stages = new ArrayList<>();

    public Request transformToRequest(){
        Request request = new Request(null, subject, descricao,new Date(),null,user,stages);
        return request;
    }
}
