/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.controller;

import ar.sise.model.Image;
import ar.sise.service.AlbumService;
import ar.sise.service.ImageService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author LeaRC
 */
@Controller
public class AlbumController {
    
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ImageService imageService;
        
    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String albumPage(ModelMap map) {
        return "album";
    }
            
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public @ResponseBody Map list() {
        
        List<Image> list = imageService.list();
        for(Image image : list) {
            image.setUrl("/ProduccionesFotograficas/picture/"+image.getId());
            image.setThumbnailUrl("/ProduccionesFotograficas/thumbnail/"+image.getId());
            image.setDeleteUrl("/ProduccionesFotograficas/delete/"+image.getId());
            image.setDeleteType("DELETE");
        }
        Map<String, Object> files = new HashMap();
        files.put("files", list);
       
        return files;
    }
    
    @RequestMapping(value = "/{upload}", method = RequestMethod.POST)
    public @ResponseBody Map upload(MultipartHttpServletRequest request, HttpServletResponse response, HttpServletRequest request2) {
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        List<Image> list = new LinkedList();
        
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            
            
            String newFilenameBase = UUID.randomUUID().toString();
            String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
            String newFilename = newFilenameBase + originalFileExtension;
            String storageDirectory = "c:/temp";
            String contentType = mpf.getContentType();
            
                       
            File newFile = new File(storageDirectory + "/" + newFilename);
            try {
                mpf.transferTo(newFile);
                
                BufferedImage thumbnail = Scalr.resize(ImageIO.read(newFile), 150);
                String thumbnailFilename = newFilenameBase + "-thumbnail.png";
                File thumbnailFile = new File(storageDirectory + "/" + thumbnailFilename);
                ImageIO.write(thumbnail, "png", thumbnailFile);
                
                Image image = new Image();
                image.setName(mpf.getOriginalFilename());
                image.setThumbnailFilename(thumbnailFilename);
                image.setNewFilename(newFilename);
                image.setContentType(contentType);
                image.setSize(mpf.getSize());
                image.setThumbnailSize(thumbnailFile.length());
                image = imageService.create(image);
                
                image.setUrl("/ProduccionesFotograficas/picture/"+image.getId());
                image.setThumbnailUrl("/ProduccionesFotograficas/thumbnail/"+image.getId());
                image.setDeleteUrl("/ProduccionesFotograficas/delete/"+image.getId());
                image.setDeleteType("DELETE");
                
                list.add(image);
                
            } catch(IOException e) {
//                log.error("Could not upload file "+mpf.getOriginalFilename(), e);
            }
            
        }
        
        Map<String, Object> files = new HashMap();
        files.put("files", list);
        return files;
    }
    
    @RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
    public void picture(HttpServletResponse response, @PathVariable Long id) {
        Image image = imageService.get(id);
        File imageFile = new File("c:/temp"+"/"+image.getNewFilename());
        response.setContentType(image.getContentType());
        response.setContentLength(image.getSize().intValue());
        try {
            InputStream is = new FileInputStream(imageFile);
            IOUtils.copy(is, response.getOutputStream());
        } catch(IOException e) {
//            log.error("Could not show picture "+id, e);
        }
    }
    
    @RequestMapping(value = "/thumbnail/{id}", method = RequestMethod.GET)
    public void thumbnail(HttpServletResponse response, @PathVariable Long id) {
        Image image = imageService.get(id);
        File imageFile = new File("c:/temp"+"/"+image.getThumbnailFilename());
        response.setContentType(image.getContentType());
        response.setContentLength(image.getThumbnailSize().intValue());
        try {
            InputStream is = new FileInputStream(imageFile);
            IOUtils.copy(is, response.getOutputStream());
        } catch(IOException e) {
//            log.error("Could not show thumbnail "+id, e);
        }
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody List delete(@PathVariable Long id, HttpServletRequest request) {
        Image image = imageService.get(id);
        
        File imageFile = new File("c:/temp"+"/"+image.getNewFilename());
        //System.out.println(image.getNewFilename());
        File thumbnailFile = new File("c:/temp"+"/"+image.getThumbnailFilename());
        //System.out.println(image.getThumbnailFilename());
        imageService.delete(image);
        
        thumbnailFile.delete();
        imageFile.delete();
                
        List<Map<String, Object>> results = new ArrayList();
        Map<String, Object> success = new HashMap();
        success.put("success", true);
        results.add(success);
        return results;
    }
    
    public void crearCarpetaDestino(String path){
        File directionTemp = new File(path);
	// Make Folder
	if (!directionTemp.exists()) {
            directionTemp.mkdirs();
        }
    }
    
    
}
