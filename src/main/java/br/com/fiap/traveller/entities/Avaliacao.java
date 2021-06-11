package br.com.fiap.traveller.entities;

import br.com.fiap.traveller.entities.pk.AvaliacaoPK;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_TRV_AVALIACAO")
public class Avaliacao {

    @EmbeddedId
    private AvaliacaoPK id;

    @Column(name = "ds_comentario")
    private String comentario;

    @Column(name = "nr_estrela")
    private Integer estrelas;

    @Column(name = "ds_preco")
    private BigDecimal preco;

    @Column(name = "ds_dia_semana", length = 20)
    private String diaSemana;

    @CreationTimestamp
    @Column(name = "dt_timestamp")
    private LocalDateTime timestamp;


    public Avaliacao(AvaliacaoPK id, String comentario, Integer estrelas, BigDecimal preco, String diaSemana) {
        this.id = id;
        this.comentario = comentario;
        this.estrelas = estrelas;
        this.preco = preco;
        this.diaSemana = diaSemana;
    }

    public Avaliacao() {
    }

    public AvaliacaoPK getId() {
        return id;
    }

    public void setId(AvaliacaoPK id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(Integer estrelas) {
        this.estrelas = estrelas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public PontoTuristico getPontoTuristico(){
        return getId().getPontoTuristico();
    }

    public Usuario getUsuario(){
        return getId().getUsuario();
    }
}
