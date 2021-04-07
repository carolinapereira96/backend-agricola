package com.agricola.backend.models.services;

import java.util.List;

import com.agricola.backend.models.entity.RegistroFitosanitario;

public interface IRegistroFitosanitarioService {
	
	public List <RegistroFitosanitario> findAll();
	
	public RegistroFitosanitario save(RegistroFitosanitario registroFitosanitario);

	public void delete(String id);

	public RegistroFitosanitario findById(String id);

}
