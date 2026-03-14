package br.com.jobs.CadastroNinja.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // listar todos os meus ninjas
    public List<NinjaDTO> listarTodosOsNinjas(){
        List<NinjaModel> ninjaModels = ninjaRepository.findAll();
        return ninjaModels.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //listar ninjas por id
    public NinjaDTO listarNinjaPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //criar ninja novo
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //deletar ninja por id
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    //alterar ninja por id
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
      //  if (ninjaRepository.existsById(id)){
      //      ninjaAtualizado.setId(id);
      //      return ninjaRepository.save(ninjaAtualizado);
      //  }

        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}
