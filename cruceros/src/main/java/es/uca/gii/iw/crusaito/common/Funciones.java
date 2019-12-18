package es.uca.gii.iw.crusaito.common;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;

import es.uca.gii.iw.crusaito.servicios.UsuarioService;

public class Funciones {
	
	public static void notificacionError(String cadena)
	{
		Notification notification = new Notification(cadena, 3000, Position.TOP_CENTER);
		notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
		notification.open();
	}
	
	public static void notificacionAcierto(String cadena)
	{
		Notification notification = new Notification(cadena, 3000, Position.TOP_CENTER);
		notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
		notification.open();
	}
	
	
	public static void clickListener(MenuItem A, String cadena)
	{
		A.addClickListener(e -> {
	    	A.getUI().ifPresent(ui-> ui.navigate(cadena));
	    });
	}
	
	public static void clickListener(Button A, String s)
	{
		A.addClickListener(e -> {
	    	A.getUI().ifPresent(ui-> ui.navigate(s));
	    });
	}
	
	public static void clickListener(Image A, String s)
	{
		A.addClickListener(e -> {
	    	A.getUI().ifPresent(ui-> ui.navigate(s));
	    });
	}

	public static boolean existeUsuario(UsuarioService servicio, String s)
	{
		if(servicio.findByUsername(s)!=null)
			return true;
		else
			return false;
	}
	
	public static boolean existeEmail(UsuarioService servicio, String s)
	{
		if(servicio.findByEmail(s)!=null)
			return true;
		else
			return false;
	}
	
	public static boolean existeDni(UsuarioService servicio, String s)
	{
		if(servicio.findByDni(s)!=null)
			return true;
		else
			return false;
	}
}
