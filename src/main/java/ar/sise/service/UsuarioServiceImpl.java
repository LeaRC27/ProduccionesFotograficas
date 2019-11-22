/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.service;

import ar.sise.dao.UsuarioDao;
import ar.sise.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LeaRC
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    UsuarioDao userDao;
    
    @Transactional
    public boolean registrarUser(Usuario usuario){
            return userDao.registrarUsuario(usuario);
        }
        @Transactional(readOnly = true)
        public Usuario findUserByName(String userName){
            return userDao.findByUserName(userName);
        }
        @Transactional
        public void updateUsuario(Usuario usuario){
            userDao.updateUsuario(usuario);
        }
        @Transactional(readOnly = true)
        public boolean findIfExist(Usuario usuario) {
            return userDao.findIfExist(usuario.getUsername());
        }
}
