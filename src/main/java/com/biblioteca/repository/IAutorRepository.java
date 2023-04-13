package com.biblioteca.repository;

import com.biblioteca.model.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long>{
    @Query(value = "{call pa_buscar_autor(:buscar)}", nativeQuery = true)
    List<Autor> listarByParam(@Param("buscar") String buscar);
}
