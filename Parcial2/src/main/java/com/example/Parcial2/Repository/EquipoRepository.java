package com.example.Parcial2.Repository;

import com.example.Parcial2.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    void deleteById(int id);

    boolean existsById(int id);
}
