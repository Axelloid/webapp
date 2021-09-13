package com.rentalcar.webapp.repository;

import com.rentalcar.webapp.entity.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Long> {

    @Query(value = "select * from prenotazioni where utente_id = ?1", nativeQuery = true)
    List<Prenotazioni> findAllByUtente(Long id);

    @Query
    Optional<Prenotazioni> findById(Long id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE Prenotazioni SET approved = TRUE where id = ?1")
    void approve(Long id);
}
