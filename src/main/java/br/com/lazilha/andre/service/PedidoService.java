package br.com.lazilha.andre.service;

import br.com.lazilha.andre.dao.PedidoDao;
import br.com.lazilha.andre.dao.ProdutoPedidoDao;
import br.com.lazilha.andre.model.Pedido;
import br.com.lazilha.andre.model.ProdutoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoDao pedidoDao;

    @Autowired
    private ProdutoPedidoDao produtoPedidoDao;

    public List<Pedido> listarTodos() {
        return pedidoDao.findAll();
    }

    public void atualizarStatus(int id){
        Pedido pedido = pedidoDao.findOne(id);
        if(pedido != null){
            pedido.setStatus("CANCELED");
            pedido.setCancelDate(new Date());
            pedidoDao.save(pedido);
        }
    }

    public void salvar(Pedido pedido){

        pedidoDao.save(pedido);

        for (ProdutoPedido produtopedido: pedido.getProdutos()) {
            produtopedido.setPedido(pedido);
            produtoPedidoDao.save(produtopedido);
        }


    }


}
