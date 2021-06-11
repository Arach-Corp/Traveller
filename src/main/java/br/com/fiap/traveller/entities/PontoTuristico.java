package br.com.fiap.traveller.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_TRV_PONTO_TURISTICO")
public class PontoTuristico {

    @Id
    @Column(name = "id_ponto_turistico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_ponto_turistico", length = 80)
    private String nome;

    @Column(name = "ds_ponto_turistico")
    private String descricao;

    @Column(name = "ds_horario_funcionamento")
    private String horarioFuncionamento;

    @Column(name = "url_foto", length = 128)
    private String urlFoto;

    @Column(name = "url_site_oficial", length = 128)
    private String urlSiteOficial;

    @Column(name = "ds_preco")
    private BigDecimal preco;

    @Column(name = "ds_acessivel_pcd")
    private boolean acessivelPCD;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToOne(mappedBy = "pontoTuristico")
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "id.pontoTuristico")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @OneToMany(mappedBy = "pontoTuristico")
    private List<Dica> dicas = new ArrayList<>();

    public PontoTuristico(Long id, String nome, String descricao, String horarioFuncionamento, String urlFoto, String urlSiteOficial, BigDecimal preco, boolean acessivelPCD, Categoria categoria, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.horarioFuncionamento = horarioFuncionamento;
        this.urlFoto = urlFoto;
        this.urlSiteOficial = urlSiteOficial;
        this.preco = preco;
        this.acessivelPCD = acessivelPCD;
        this.categoria = categoria;
        this.endereco = endereco;
    }
    public PontoTuristico( String nome, String descricao, String horarioFuncionamento, String urlFoto, String urlSiteOficial, BigDecimal preco, boolean acessivelPCD, Categoria categoria, Endereco endereco) {
        this.nome = nome;
        this.descricao = descricao;
        this.horarioFuncionamento = horarioFuncionamento;
        this.urlFoto = urlFoto;
        this.urlSiteOficial = urlSiteOficial;
        this.preco = preco;
        this.acessivelPCD = acessivelPCD;
        this.categoria = categoria;
        this.endereco = endereco;
    }


    public PontoTuristico() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlSiteOficial() {
        return urlSiteOficial;
    }

    public void setUrlSiteOficial(String urlSiteOficial) {
        this.urlSiteOficial = urlSiteOficial;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean isAcessivelPCD() {
        return acessivelPCD;
    }

    public void setAcessivelPCD(boolean acessivelPCD) {
        this.acessivelPCD = acessivelPCD;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "PontoTuristico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", horarioFuncionamento='" + horarioFuncionamento + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", urlSiteOficial='" + urlSiteOficial + '\'' +
                ", preco=" + preco +
                ", acessivelPCD=" + acessivelPCD +
                ", categoria=" + categoria +
                ", endereco=" + endereco +
                '}';
    }
}
