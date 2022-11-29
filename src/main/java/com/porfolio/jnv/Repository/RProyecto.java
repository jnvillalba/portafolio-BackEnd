package com.porfolio.jnv.Repository;

import com.porfolio.jnv.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer>{
    public Optional<Proyecto> findByNombreP(String nombreE);
    public boolean existsByNombreP(String nombreE);
}
