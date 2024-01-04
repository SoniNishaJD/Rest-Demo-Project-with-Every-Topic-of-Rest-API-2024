package com.nishasoni.Rest_Demo.controller;

import com.nishasoni.Rest_Demo.model.Vender;
import com.nishasoni.Rest_Demo.service.VenderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vender")
public class VenderController {

    VenderService service;

    public VenderController(VenderService service) {
        this.service = service;
    }

    //GET
    @GetMapping("{venderId}")
    public Vender getVendorDetails(@PathVariable("venderId") String venderId){

      //  return new Vender("C1","vender 1","Address One","xxxxx");
   return service.getVender(venderId);
    }

    @GetMapping("")
    public List<Vender> getAllVendorDetails(){

        //  return new Vender("C1","vender 1","Address One","xxxxx");
        return service.getAllVenders();
    }

    @PostMapping
    public String createVenderDetails(@RequestBody Vender vender){
        service.createVender(vender);
        return "Vender created Succussfully";
    }

    @PutMapping
    public String updateVenderDetails(@RequestBody Vender vender){
        service.updateVender(vender);
        return "Vender updated Succussfully";
    }

    @DeleteMapping("{venderId}")
    public String deleteVenderDetails(@PathVariable("venderId") String venderId){
        service.deleteVender(venderId);
        return "Vender Deleted Succussfully";
    }

}
