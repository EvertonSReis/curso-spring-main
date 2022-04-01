package com.evertonreis.resource;

import com.evertonreis.domain.Stage;
import com.evertonreis.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "stages")
public class StageResource {

    @Autowired
    private StageService service;

    @PostMapping
    public ResponseEntity<Stage> save(@RequestBody Stage stage){
        Stage createdStage = service.save(stage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stage> update(@PathVariable(name = "id") Long id, Stage stage){
        stage.setId(id);

        Stage updateStage = service.save(stage);
        return ResponseEntity.ok(updateStage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stage> getById(@PathVariable(name = "id") Long id){
        Stage obj = service.getById(id);
        return ResponseEntity.ok(obj);
    }

}
