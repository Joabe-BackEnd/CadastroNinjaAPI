package br.com.jobs.CadastroNinja.ninjas;

import br.com.jobs.CadastroNinja.missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// transforma uma classe em entidade no DB
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @Column(name = "rank")
    private String rank;
    //muitos ninjas para uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missao;

}
