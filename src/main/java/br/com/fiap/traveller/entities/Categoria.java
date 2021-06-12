package br.com.fiap.traveller.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_TRV_CATEGORIA")
public class Categoria {

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_categoria", length = 60)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<PontoTuristico> pontosTuristicos = new ArrayList<>();


    public Categoria(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Categoria() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<PontoTuristico> getPontosTuristicos(){
        return this.pontosTuristicos;
    }


    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
