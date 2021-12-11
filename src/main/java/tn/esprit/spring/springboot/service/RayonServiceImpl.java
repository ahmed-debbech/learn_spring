package tn.esprit.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.springboot.entity.Rayon;
import tn.esprit.spring.springboot.repository.RayonRepository;

import java.util.List;

@Service
public class RayonServiceImpl implements RayonService{

    @Autowired
    private RayonRepository rayonRepository;

    @Override
    public Rayon add(Rayon r) {
        return rayonRepository.save(r);
    }

    @Override
    public Rayon findById(Long id) {
        return rayonRepository.findById(id).orElse(null);
    }
}
