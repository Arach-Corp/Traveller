package br.com.fiap.traveller.entities;

import br.com.fiap.traveller.entities.enums.TipoDica;

import javax.persistence.*;

@Entity
@Table(name = "T_TRV_DICAS")
public class Dica {

    @Id
    @Column(name = "id_dica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_dica")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_tipo_dica", length = 60)
    private TipoDica tipo;

    @ManyToOne
    @JoinColumn(name="ponto_turistico_id")
    private PontoTuristico pontoTuristico;

    public Dica(Long id, String descricao, TipoDica tipo, PontoTuristico pontoTuristico) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.pontoTuristico = pontoTuristico;
    }

    public Dica() { }


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

    public TipoDica getTipo() {
        return tipo;
    }

    public void setTipo(TipoDica tipo) {
        this.tipo = tipo;
    }

    public PontoTuristico getPontoTuristico() {
        return pontoTuristico;
    }

    public void setPontoTuristico(PontoTuristico pontoTuristico) {
        this.pontoTuristico = pontoTuristico;
    }

    @Override
    public String toString() {
        return "Dica{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
