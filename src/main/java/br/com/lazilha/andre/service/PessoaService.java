package br.com.lazilha.andre.service;

import br.com.lazilha.andre.dao.PessoaDao;
import br.com.lazilha.andre.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaDao pessoaDao;

    public List<Pessoa> listarTodos() {
        return pessoaDao.findAll();
    }

    public void salvar(Pessoa pessoa){
        pessoaDao.save(pessoa);
    }
    

}
