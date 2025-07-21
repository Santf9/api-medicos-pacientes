package com.medvoll.api.service;
import com.medvoll.api.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<Medico, Long> {


}
