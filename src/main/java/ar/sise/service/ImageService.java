/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.service;

import ar.sise.model.Image;
import java.util.List;

/**
 *
 * @author LeaRC
 */
public interface ImageService {
    
    public List<Image> list();
    
    public Image create(Image image);
    
    public Image get(Long id);
    
    public void delete(Image image);
    
    
}
