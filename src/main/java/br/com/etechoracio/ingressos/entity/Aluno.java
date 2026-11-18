package br.com.etechoracio.ingressos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "TBL_ALUNO")
@Getter
@Setter
public class Aluno {
    @Id
    @Column(name = "ID_ALUNO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "TX_TELEFONE")
    private String telefone;

    @JoinColumn(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

}
