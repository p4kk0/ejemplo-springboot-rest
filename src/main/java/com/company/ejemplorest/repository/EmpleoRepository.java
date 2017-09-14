package com.company.ejemplorest.repository;

import java.io.Serializable;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.ejemplorest.entity.Empleo;

@Repository
public interface EmpleoRepository extends JpaRepository<Empleo, Serializable> {

	@Query("select e from Empleo e where e.persona.id = :idPersona")
	Stream<Empleo> findEmpleoByIdPersona(@Param("idPersona") Integer idPersona);
	
	@Query("select e from Empleo e where e.persona.id = :idPersona and e.idEmpleo = :idEmpleo")
	Optional<Empleo> findEmpleoByIdPersonaAndIdEmpleo(@Param("idPersona") Integer idPersona, @Param("idEmpleo") Integer idEmpleo);

}
