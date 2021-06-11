package br.com.fiap.traveller.bean;


import br.com.fiap.traveller.entities.Usuario;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class UsuarioBean {

	
	private Usuario usuario = new Usuario();


	public String login() {
		
		String email = "joao@gmail.com";
		String senha = "123456";
		System.out.println("Usuário logando...");
		if (usuario.getEmail().equals(email) && usuario.getPassword().equals(senha)) {
			return "Sucesso";
		} else {
			return "usuário ou senha inválidos";
		}
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
