package br.com.etechoracio.ingressos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="TBL_PROFESSOR")
public class Professor {
    @Id
    @Column(name = "ID_PROFESSOR")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "TX_ESPECIALIDADE")
    private String especialidade;

}
