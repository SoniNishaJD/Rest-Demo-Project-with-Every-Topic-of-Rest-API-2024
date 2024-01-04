package com.nishasoni.Rest_Demo.service;

import com.nishasoni.Rest_Demo.model.Vender;

import java.util.List;

public interface VenderService {
    public String createVender(Vender vender);
    public String updateVender(Vender vender);
    public String deleteVender(String venderId);
    public Vender getVender(String venderId);
    public List<Vender> getAllVenders();
}
