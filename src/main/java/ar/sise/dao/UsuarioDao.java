/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.dao;

import ar.sise.model.Usuario;

/**
 *
 * @author LeaRC
 */
public interface UsuarioDao {
    
    Usuario findByUserName(String username);
    
    boolean findIfExist(String username);
    
    boolean registrarUsuario(Usuario usuario);
    
    void updateUsuario(Usuario usuario);
    
}
