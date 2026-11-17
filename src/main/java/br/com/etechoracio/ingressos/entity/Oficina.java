package br.com.etechoracio.ingressos.entity;

import br.com.etechoracio.ingressos.enums.CategoriaFilmeEnum;
import br.com.etechoracio.ingressos.enums.ClassificacaoIndicativaEnum;
import br.com.etechoracio.ingressos.enums.SimNaoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "DT_DATA")
    private LocalDate data;

    @Enumerated()
    @Column(name = "HR_HORARIO")
    private LocalTime horario;


    @Column(name = "TP_SALA")
    private String sala;


    @Column(name = "NR_QUANTIDADE_VAGAS")
    private Integer quantidadeVagas;

    @Column(name = "TX_STATUS")
    private String Status;

}
