package br.com.fiap.traveller.bean;

import br.com.fiap.traveller.dao.exceptions.CommitException;
import br.com.fiap.traveller.dao.exceptions.EntityNotFoundException;
import br.com.fiap.traveller.dao.generic.CategoriaDAO;
import br.com.fiap.traveller.dao.generic.PontoTuristicoDAO;
import br.com.fiap.traveller.dao.impl.CategoriaDAOImpl;
import br.com.fiap.traveller.dao.impl.PontoTuristicoDAOImpl;
import br.com.fiap.traveller.entities.Categoria;
import br.com.fiap.traveller.entities.Endereco;
import br.com.fiap.traveller.entities.PontoTuristico;
import br.com.fiap.traveller.sigleton.EntityManagerFactorySingleton;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PontoBean {

	private PontoTuristico ponto = new PontoTuristico();
	private Endereco endereco = new Endereco();
	private Categoria categoria = new Categoria();


	private CategoriaDAO categoriaDAO = new CategoriaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	private PontoTuristicoDAO dao = new PontoTuristicoDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	private final FacesContext context = FacesContext.getCurrentInstance();

	public List<PontoTuristico> getPontosCadastrados() {
		return dao.findAll();
	}

	public void criar() {
		System.out.println("Ponto turistico criado...");
	}

	public String editar() {
		try	{
			ponto = dao.save(ponto);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível atualizar os dados de ponto turistico", e.getMessage()));
			return "edit?faces-redirect=true";
		}
		context.getExternalContext().getSessionMap().put("ponto", ponto);
		return "edit?faces-redirect=true";
	}

	private void excluir() {
		try{
			dao.deleteById(ponto.getId());
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
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

	public List<Categoria> getCategorias(){
		return categoriaDAO.findAll();
	}
}
