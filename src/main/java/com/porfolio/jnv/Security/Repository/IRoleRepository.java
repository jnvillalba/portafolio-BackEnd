/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.jnv.Security.Repository;

import com.porfolio.jnv.Security.Entity.Role;
import com.porfolio.jnv.Security.Enums.RoleNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRoleNombre(RoleNombre rolNombre);
    
}
