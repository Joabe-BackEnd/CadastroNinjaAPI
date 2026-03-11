package br.com.jobs.CadastroNinja.ninjas.controller;

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

}
