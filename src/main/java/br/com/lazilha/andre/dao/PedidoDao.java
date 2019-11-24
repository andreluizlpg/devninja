package br.com.lazilha.andre.dao;

import br.com.lazilha.andre.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoDao extends CrudRepository<Pedido, Integer> {

    public List<Pedido> findAll();

}
