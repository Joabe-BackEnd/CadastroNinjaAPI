package br.com.jobs.CadastroNinja.ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/oirota")
    public String dizOiPraRotaFilho(){
        return "OOOI ROTA :)!";
    }

    //adicionar ninja
    @PostMapping("/criarNinja")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }
    //mostrar todos os ninjas
    @GetMapping("/listarTodos")
    public List<NinjaModel> listarTodosOsNinjas(){
        return ninjaService.listarTodosOsNinjas();
    }
    //mostrar ninja por id
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }
    //alterar dados ninja
    @PutMapping("/alterarPorID")
    public String alterarNinjaPorId(){
        return "Informações alteradas";
    }
    //deletar ninja
    @DeleteMapping("/deletarID")
    public String deletarNinja(){
        return "Ninja deletado da tabela";
    }

}
