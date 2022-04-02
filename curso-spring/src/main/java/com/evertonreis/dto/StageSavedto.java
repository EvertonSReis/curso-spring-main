package com.evertonreis.dto;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.RequestStage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class StageSavedto {
    private String descricao;

    @NotNull
    private RequestStage stages;

    @NotNull
    private Request request;

    @NotNull
    private Usuario user;

    public Stage transformToStage(){
        Stage stage = new Stage(null, descricao, null, stages, request, user);
        return stage;
    }
}
