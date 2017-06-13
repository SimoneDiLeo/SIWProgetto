package progettoSiw.gallery.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import progettoSiw.gallery.model.Opera;

public interface OperaRepository  extends CrudRepository<Opera, Long> {

    List<Opera> findByTitolo(String titolo);

}