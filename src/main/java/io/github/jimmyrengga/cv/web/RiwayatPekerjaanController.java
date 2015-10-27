package io.github.jimmyrengga.cv.web;

import io.github.jimmyrengga.cv.domain.RiwayatPekerjaan;
import io.github.jimmyrengga.cv.service.RiwayatPekerjaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jimmy
 */
@RestController
@RequestMapping("/api/pekerjaan")
public class RiwayatPekerjaanController {
    
    @Autowired RiwayatPekerjaanService pekerjaanService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<RiwayatPekerjaan> viewAll() {
        return pekerjaanService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody RiwayatPekerjaan pekerjaan) {
        pekerjaanService.save(pekerjaan);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable String id) {
        RiwayatPekerjaan pekerjaan = pekerjaanService.findOne(id);
        if(pekerjaan == null) {
            throw new RuntimeException("RiwayatPekerjaan dengan id "+ id +" tidak ditemukan");
        }
        
        pekerjaanService.delete(pekerjaan);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id, @RequestBody RiwayatPekerjaan x){
        RiwayatPekerjaan pekerjaan = pekerjaanService.findOne(id);
        if(pekerjaan == null){
            throw new RuntimeException("RiwayatPekerjaan dengan id "+ id +" tidak ditemukan");
        }
        x.setId(id);
        pekerjaanService.save(x);
    }
    
}
