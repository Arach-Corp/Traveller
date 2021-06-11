package br.com.fiap.traveller.bean;

import br.com.fiap.traveller.dao.generic.PontoTuristicoDAO;
import br.com.fiap.traveller.dao.impl.PontoTuristicoDAOImpl;
import br.com.fiap.traveller.entities.Categoria;
import br.com.fiap.traveller.entities.Endereco;
import br.com.fiap.traveller.entities.PontoTuristico;
import br.com.fiap.traveller.sigleton.EntityManagerFactorySingleton;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PontoBean {

	private PontoTuristico ponto = new PontoTuristico();
	private Endereco endereco = new Endereco();
	private Categoria categoria = new Categoria();

	private PontoTuristicoDAO dao = new PontoTuristicoDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	private final FacesContext context = FacesContext.getCurrentInstance();



	public void criar() {
		System.out.println("Ponto turistico criado...");
	}

	public String editar() {
		context.getExternalContext().getSessionMap().put("ponto", ponto);
		return "edit?faces-redirect=true";
	}

	private void excluir() {

		context.getExternalContext().getSessionMap().put("ponto", ponto);

		System.out.println("asdasd");
	}

	public List<PontoTuristico> getPontosCadastrados() {

//		List<PontoTuristico> pontos = new ArrayList<>();
//		PontoTuristico pontoturistico = new PontoTuristico();
//		pontoturistico.setNome("lalalalalala");
//		pontoturistico.setId(Long.parseLong("1"));
//
//		PontoTuristico pontoturistico2 = new PontoTuristico();
//		pontoturistico2.setNome("lalalalalal222222a");
//		pontoturistico2.setId(Long.parseLong("2"));
//
//		PontoTuristico pontoturistico3 = new PontoTuristico();
//		pontoturistico3.setNome("lalalaasdasdasdalalala");
//		pontoturistico3.setId(Long.parseLong("3"));
//
//		pontos.add(pontoturistico);
//		pontos.add(pontoturistico2);
//		pontos.add(pontoturistico3);

		return dao.findAll();
	}

	public PontoTuristico getPonto() {
		return ponto;
	}

	public void setPonto(PontoTuristico ponto) {
		this.ponto = ponto;
	}

	public FacesContext getContext() {
		return context;
	}

	public PontoTuristico getPontoTuristico() {
		return ponto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setPontoTuristico(PontoTuristico pontoTuristico) {
		this.ponto = pontoTuristico;
	}

}
