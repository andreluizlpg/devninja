package br.com.lazilha.andre.controller;

import br.com.lazilha.andre.model.Pedido;
import br.com.lazilha.andre.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping("/orders")
    private void salvarPedido(@RequestBody Pedido pedido){
        pedido.setId(0);
        pedidoService.salvar(pedido);
    }

    @GetMapping("/orders")
    @ResponseBody
    private List<Pedido> listarPedidos(){
        return pedidoService.listarTodos();
    }

    @PutMapping("/orders")
    private void salvarPedido(@RequestParam int id_order){
        pedidoService.atualizarStatus(id_order);
    }

    @GetMapping("/teste")
    @ResponseBody
    private List<Pedido> aaaa(){

        return null;
    }

}
