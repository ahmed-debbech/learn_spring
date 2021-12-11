package tn.esprit.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.springboot.entity.Rayon;

@Repository
public interface RayonRepository extends JpaRepository<Rayon, Long> {
}
