package com.evertonreis.resource;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.domain.Usuario;
import com.evertonreis.model.PageModel;
import com.evertonreis.model.PageRequestModel;
import com.evertonreis.services.RequestService;
import com.evertonreis.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/requests")
public class RequestResource {

    @Autowired
    private RequestService service;
    @Autowired
    private StageService stageService;

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody Request request){
        Request createdRequest  = service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable(name = "id") Long id,@RequestBody Request request){
        request.setId(id);

        Request updateRequest = service.save(request);
        return ResponseEntity.ok(updateRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id){
        Request obj = service.getById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<PageModel<Request>> listByRequest(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size){
        PageRequestModel pr = new PageRequestModel(page, size);
        PageModel<Request> pm = service.listByRequestOnLazy(pr);
        return ResponseEntity.ok(pm);
    }

    @GetMapping("/{id}/stages")
    public ResponseEntity<PageModel<Stage>> listAllStageById(@PathVariable(name = "id") Long id, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size){
        PageRequestModel pr = new PageRequestModel(page, size);
        PageModel<Stage> pm = stageService.listAllByStageIdOnLazyModel(id, pr);

        return ResponseEntity.ok(pm);
    }
}
