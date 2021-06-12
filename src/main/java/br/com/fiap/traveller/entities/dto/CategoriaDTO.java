package br.com.fiap.traveller.entities.dto;

import br.com.fiap.traveller.entities.Categoria;

public class CategoriaDTO {

    private Long id;
    private String descricao;


    public CategoriaDTO() {

    }

    public CategoriaDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public CategoriaDTO(Categoria categoria){
        setId(categoria.getId());
        setDescricao(categoria.getDescricao());
    }

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
}
