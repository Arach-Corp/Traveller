package br.com.fiap.traveller.entities.pk;

import br.com.fiap.traveller.entities.PontoTuristico;
import br.com.fiap.traveller.entities.Usuario;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AvaliacaoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ponto_turistico_id")
    private PontoTuristico pontoTuristico;

    public AvaliacaoPK(Usuario usuario, PontoTuristico pontoTuristico) {
        this.usuario = usuario;
        this.pontoTuristico = pontoTuristico;
    }

    public AvaliacaoPK() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PontoTuristico getPontoTuristico() {
        return pontoTuristico;
    }

    public void setPontoTuristico(PontoTuristico pontoTuristico) {
        this.pontoTuristico = pontoTuristico;
    }
}
