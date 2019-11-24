package br.com.lazilha.andre.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUTO_PEDIDO")
@Getter
@Setter
@NoArgsConstructor
public class ProdutoPedido {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "gen_itempedido", sequenceName = "idProdutoPedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gen_itempedido")
    @JsonProperty("id")
    private int id;

    @ManyToOne
    @NotNull
    @JsonProperty("product")
    private Produto produto;

    @ManyToOne
    @NotNull
    @JsonProperty("pedido")
    @JsonBackReference
    private Pedido pedido;

    @Column
    @NotNull
    @JsonProperty("amount")
    private int quantidade;

    @Column
    @NotNull
    @JsonProperty("price_unit")
    @Min(0)
    private Double preco_unitario;

    @Column
    @NotNull
    @JsonProperty("total")
    @Min(0)
    private Double total;



}
