package modelos;

public class Sesion {
    public static Sesion instancia;
    public String privilegio;
    public String nombre_usuario;

    public static Sesion getInstancia() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        
        return instancia;
    }
    
    public void restaurar_valores() {
        privilegio = null;
        nombre_usuario = null;
    }
    
    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }
    
    
}
