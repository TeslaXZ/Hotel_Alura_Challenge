package com.latam.alura.hotel.dao;

import javax.persistence.EntityManager;

import com.latam.alura.hotel.modelo.NivelDeAcceso;
import com.latam.alura.hotel.modelo.Usuario;

/**
 * Esta clase proporciona métodos para acceder a la base de datos y realizar operaciones relacionadas con los usuarios.
 */
public class UsuarioDAO {

    private EntityManager em;

    /**
     * Constructor de la clase UsuarioDAO.
     * 
     * @param em El EntityManager utilizado para gestionar las operaciones de base de datos.
     */
    public UsuarioDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Crea un nuevo usuario en la base de datos.
     * 
     * @param nombre El nombre del usuario.
     * @param usuario El nombre de usuario (login) del usuario.
     * @param password La contraseña del usuario.
     * @param nivelDeAcceso El nivel de acceso del usuario.
     */
    public void nuevoUsuario(String nombre, String usuario, String password, NivelDeAcceso nivelDeAcceso) {
        Usuario user = new Usuario(nombre, usuario, password, nivelDeAcceso);
        em.getTransaction().begin();
        this.em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Verifica las credenciales del usuario para permitir el acceso al sistema.
     * 
     * @param usuario El nombre de usuario (login) del usuario.
     * @param password La contraseña del usuario.
     * @return `true` si las credenciales son correctas, `false` en caso contrario.
     */
    public boolean entrarAsistema(String usuario, String password) {
        String jpql = "SELECT u FROM Usuario u WHERE u.usuario = :usuario";
        em.getTransaction().begin();
        Usuario user = em.createQuery(jpql, Usuario.class).setParameter("usuario", usuario).getSingleResult();
        em.close();
        return user != null && user.getContraseña().equals(password);
    }

    /**
     * Obtiene un usuario a partir de su nombre de usuario (login) y contraseña.
     * 
     * @param usuario El nombre de usuario (login) del usuario.
     * @param password La contraseña del usuario.
     * @return El objeto Usuario si se encuentra en la base de datos, o `null` si no se encuentra.
     */
    public Usuario obtenerUsuario(String usuario, String password) {
        em.getTransaction().begin();
        String jpql = "SELECT u FROM Usuario u WHERE u.usuario = :usuario";
        Usuario user = em.createQuery(jpql, Usuario.class).setParameter("usuario", usuario).getSingleResult();
        em.close();
        return user;
    }

    /**
     * Verifica si es la primera vez que se ejecuta el programa, comprobando si existe un usuario con nivel de acceso 1 (presumiblemente, Administrador).
     * 
     * @return `true` si es la primera vez, `false` si ya existen usuarios en el sistema.
     */
    public boolean EsPrimeraVez() {
        String jpql = "SELECT COUNT(u) FROM Usuario u WHERE u.nivelDeAcceso.id = 1";
        em.getTransaction().begin();
        Long cuenta = em.createQuery(jpql, Long.class).getSingleResult();
        em.close();
        return cuenta == 0;
    }
}
