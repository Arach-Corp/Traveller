package br.com.fiap.traveller.entities.dto;

import br.com.fiap.traveller.entities.PontoTuristico;

import java.math.BigDecimal;
import java.util.Objects;

public class PontoTuristicoDTO {

    private String nome;
    private String descricao;
    private String funcionamento;
    private String foto;
    private boolean pcd;
    private String site;
    private BigDecimal preco;

    private CategoriaDTO categoria;
    private EnderecoDTO endereco;
    private Double avaliacao;


    public PontoTuristicoDTO() {
    }

    public PontoTuristicoDTO(String nome, String descricao, String funcionamento, String foto, boolean pcd, String site, BigDecimal preco, CategoriaDTO categoria, EnderecoDTO endereco, Double avaliacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.funcionamento = funcionamento;
        this.foto = foto;
        this.pcd = pcd;
        this.site = site;
        this.preco = preco;
        this.categoria = categoria;
        this.endereco = endereco;
        this.avaliacao = avaliacao;
    }

    public PontoTuristicoDTO(PontoTuristico pontoTuristico){
        this.nome = pontoTuristico.getNome();
        this.descricao = pontoTuristico.getDescricao();
        this.funcionamento = pontoTuristico.getHorarioFuncionamento();
        this.foto = pontoTuristico.getUrlFoto();
        this.pcd = pontoTuristico.isAcessivelPCD();
        this.site = pontoTuristico.getUrlSiteOficial();
        this.preco = pontoTuristico.getPreco();
        this.categoria = new CategoriaDTO(pontoTuristico.getCategoria());
        this.endereco = new EnderecoDTO(pontoTuristico.getEndereco());
        Integer vl = pontoTuristico.getAvaliacoes().stream().map(a -> (Objects.nonNull(a.getEstrelas()))? a.getEstrelas():Integer.valueOf(0)).reduce(Integer::sum).get();
        this.avaliacao = (double) vl/(pontoTuristico.getAvaliacoes().size());
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

    public String getFuncionamento() {
        return funcionamento;
    }

    public void setFuncionamento(String funcionamento) {
        this.funcionamento = funcionamento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public boolean isPdc() {
        return pcd;
    }

    public void setPdc(boolean pdc) {
        this.pcd = pdc;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }
}
