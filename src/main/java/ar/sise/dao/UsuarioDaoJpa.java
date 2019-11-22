/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.dao;

import ar.sise.model.UserRole;
import ar.sise.model.Usuario;
import ar.sise.service.UsuarioService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LeaRC
 */
@Repository
public class UsuarioDaoJpa implements UsuarioDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    UsuarioService userService;
    
    public Usuario findByUserName(String username) {
        return (Usuario) entityManager.createNamedQuery("Usuario.findByUserName").setParameter("username", username).getSingleResult();
    }
    
    public boolean registrarUsuario(Usuario usuario) throws EmptyResultDataAccessException,NoResultException{
        
        if(!findIfExist(usuario.getUsername())){
             Set<UserRole> userRole = new HashSet<UserRole>();
                userRole.add(new UserRole(usuario,"ROLE_USER"));
                usuario.setUserRole(userRole);
            entityManager.persist(usuario);
            return true;
        }
        return false;
    }

    public void updateUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    public boolean findIfExist(String username) {
        if(entityManager.createNamedQuery("Usuario.findExists").setParameter("username", username).getResultList().size()>0){
            return true;
        }
        return false;
    }

}
