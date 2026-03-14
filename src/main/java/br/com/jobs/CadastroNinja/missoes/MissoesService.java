package br.com.jobs.CadastroNinja.missoes;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //criar missao
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    //listar missoes
    public List<MissoesDTO> listarTodasAsMissoes(){
        List<MissoesModel> missoesModels = missoesRepository.findAll();

        return missoesModels.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //listar missao por id
    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);

        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    //atualizar dados da missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        if (missoesModel.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missoesDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }

    //deletar missao por id
    public void deletarMissao(Long id){

        missoesRepository.deleteById(id);
    }
}
