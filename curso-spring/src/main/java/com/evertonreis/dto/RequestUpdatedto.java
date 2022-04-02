package com.evertonreis.dto;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.RequestStage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdatedto {
    @NotBlank
    private String subject;
    private String descricao;

    @NotNull
    private RequestStage stage;

    @NotNull
    private Usuario user;
    private List<Stage> stages = new ArrayList<>();

    public Request transformToRequest(){
        Request request = new Request(null, subject, descricao,null,stage,user,stages);
        return request;
    }
}
