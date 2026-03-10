package br.com.jobs.CadastroNinja.ninjas.controller;

import br.com.jobs.CadastroNinja.missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

// transforma uma classe em entidade no DB
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private int idade;

    //muitos ninjas para uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missao;

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public NinjaModel() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
