package progettoSiw.gallery.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import progettoSiw.gallery.model.Autore;

public interface AutoreRepository  extends CrudRepository<Autore, Long> {

    List<Autore> findByNome(String nome);

}
