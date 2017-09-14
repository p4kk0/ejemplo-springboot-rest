package com.company.ejemplorest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.ejemplorest.mapper.EmpleoMapper;
import com.company.ejemplorest.model.Empleo;
import com.company.ejemplorest.repository.EmpleoRepository;
import com.company.ejemplorest.service.EmpleoService;

@Service("empleoServiceImpl")
public class EmpleoServiceImpl implements EmpleoService{
	
	@Autowired
	private EmpleoRepository empleoRepository;
	
	@Autowired
	private EmpleoMapper empleoMapper;

	@Override
	public List<Empleo> getEmpleos() {
		List<com.company.ejemplorest.entity.Empleo> empleos = empleoRepository.findAll();
		List<Empleo> empleosModel = new ArrayList<>();
		empleos.stream().forEach(t -> empleosModel.add(empleoMapper.fromEntity2Model(t)));
		return empleosModel;
	}

	@Override
	public Empleo buscarEmpleo(Integer idEmpleo) {
		Optional<com.company.ejemplorest.entity.Empleo> empleo = empleoRepository.findById(idEmpleo);
		return empleo.isPresent() ? empleoMapper.fromEntity2Model(empleo.get()) : null;
	}

	@Override
	public Empleo guardarEmpleo(Empleo empleo) {
		com.company.ejemplorest.entity.Empleo empleoEntity = (com.company.ejemplorest.entity.Empleo) empleoRepository.save(empleoMapper.fromModel2Entity(empleo));
		return empleoMapper.fromEntity2Model(empleoEntity);
	}

	@Override
	public Empleo actualizarEmpleo(Empleo empleo) {
		com.company.ejemplorest.entity.Empleo empleoEntity = (com.company.ejemplorest.entity.Empleo) empleoRepository.save(empleoMapper.fromModel2Entity(empleo));
		return empleoMapper.fromEntity2Model(empleoEntity);
	}

	@Override
	public void eliminarEmpleo(Integer idEmpleo) {
		Optional<com.company.ejemplorest.entity.Empleo> empleo =  empleoRepository.findById(idEmpleo);
		if(empleo.isPresent()){
			empleoRepository.delete(empleo.get());
		}
		
	}

	@Override
	public boolean isEmpleoExiste(int idEmpleo) {
		return empleoRepository.existsById(idEmpleo);
	}

	@Transactional
	@Override
	public List<Empleo> getEmpleosByIdPersona(Integer idPersona) {
		Stream<com.company.ejemplorest.entity.Empleo> empleos = empleoRepository.findEmpleoByIdPersona(idPersona);
		List<Empleo> empleosModel = new ArrayList<>();
		empleos.forEach(t -> empleosModel.add(empleoMapper.fromEntity2Model(t)));
		return empleosModel;
	}

	@Override
	public Empleo guardarEmpleoByPersona(Integer idPersona, Empleo empleo) {
		com.company.ejemplorest.entity.Empleo empleoEntity = empleoMapper.fromModel2Entity(empleo);
		empleoEntity.setPersona(new com.company.ejemplorest.entity.Persona(idPersona));
		empleoEntity = (com.company.ejemplorest.entity.Empleo) empleoRepository.save(empleoEntity);
		return empleoMapper.fromEntity2Model(empleoEntity);
	}

	@Transactional
	@Override
	public Empleo getEmpleoByIdPersonaAndIdEmpleo(Integer idPersona, Integer idEmpleo) {
		Optional<com.company.ejemplorest.entity.Empleo> empleo = empleoRepository.findEmpleoByIdPersonaAndIdEmpleo(idPersona, idEmpleo);
		return empleo.isPresent() ? empleoMapper.fromEntity2Model(empleo.get()) : null;
	}

}
