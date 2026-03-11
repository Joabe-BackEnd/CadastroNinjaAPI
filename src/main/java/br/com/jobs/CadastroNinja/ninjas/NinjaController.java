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
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja adcionado!";
    }
    //mostrar todos os ninjas
    @GetMapping("/todos")
    public List<NinjaModel> listarTodosOsNinjas(){
        return ninjaService.listarTodosOsNinjas();
    }
    //mostrar ninja por id
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId(){
        return "Informações mostradas!";
    }
    //alterar dados ninja
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Informações alteradas";
    }
    //deletar ninja
    @DeleteMapping("/deletarID")
    public String deletarNinja(){
        return "Ninja deletado da tabela";
    }

}
