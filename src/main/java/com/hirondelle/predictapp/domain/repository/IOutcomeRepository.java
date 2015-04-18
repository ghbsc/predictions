package com.hirondelle.predictapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hirondelle.predictapp.domain.model.Outcome;

public interface IOutcomeRepository extends JpaRepository<Outcome, Integer> {
//	@Query("SELECT o FROM Outcome o WHERE o.text = :text")
//	Outcome findByText(@Param("text") String text);
}
