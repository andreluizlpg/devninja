package br.com.lazilha.andre.controller;

import br.com.lazilha.andre.model.Produto;
import br.com.lazilha.andre.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/products")
    private void salvarProduto(@RequestBody Produto produto){
        produto.setId(0);
        produtoService.salvar(produto);
    }

    @GetMapping("/products")
    @ResponseBody
    private List<Produto> listarProduto(){
        return produtoService.listarTodos();
    }


}
