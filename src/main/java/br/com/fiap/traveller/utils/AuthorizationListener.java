package br.com.fiap.traveller.utils;

import br.com.fiap.traveller.entities.Usuario;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import java.util.Objects;

public class AuthorizationListener implements PhaseListener {
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String page = context.getViewRoot().getViewId();
        if (page.matches("^/(login|register).xhtml$")) {
            return;
        }

        Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("currentUser");
        if (Objects.isNull(usuario)){
            NavigationHandler nav = context.getApplication().getNavigationHandler();
            nav.handleNavigation(context, "", "login?faces-redirect=true");
        }

    }

    @Override
    public void beforePhase(PhaseEvent event) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
