package com.porfolio.jnv.Service;

import com.porfolio.jnv.Entity.Proyecto;
import com.porfolio.jnv.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    
    @Autowired
    RProyecto rProyecto;
    
    public List<Proyecto> list(){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombreP(String nombre){
        return rProyecto.findByNombreP(nombre);
    }
    
    public void save(Proyecto educacion){
        rProyecto.save(educacion);
    }
    
    public void delete(int id){
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyecto.existsById(id);
    }
    
    public boolean existsByNombreP(String nombre){
        return rProyecto.existsByNombreP(nombre);
    }
    
}
