package com.evertonreis.services;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.RequestStage;
import com.evertonreis.model.PageModel;
import com.evertonreis.model.PageRequestModel;
import com.evertonreis.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public Request save(Request request){
        request.setStage(RequestStage.ABERTO);
        request.setDataCriacao(new Date());


        Request createdRequest = repository.save(request);
        return createdRequest;
    }

    public Request update(Request request){
        Request updateRequeste = repository.save(request);
        return updateRequeste;
    }

    public Request getById(Long id){
        Optional<Request> obj = repository.findById(id);
        return obj.get();
    }

    public List<Request> listByRequest(){
        List<Request> requests = repository.findAll();
        return requests;
    }

    public PageModel<Request> listByRequestOnLazy(PageRequestModel pr){
        Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
        Page<Request> page = repository.findAll(pageable);

        PageModel<Request> pm = new PageModel<>((int) page.getTotalElements(), page.getTotalPages(), page.getSize(), page.getContent());
        return pm;
    }

    public List<Request> listAllByUsuarioId(Long id){
        List<Request> requests = repository.findAllByUserId(id);
        return requests;
    }

    public PageModel<Request> listAllByUserIdOnLazyModel(Long usuarioId, PageRequestModel pr){
        Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
        Page<Request> page = repository.findAllByUserId(usuarioId, pageable);

        PageModel<Request> pm = new PageModel((int) page.getTotalElements(), page.getTotalPages(), page.getSize(), page.getContent());
        return pm;
    }
}
