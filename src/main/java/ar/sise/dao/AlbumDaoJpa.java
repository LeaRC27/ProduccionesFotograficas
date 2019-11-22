/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.dao;

import ar.sise.model.Album;
import ar.sise.model.Foto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LeaRC
 */
@Repository
public class AlbumDaoJpa implements AlbumDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Album> getAlbums() {
        return (List<Album>) entityManager.createNamedQuery("Album.findAll").getResultList();
    }

    public Album getAlbumById(Long album_Id) {
        return (Album) entityManager.createNamedQuery("Album.getAlbumbyId").setParameter("album_Id", album_Id).getSingleResult();
    }

    public List<Foto> getFotosAlbum(Album album) {
        return (List<Foto>) entityManager.createNamedQuery("Album.getFotos").setParameter("album_Id", album.getAlbum_Id()).getResultList();
    }

    public void agregarFoto(Foto foto) {
        entityManager.persist(foto);
    }

    public void agregarFotos(List<Foto> fotos) {
        for (Foto foto : fotos) {
            entityManager.persist(foto);
        }
    }
    
    public void save(Album album) {
        entityManager.persist(album);
    }
    
    
    
}
