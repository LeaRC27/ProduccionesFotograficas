/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.dao;

import ar.sise.model.Album;
import ar.sise.model.Foto;
import java.util.List;

/**
 *
 * @author LeaRC
 */
public interface AlbumDao {
    
    List<Album> getAlbums();
    
    Album getAlbumById(Long album_Id);
    
    List<Foto> getFotosAlbum(Album album);
    
    void agregarFoto(Foto foto);
    
    void agregarFotos(List<Foto> fotos);
    
    void save (Album album);
    
}
