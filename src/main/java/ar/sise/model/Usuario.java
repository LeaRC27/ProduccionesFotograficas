/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author LeaRC
 */
@Entity
@Table(name = "Usuario")
@NamedQueries({
		@NamedQuery(name="Usuario.findByUserName", query = "from Usuario WHERE username= :username"),
                @NamedQuery(name="Usuario.findExists", query = "select u from Usuario u WHERE u.username= :username")
})
public class Usuario {
    private String username;
    private String password;
    private boolean enabled;
    private Set<UserRole> userRole = new HashSet<UserRole>(0);

    public Usuario() {
    }

    public Usuario(String username, String password, boolean enabled) {
            this.username = username;
            this.password = password;
            this.enabled = enabled;
    }

    public Usuario(String username, String password,
            boolean enabled, Set<UserRole> userRole) {
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.userRole = userRole;
    }

    @Id
    @Column(name = "username", unique = true,
            nullable = false, length = 45)
    public String getUsername() {
            return this.username;
    }

    public void setUsername(String username) {
            this.username = username;
    }

    @Column(name = "password",
            nullable = false, length = 60)
    public String getPassword() {
            return this.password;
    }

    public void setPassword(String password) {
            this.password = password;
    }

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
            return this.enabled;
    }

    public void setEnabled(boolean enabled) {
            this.enabled = enabled;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    public Set<UserRole> getUserRole() {
            return this.userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
            this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", password=" + password + ", enabled=" + enabled + ", userRole=" + userRole + '}';
    }
    
    
}
