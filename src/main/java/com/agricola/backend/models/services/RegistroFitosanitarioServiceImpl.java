package com.agricola.backend.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agricola.backend.models.dao.IRegistroFitosanitarioDao;
import com.agricola.backend.models.entity.RegistroFitosanitario;

@Service
public class RegistroFitosanitarioServiceImpl implements IRegistroFitosanitarioService {

	@Autowired
	private IRegistroFitosanitarioDao registroFitosanitarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<RegistroFitosanitario> findAll() {
		return (List<RegistroFitosanitario>) registroFitosanitarioDao.findAll();
	}

	@Override
	@Transactional
	public RegistroFitosanitario save(RegistroFitosanitario registroFitosanitario) {
		return registroFitosanitarioDao.save(registroFitosanitario);
	}

	@Override
	@Transactional
	public void delete(String run) {
		registroFitosanitarioDao.deleteById(run);

	}

	@Override
	@Transactional(readOnly = true)
	public RegistroFitosanitario findById(String run) {
		return registroFitosanitarioDao.findById(run).orElse(null);
	}

}
