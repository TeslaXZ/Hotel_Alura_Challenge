package com.latam.alura.hotel.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.latam.alura.hotel.modelo.Huesped;
import com.latam.alura.hotel.modelo.Reserva;

/**
 * Esta clase proporciona métodos para acceder a la base de datos y realizar operaciones relacionadas con los huéspedes.
 */
public class HuespedDAO {

    private EntityManager em;

    /**
     * Constructor de la clase HuespedDAO.
     * 
     * @param em El EntityManager utilizado para gestionar las operaciones de base de datos.
     */
    public HuespedDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Guarda un nuevo huésped en la base de datos.
     * 
     * @param nombre            El nombre del huésped.
     * @param apellido          El apellido del huésped.
     * @param fechaDeNacimiento La fecha de nacimiento del huésped.
     * @param nacionalidad      La nacionalidad del huésped.
     * @param telefono          El número de teléfono del huésped.
     * @param reserva           La reserva a la que se asocia el huésped.
     */
    public void guardar(String nombre, String apellido, LocalDate fechaDeNacimiento, String nacionalidad,
            String telefono, Reserva reserva) {

        Huesped huesped = new Huesped(nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, reserva);
        em.getTransaction().begin();
        this.em.persist(huesped);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * Lista todos los huéspedes almacenados en la base de datos.
     * 
     * @return Un DefaultTableModel que contiene los datos de los huéspedes.
     */
    public DefaultTableModel listar() {

        em.getTransaction().begin();
        List<Huesped> listaHuespedes = em.createQuery("SELECT e FROM Huesped as e", Huesped.class).getResultList();
        Object[][] data = new Object[listaHuespedes.size()][];
        int i = 0;
        for (Huesped huesped : listaHuespedes) {
            data[i] = new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(),
                    huesped.getFechaDeNacimiento(), huesped.getNacionalidad(), huesped.getTelefono(),
                    huesped.getReserva().getId() };
            i++;
        }
        String[] columnas = { "Número de Huesped", "Nombre", "Apellido", "Fecha de Nacimiento", "Nacionalidad",
                "Telefono", "Número de Reserva" };
        DefaultTableModel modelo = new DefaultTableModel(data, columnas);
        em.close();

        return modelo;
    }

    /**
     * Modifica un huésped en la base de datos.
     * 
     * @param tablaHuespedes La tabla de huéspedes que muestra los datos.
     */
    public void modificar(JTable tablaHuespedes) {
        Integer filaSeleccionada = tablaHuespedes.getSelectedRow();
        Long id = (Long) tablaHuespedes.getValueAt(filaSeleccionada, 0);
        String nombreModificado = tablaHuespedes.getValueAt(filaSeleccionada, 1).toString();
        String apellidoModificado = tablaHuespedes.getValueAt(filaSeleccionada, 2).toString();
        String fechaNacimiento = tablaHuespedes.getValueAt(filaSeleccionada, 3).toString();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimientoModificada = LocalDate.parse(fechaNacimiento, dtf);
        String nacionalidadModificada = tablaHuespedes.getValueAt(filaSeleccionada, 4).toString();
        String Telefono = tablaHuespedes.getValueAt(filaSeleccionada, 5).toString();

        em.getTransaction().begin();
        Huesped huesped = em.find(Huesped.class, id);
        if (huesped != null) {
            huesped.setNombre(nombreModificado);
            huesped.setApellido(apellidoModificado);
            huesped.setFechaDeNacimiento(fechaNacimientoModificada);
            huesped.setNacionalidad(nacionalidadModificada);
            huesped.setTelefono(Telefono);
            em.merge(huesped);
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
        }

        em.close();
    }

    /**
     * Elimina un huésped de la base de datos.
     * 
     * @param id El ID del huésped a eliminar.
     */
    public void eliminar(Long id) {

        Huesped huesped = em.find(Huesped.class, id);
        if (huesped != null) {

            em.getTransaction().begin();
            em.remove(huesped);
            em.getTransaction().commit();
        }
        em.close();
    }

    /**
     * Busca huéspedes por número de reserva o apellido en la base de datos.
     * 
     * @param NumeroDeReserva El número de reserva a buscar.
     * @param apellido        El apellido del huésped a buscar.
     * @return Un DefaultTableModel que contiene los datos de los huéspedes encontrados.
     */
    public DefaultTableModel buscarPorNumeroDeReservaOApellido(Long NumeroDeReserva, String apellido) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Huesped> query = builder.createQuery(Huesped.class);
        Root<Huesped> from = query.from(Huesped.class);

        Predicate filtro = builder.and();

        if (apellido != null && !apellido.trim().isEmpty()) {
            filtro = builder.and(filtro, builder.equal(from.get("apellido"), apellido));
        }
        if (NumeroDeReserva != null && !(NumeroDeReserva == 0)) {
            filtro = builder.and(filtro, builder.equal(from.get("reserva"), NumeroDeReserva));
        }

        query = query.where(filtro);

        em.getTransaction().begin();
        List<Huesped> listaHuespedes = em.createQuery(query).getResultList();

        Object[][] data = new Object[listaHuespedes.size()][];
        int i = 0;
        for (Huesped huesped : listaHuespedes) {
            data[i] = new Object[] { huesped.getId(), huesped.getNombre(), huesped.getApellido(),
                    huesped.getFechaDeNacimiento(), huesped.getNacionalidad(), huesped.getTelefono(),
                    huesped.getReserva().getId() };
            i++;
        }
        String[] columnas = { "Número de Huesped", "Nombre", "Apellido", "Fecha de Nacimiento", "Nacionalidad",
                "Telefono", "Número de Reserva" };
        DefaultTableModel modelo = new DefaultTableModel(data, columnas);
        em.close();

        return modelo;
    }
}
