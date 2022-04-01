package com.evertonreis.repository;

import com.evertonreis.domain.Stage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

    public List<Stage> findAllByRequestId(Long id);

    public Page<Stage> findAllByRequestId(Long id, Pageable pageable);

}
