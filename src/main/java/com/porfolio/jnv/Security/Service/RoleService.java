package com.porfolio.jnv.Security.Service;

import com.porfolio.jnv.Security.Entity.Role;
import com.porfolio.jnv.Security.Enums.RoleNombre;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.porfolio.jnv.Security.Repository.IRoleRepository;

@Service
@Transactional
public class RoleService {
    
    @Autowired
    IRoleRepository iRoleRepository;
    
    public Optional<Role> getByRoleNombre(RoleNombre rolNombre){
        return iRoleRepository.findByRoleNombre(rolNombre);
    }
    
    public void save(Role rol){
        iRoleRepository.save(rol);
    }
    
    
}
