/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.service;

import ar.sise.dao.ImageDao;
import ar.sise.model.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LeaRC
 */
@Service
public class ImageServiceImpl implements ImageService{
    
    @Autowired
    private ImageDao imageDao;
        
    public List<Image> list(){
        return imageDao.list();
    }
    
    public Image create(Image image){
        imageDao.create(image);
        return image;
    }
    
    public Image get(Long id){
        return imageDao.get(id);
    }
    
    public void delete(Image image){
        imageDao.delete(image);
    }
}
