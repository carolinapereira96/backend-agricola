package com.agricola.backend.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agricola.backend.models.dao.IPredioDao;
import com.agricola.backend.models.entity.Predio;

@Service
public class PredioServiceImpl implements IPredioService {

	@Autowired
	private IPredioDao predioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Predio> findAll() {
		
		List<Predio> listPredios = (List<Predio>) predioDao.findAll();
		List<Predio> listPrediosFiltrada = new ArrayList<Predio>();
		
		for(int i=0; i < listPredios.size(); i++) {
			if(listPredios.get(i).isEstado()) {
				listPrediosFiltrada.add(listPredios.get(i));
			}
		}		
		return listPrediosFiltrada;
	}

	@Override
	@Transactional
	public Predio save(Predio predio) {
		predio.setEstado(true);
		return predioDao.save(predio);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		predioDao.findById(id).orElse(null).setEstado(false);
	}

	@Override
	@Transactional(readOnly = true)
	public Predio findById(Long id) {
		return predioDao.findById(id).orElse(null);
	}

}
