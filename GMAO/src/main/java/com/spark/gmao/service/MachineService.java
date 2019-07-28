package com.spark.gmao.service;

import java.util.List;

import com.spark.gmao.model.entity.Machine;

public interface MachineService {


	Machine getMachine(Long idM);

	List<Machine> getAllMachine();

	Machine saveMachine(Machine machine);

	void deleteMachine(Long idM);


}
