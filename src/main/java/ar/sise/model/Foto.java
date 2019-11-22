/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author LeaRC
 */
@Entity
@NamedQueries({
		@NamedQuery(name="Foto.findAll", query = "from Foto"),
                @NamedQuery(name="Phone.findFotoById", query = "FROM Foto WHERE foto_Id = :foto_Id")
})
public class Foto implements Serializable{
    
    @Id
    @GeneratedValue
    private Long foto_Id;
    @JsonView
    private String ubicacion;
    @JsonView
    private String nombre;
    @JsonView
    private String comentario;
    @ManyToOne
    @JoinColumn(name="album_Id")
    @JsonView
    @JsonBackReference
    private Album album;

    public Foto() {
    }

    public Foto(String ubicacion, String nombre) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
    }

    public Foto(String ubicacion, String nombre, Album album) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.album = album;
    }
    
    public Foto(String ubicacion, String nombre, String comentario, Album album) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.comentario = comentario;
        this.album = album;
    }

    public Long getFoto_Id() {
        return foto_Id;
    }

    public void setFoto_Id(Long foto_Id) {
        this.foto_Id = foto_Id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
   
    
    
   
}
