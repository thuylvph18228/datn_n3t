package com.poly.users.service.Iplm;

import com.poly.users.entity.Material;
import com.poly.users.repository.MaterialRepository;
import com.poly.users.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepo;

    @Override
    @Transactional
    public List<Material> getAll() {
        return this.materialRepo.findAll();
    }

    @Override
    @Transactional
    public Material getById(int MaterialId) {
        return null;
    }

    @Override
    @Transactional
    public Material save(Material material) {
        return this.materialRepo.save(material);
    }

    @Override
    @Transactional
    public Material update(Material material) {
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.materialRepo.deleteById(id);
    }
}
