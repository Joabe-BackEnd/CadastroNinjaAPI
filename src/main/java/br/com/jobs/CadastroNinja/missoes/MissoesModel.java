package br.com.jobs.CadastroNinja.missoes;

import br.com.jobs.CadastroNinja.ninjas.controller.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;

    //uma missao para muitos ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

    public MissoesModel(long id, String nomeDaMissao, String dificuldade) {
        this.id = id;
        this.nome = nomeDaMissao;
        this.dificuldade = dificuldade;
    }

    public MissoesModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeDaMissao() {
        return nome;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nome = nomeDaMissao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
}
