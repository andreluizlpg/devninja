package br.com.lazilha.andre.service;

import br.com.lazilha.andre.dao.ProdutoDao;
import br.com.lazilha.andre.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoDao produtoDao;

    public List<Produto> listarTodos() {
        return produtoDao.findAll();
    }

    public void salvar(Produto produto){
        produtoDao.save(produto);
    }
    

}
