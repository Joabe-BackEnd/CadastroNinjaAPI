package br.com.jobs.CadastroNinja.missoes;

import br.com.jobs.CadastroNinja.ninjas.controller.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;

    //uma missao para muitos ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

}
