/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.service;

import ar.sise.dao.AlbumDao;
import ar.sise.model.Album;
import ar.sise.model.Foto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LeaRC
 */
@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumDao albumDao;
    
    @Transactional(readOnly = true)
    public List<Album> getAlbums() {
        return albumDao.getAlbums();
    }

    @Transactional(readOnly = true)
    public Album getAlbumById(Long album_Id) {
        return albumDao.getAlbumById(album_Id);
    }

    @Transactional(readOnly = true)
    public List<Foto> getFotosAlbum(Album album) {
        return albumDao.getFotosAlbum(album);
    }

    @Transactional
    public void agregarFoto(String ubicacion, String nombre, Album album) {
        Foto foto = new Foto(ubicacion, nombre, album);
        albumDao.agregarFoto(foto);
    }

    @Transactional
    public void agregarFotos(String ubicacion, List<String> nombres, Album album) {
        List<Foto> fotos = new ArrayList();
        for (String nombre : nombres) {
            Foto foto = new Foto(ubicacion, nombre, album);
            fotos.add(foto);
        }
        albumDao.agregarFotos(fotos);
    }
    
    @Transactional
    public void save(Album album) {
        albumDao.save(album);
    }
    
}
