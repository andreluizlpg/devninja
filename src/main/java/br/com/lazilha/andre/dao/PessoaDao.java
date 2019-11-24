package br.com.lazilha.andre.dao;

import br.com.lazilha.andre.model.Pessoa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PessoaDao extends CrudRepository<Pessoa, Integer> {

    public List<Pessoa> findAll();
    
}
