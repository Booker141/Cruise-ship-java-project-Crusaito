package es.uca.gii.iw.crusaito.views;

import org.springframework.security.access.annotation.Secured;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@SuppressWarnings("serial")
@Route(value = "AdminView",layout = MainView.class)
@Secured("Admin")
public class AdminView extends VerticalLayout{

	public AdminView() {
		
		H1 Aviso = new H1("Bienvenido");

		add(Aviso);
	}

}
