package com.evertonreis.repository;

import com.evertonreis.domain.Request;
import com.evertonreis.domain.Stage;
import com.evertonreis.domain.Usuario;
import com.evertonreis.enums.RequestStage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    public List<Request> findAllByUserId(Long id);

    public Page<Request> findAllByUserId(Long id, Pageable pageable);

    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE request SET stage = ?2 WHERE id = ?1")
    public int updateStatus(Long id, RequestStage stage);

}
