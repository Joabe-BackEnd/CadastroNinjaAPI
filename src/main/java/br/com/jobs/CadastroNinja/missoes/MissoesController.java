package br.com.jobs.CadastroNinja.missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //criar missao
    @PostMapping("/criarMissao")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missaoNova = missoesService.criarMissao(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso!");
    }

    //listar missoes
    @GetMapping("/listarTodas")
    public List<MissoesDTO> listarTodasAsMissoes(){
        return missoesService.listarTodasAsMissoes();
    }

    //listar missao por id
    @GetMapping("listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    //atualizar missao
    @PutMapping("alterar/{id}")
    public MissoesDTO atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        return missoesService.atualizarMissao(id,missoesDTO);
    }

    //deletar missao
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
        if (missoesService.listarMissaoPorId(id) != null){
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missão deletada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missão de ID "+ id + " não encontrado.");
    }
}
