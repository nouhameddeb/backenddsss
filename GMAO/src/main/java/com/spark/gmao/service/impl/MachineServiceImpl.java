package com.spark.gmao.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.spark.gmao.exception.MachineNotFoundException;
import com.spark.gmao.model.entity.Machine;
import com.spark.gmao.repository.MachineRepository;
import com.spark.gmao.service.MachineService;
@Service
public class MachineServiceImpl implements MachineService{
	
	@Autowired
	private MachineRepository machineRepository;
	
	@Override
	public Machine getMachine(Long idM) {
		Machine machine = machineRepository.findOne(idM);
		if(machine == null) {
			throw new MachineNotFoundException();
		}
		return machine;
	}
	
	@Override
	public List<Machine> getAllMachine() {
		return (List<Machine>) machineRepository.findAll();
	}
	
	@Transactional
	@Override
	public Machine saveMachine(Machine machine) {
		return machineRepository.save(machine);
	}

	@Override
	public void deleteMachine(Long idM) {
		try {
			machineRepository.delete(idM);
		} catch (EmptyResultDataAccessException e) {
			throw new MachineNotFoundException();
		}
	}
}
