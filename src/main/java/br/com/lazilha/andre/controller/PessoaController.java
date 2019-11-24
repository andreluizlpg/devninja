package br.com.lazilha.andre.controller;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.lazilha.andre.model.Pessoa;
import br.com.lazilha.andre.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/customers")
    private void salvarPessoa(@RequestBody Pessoa pessoa){
        pessoa.setId(0);
        try {
            CPFValidator validator = new CPFValidator();
            validator.assertValid(pessoa.getCpf());
            pessoaService.salvar(pessoa);

        } catch (InvalidStateException e) {
            System.out.println(e.getMessage());
        }

    }

    @GetMapping("/customers")
    @ResponseBody
    private List<Pessoa> listarPessoa(){
        return pessoaService.listarTodos();
    }


}
