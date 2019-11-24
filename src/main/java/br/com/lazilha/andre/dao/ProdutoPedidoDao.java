package br.com.lazilha.andre.dao;

import br.com.lazilha.andre.model.ProdutoPedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoPedidoDao extends CrudRepository<ProdutoPedido, Integer> {

    public List<ProdutoPedido> findAll();

}
