package br.com.lazilha.andre.dao;

import br.com.lazilha.andre.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProdutoDao extends CrudRepository<Produto, Integer> {

    public List<Produto> findAll();
    
}
