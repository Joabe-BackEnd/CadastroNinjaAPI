package br.com.jobs.CadastroNinja.ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/oirota")
    public String dizOiPraRotaFilho(){
        return "OOOI ROTA :)!";
    }

}
