package br.com.etechoracio.ingressos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TBL_OFICINA")

public class Oficina {
    @Id // PRIMARY KEY
    @Column(name = "ID_OFICINA")  // nome da coluna no banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) // identity
    private Long id;

    @Column(name = "TX_NOME_OFICINA")
    private String nomeOficina;

    @Column(name = "TX_TUTOR")
    private String tutor;

    @Enumerated()
    @Column(name = "HR_HORARIO")
    private LocalTime horario;


    @Column(name = "TP_SALA")
    private String sala;


    @Column(name = "NR_QUANTIDADE_VAGAS")
    private Integer vagasMaximas;

    @Column(name = "NR_TOTAL_INSCRITOS")
    private Integer totalInscritos;


    @Column(name = "TX_STATUS")
    private Boolean lotada;

}
