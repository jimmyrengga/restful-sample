package io.github.jimmyrengga.cv.web;

import io.github.jimmyrengga.cv.domain.Edukasi;
import io.github.jimmyrengga.cv.service.EdukasiService;
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
@RequestMapping("/api/edukasi")
public class EdukasiController {

    @Autowired EdukasiService edukasiService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Edukasi> viewAll() {
        return edukasiService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Edukasi edukasi) {
        edukasiService.save(edukasi);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable String id) {
        Edukasi edukasi = edukasiService.findOne(id);
        if(edukasi == null) {
            throw new RuntimeException("Edukasi dengan id "+ id +" tidak ditemukan");
        }
        
        edukasiService.delete(edukasi);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id, @RequestBody Edukasi x){
        Edukasi edukasi = edukasiService.findOne(id);
        if(edukasi == null){
            throw new RuntimeException("Edukasi dengan id "+ id +" tidak ditemukan");
        }
        x.setId(id);
        edukasiService.save(x);
    }
    
}
