package br.com.fiap.traveller.entities;

import javax.persistence.*;

@Entity
@Table(name = "T_TRV_ENDERECO")
public class Endereco {

    @Id
    @Column(name = "id_endereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ds_logradouro", length = 100)
    private String logradouro;

    @Column(name = "ds_numero", length = 15)
    private String numero;

    @Column(name = "ds_cidade", length = 50)
    private String cidade;

    @Column(name = "ds_estado", length = 50)
    private String estado;

    @Column(name = "ds_cep", length = 8)
    private String cep;

    @Column(name = "ds_complemento", length = 70)
    private String complemento;

    @OneToOne
    @JoinColumn(name = "ponto_turistico_id")
    private PontoTuristico pontoTuristico;

    public Endereco(Long id, String logradouro, String numero, String cidade, String estado, String cep, String complemento, PontoTuristico pontoTuristico) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
        this.pontoTuristico = pontoTuristico;
    }

    public Endereco() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public PontoTuristico getPontoTuristico() {
        return pontoTuristico;
    }

    public void setPontoTuristico(PontoTuristico pontoTuristico) {
        this.pontoTuristico = pontoTuristico;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}

