/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import manejo_datos.MUsuario;
import modelo.Usuario;

/**
 *
 * @author razie
 */
@Named(value = "acceso")
@SessionScoped
public class Acceso implements Serializable {
    @EJB
    private MUsuario mUsuarios;
    
    private List<Usuario> usuarios;
    private Usuario usuario;
    private String pagina = "";

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public void crearDatos() {
        usuarios = mUsuarios.usuarios();
    }
    
    public void crearUsuario() {
        usuario = new Usuario();
    }
    
    public void registrarUsuario() {
        mUsuarios.registrar(usuario);
        crearUsuario();
        crearDatos();
    }
    
    public boolean registrado() {
        return mUsuarios.autenticarUsuario(usuario) != null;
    }
    
    public String registroPersona() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        if(!registrado()) {
            
        }
        
        
        return null;
    }
    
    public boolean acceso() {
        return (usuario = mUsuarios.autenticarUsuario(usuario)) != null;
    }
    
    public String autenticarUsuario() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        if (acceso()) {
            pagina = "pagina_princiapl";
        }
        else {
            FacesMessage mjs = new FacesMessage("usuario o password invalido");
            contexto.addMessage(null, mjs);
            usuario = new Usuario();
            pagina = "index";
        }
        return pagina;
    }
    
    public String cerrarSesion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    
    /**
     * Creates a new instance of Acceso
     */
    public Acceso() {
    }
    
}
