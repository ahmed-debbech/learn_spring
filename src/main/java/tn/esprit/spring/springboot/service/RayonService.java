package tn.esprit.spring.springboot.service;

import tn.esprit.spring.springboot.entity.Rayon;

import java.util.List;

public interface RayonService {
    Rayon add(Rayon r);
    Rayon findById(Long id);
}
