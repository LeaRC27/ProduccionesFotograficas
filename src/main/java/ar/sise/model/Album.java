/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author LeaRC
 */
@Entity
@NamedQueries({
		@NamedQuery(name="Album.findAll", query = "from Album"),
                @NamedQuery(name="Album.getAlbumbyId", query = "from Album WHERE album_Id = :album_Id "),
                @NamedQuery(name="Album.getFotos", query = "from Foto WHERE album_Id = :album_Id")
})
public class Album {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long album_Id;
    @JsonView
    private String nombre;
    @JsonView
    private String descripcion;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "album" , orphanRemoval=true)
    @JsonView
    @JsonManagedReference
    private List<Foto> fotos;

    public Album() {
    }

    public Album(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Album(String nombre, String descripcion, List<Foto> fotos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
    }

    public Long getAlbum_Id() {
        return album_Id;
    }

    public void setAlbum_Id(Long album_Id) {
        this.album_Id = album_Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) throws JsonProcessingException, IOException{
        ObjectMapper mapper = new ObjectMapper();
            List<Foto> listOfDtos = fotos;
            String jsonArray = mapper.writeValueAsString(listOfDtos);
            
            List<Foto> fotos1 = mapper.readValue(jsonArray, mapper.getTypeFactory().constructCollectionType(
                    List.class, Foto.class));
        this.fotos = fotos1;
    }
    
    
}