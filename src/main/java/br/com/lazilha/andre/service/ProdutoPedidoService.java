package br.com.lazilha.andre.service;

import br.com.lazilha.andre.dao.ProdutoPedidoDao;
import br.com.lazilha.andre.model.ProdutoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoPedidoService {

    @Autowired
    private ProdutoPedidoDao produtoPedidoDao;

    public List<ProdutoPedido> listarTodos() {
        return produtoPedidoDao.findAll();
    }

    public void salvar(ProdutoPedido produtoPedido){
        produtoPedidoDao.save(produtoPedido);
    }
    

}
