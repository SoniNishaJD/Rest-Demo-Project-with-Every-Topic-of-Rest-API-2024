package com.nishasoni.Rest_Demo.service;

import com.nishasoni.Rest_Demo.model.Vender;
import com.nishasoni.Rest_Demo.repository.VenderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenderServiceImpl implements VenderService{

    VenderRepository repository;

    public VenderServiceImpl(VenderRepository repository) {
        this.repository = repository;
    }

    @Override
    public String createVender(Vender vender) {
        repository.save(vender);
        return "Success";
    }

    @Override
    public String updateVender(Vender vender) {
        repository.save(vender);
        return "Success";
    }

    @Override
    public String deleteVender(String venderId) {
        repository.deleteById(venderId);
        return "Success";
    }

    @Override
    public Vender getVender(String venderId) {
        return repository.findById(venderId).get();
    }

    @Override
    public List<Vender> getAllVenders() {
        return repository.findAll();
    }
}
