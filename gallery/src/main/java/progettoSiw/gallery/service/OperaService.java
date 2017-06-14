package progettoSiw.gallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progettoSiw.gallery.model.Autore;
import progettoSiw.gallery.model.Opera;
import progettoSiw.gallery.repository.OperaRepository;

@Service
public class OperaService {

	@Autowired
	private OperaRepository OperaRepository; 

	public Iterable<Opera> findAll() {
		return this.OperaRepository.findAll();
	}

	@Transactional
	public void add(final Opera Opera) {
		this.OperaRepository.save(Opera);
	}

	public Opera findbyId(Long id) {
		return this.OperaRepository.findOne(id);
	}

	
	public Autore findAutoreOpera(long id ){
		return this.findbyId(id).getAutore();
	}

	public void rimuoviOpera(Long id) {
		this.OperaRepository.delete(id);	
	}
}