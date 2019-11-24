package br.com.lazilha.andre.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PEDIDO")
@Getter
@Setter
@NoArgsConstructor
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "gen_pedido", sequenceName = "idPedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gen_pedido")
    @JsonProperty("id")
    private int id;

    @OneToMany(mappedBy = "pedido")
    @NotNull
    @JsonProperty("items")
    @JsonManagedReference
    private List<ProdutoPedido> produtos;

    @ManyToOne
    @NotNull
    @JsonProperty("buyer")
    private Pessoa cliente;

    @Column
    @NotNull
    @JsonProperty("status")
    private String status;

    @Column
    @NotNull
    @JsonProperty("total")
    @Min(0)
    private Double total;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @NotNull
    @JsonProperty("createdat")
    private Date created_at;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("cancelDate")
    private Date cancelDate;

    @PrePersist
    public void onPrePersist() {
        created_at = new Date();
    }


}
