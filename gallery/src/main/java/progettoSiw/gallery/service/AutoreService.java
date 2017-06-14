package progettoSiw.gallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progettoSiw.gallery.model.Autore;
import progettoSiw.gallery.model.Opera;
import progettoSiw.gallery.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository; 

	public Iterable<Autore> findAll() {
		return this.autoreRepository.findAll();
	}

	@Transactional
	public void add(final Autore Autore) {
		this.autoreRepository.save(Autore);
	}

	public Autore findbyId(Long id) {
		return this.autoreRepository.findOne(id);
	}

	public Iterable<Opera> findAllOpereAutore(Long id){
		Autore a = this.autoreRepository.findOne(id);
		return a.getOpere();
	}
	
	public void rimuoviAutore(long id){
		this.autoreRepository.delete(id);
	}

}