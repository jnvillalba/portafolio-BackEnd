package com.porfolio.jnv.Controller;

import com.porfolio.jnv.Dto.dtoProyecto;
import com.porfolio.jnv.Entity.Proyecto;
import com.porfolio.jnv.Security.Controller.Mensaje;
import com.porfolio.jnv.Service.ProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://jnvfrontend.web.app","http://localhost:4200"})
public class ProyectoController {
    @Autowired
    ProyectoService sproyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sproyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id")int id){
        if(!sproyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sproyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sproyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sproyecto.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto){
        if(StringUtils.isBlank(dtoproyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sproyecto.existsByNombreP(dtoproyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(
                dtoproyecto.getNombreP(), dtoproyecto.getFecha(), dtoproyecto.getDescripcionP(),
                dtoproyecto.getLink(),dtoproyecto.getImg(),dtoproyecto.getRepo()
            );
        sproyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto){
        if(!sproyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sproyecto.existsByNombreP(dtoproyecto.getNombreP()) && sproyecto.getByNombreP(dtoproyecto.getNombreP()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sproyecto.getOne(id).get();
        
        proyecto.setNombreP(dtoproyecto.getNombreP());
        proyecto.setDescripcionP(dtoproyecto.getDescripcionP());
        proyecto.setFecha(dtoproyecto.getFecha());
        proyecto.setLink(dtoproyecto.getLink());
        proyecto.setImg(dtoproyecto.getImg());
        proyecto.setRepo(dtoproyecto.getRepo());
        
        sproyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    } 
}
