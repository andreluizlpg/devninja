package br.com.lazilha.andre.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PESSOA")
@Getter
@Setter
@NoArgsConstructor
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "gen_pessoa", sequenceName = "idPessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "gen_pessoa")
    @JsonProperty("id")
    private int id;

    @Column
    @NotNull
    @JsonProperty("name")
    private String nome;

    @Column(unique = true)
    @NotNull
    @JsonProperty("cpf")
    private String cpf;

    @Column(unique = true)
    @NotNull
    @JsonProperty("email")
    private String email;

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
