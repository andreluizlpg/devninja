package br.com.lazilha.andre.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PRODUTO")
@Getter
@Setter
@NoArgsConstructor
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "gen_produto", sequenceName = "idProduto")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gen_produto")
    @JsonProperty("id")
    private int id;

    @Column(unique = true)
    @NotNull
    @JsonProperty("name")
    private String descricao;

    @Column(unique = true)
    @NotNull
    @JsonProperty("sku")
    private Long sku;

    @Column
    @NotNull
    @JsonProperty("price")
    @Min(0)
    private Double preco;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @NotNull
    @JsonProperty("createdat")
    private Date created_at;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("updatedat")
    private Date updated_at;

    @PrePersist
    public void onPrePersist() {
        created_at = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        updated_at = new Date();
    }


}
