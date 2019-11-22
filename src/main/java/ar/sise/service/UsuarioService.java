/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.service;

import ar.sise.model.Usuario;

/**
 *
 * @author LeaRC
 */
public interface UsuarioService {
    
    boolean registrarUser(Usuario usuario);
            
    Usuario findUserByName(String userName);
    
    void updateUsuario(Usuario usuario);
    
    boolean findIfExist(Usuario usuario);
}
