/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.service;

import ar.sise.model.Album;
import ar.sise.model.Foto;
import java.util.List;

/**
 *
 * @author LeaRC
 */
public interface AlbumService {
    
    List<Album> getAlbums();
    
    Album getAlbumById(Long albumId);
    
    List<Foto> getFotosAlbum(Album album);
    
    void agregarFoto(String ubicacion, String nombre, Album album);
    
    void agregarFotos(String ubicacion, List<String> nombres, Album album);
    
    void save (Album album);
    
}
