package com.evertonreis.domain;

import com.evertonreis.enums.RequestStage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "request")
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String subject;

    @Column(columnDefinition = "text")
    private String descição;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCriacao;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestStage stage;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario user;

    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(mappedBy = "request")
    private List<Stage> stages = new ArrayList<>();
}
