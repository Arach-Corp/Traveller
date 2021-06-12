package br.com.fiap.traveller.bean;


import br.com.fiap.traveller.dao.exceptions.CommitException;
import br.com.fiap.traveller.dao.generic.UsuarioDAO;
import br.com.fiap.traveller.dao.impl.UsuarioDAOImpl;
import br.com.fiap.traveller.entities.Usuario;
import br.com.fiap.traveller.sigleton.EntityManagerFactorySingleton;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Objects;

@Named
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private final FacesContext context = FacesContext.getCurrentInstance();
	private static final UsuarioDAO dao = new UsuarioDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());


	public String login() {
		ExternalContext externalContext = context.getExternalContext();
		final String password = usuario.getPassword();
		final String email = usuario.getEmail();

		if (Objects.nonNull(email) && Objects.nonNull(password)){
			usuario = dao.findByEmail(usuario.getEmail());
			if (Objects.isNull(usuario)){
				externalContext.getFlash().setKeepMessages(true);
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado", null));
				return "login?faces-redirect=true";
			}
			if (Objects.nonNull(usuario.getPassword()) && usuario.getPassword().equals(password)){
				externalContext.getSessionMap().put("currentUser", usuario);
				return "index?faces-redirect=true";
			}
		}
		externalContext.getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credênciais inválidas", null));
		return "login?faces-redirect=true";
	}

	public String logout() {
		context.getExternalContext().getSessionMap().clear();
		return "login?faces-redirect=true";
	}

	public String register() {
		usuario = dao.save(usuario);

		try{
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível realizar o cadastro", e.getMessage()));
			return "register?faces-redirect=true";
		}
		context.getExternalContext().getSessionMap().put("currentUser", usuario);
		return "index?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
