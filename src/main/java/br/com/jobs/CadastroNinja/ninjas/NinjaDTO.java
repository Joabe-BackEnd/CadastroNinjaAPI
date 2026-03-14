package br.com.jobs.CadastroNinja.ninjas;

import br.com.jobs.CadastroNinja.missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private MissoesModel missao;

}
