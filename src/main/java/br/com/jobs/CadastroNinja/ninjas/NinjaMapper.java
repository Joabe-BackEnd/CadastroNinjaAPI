package br.com.jobs.CadastroNinja.ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setMissao(ninjaDTO.getMissao());
        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setMissao(ninjaModel.getMissao());
        return ninjaDTO;
    }
}
