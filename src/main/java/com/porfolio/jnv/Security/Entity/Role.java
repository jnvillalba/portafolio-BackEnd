package com.porfolio.jnv.Security.Entity;

import com.porfolio.jnv.Security.Enums.RoleNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
 
@Entity
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleNombre roleNombre;

    public Role() {
    }
    
    public Role(RoleNombre rolNombre) {
        this.roleNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleNombre getRoleNombre() {
        return roleNombre;
    }

    public void setRoleNombre(RoleNombre rolNombre) {
        this.roleNombre = rolNombre;
    }
    
    
    
    
    
}
