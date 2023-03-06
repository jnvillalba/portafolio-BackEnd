package com.porfolio.jnv.Security.Controller;

import com.porfolio.jnv.Security.Dto.JwtDto;
import com.porfolio.jnv.Security.Dto.LoginUsuario;
import com.porfolio.jnv.Security.Dto.NuevoUsuario;
import com.porfolio.jnv.Security.Entity.Role;
import com.porfolio.jnv.Security.Entity.Usuario;
import com.porfolio.jnv.Security.Enums.RoleNombre;
import com.porfolio.jnv.Security.Service.RoleService;
import com.porfolio.jnv.Security.Service.UsuarioService;
import com.porfolio.jnv.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"https://backend-jnvillalba.koyeb.app","http://localhost:4200"})
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEnconder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RoleService rolService;
    @Autowired
    JwtProvider jwtprovider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);
        
        if (usuarioService.exitsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Ya existe el nombre de usuario"), HttpStatus.BAD_REQUEST);
        
        if (usuarioService.exitsByEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("Ya existe el Email"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(),
                                        nuevoUsuario.getNombreUsuario(),
                                        nuevoUsuario.getEmail(),
                                        passwordEnconder.encode(nuevoUsuario.getPassword()));
        
        Set<Role> roles = new HashSet<>();
        roles.add(rolService.getByRoleNombre(RoleNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRoleNombre(RoleNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
        
        
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtprovider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
        
    }

}
