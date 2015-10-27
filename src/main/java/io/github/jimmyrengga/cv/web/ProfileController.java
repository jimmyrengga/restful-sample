package io.github.jimmyrengga.cv.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.github.jimmyrengga.cv.domain.Profile;
import io.github.jimmyrengga.cv.service.ProfileService;

/**
 *
 * @author jimmy
 */
@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired ProfileService profileService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Profile> viewAll() {
        return profileService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public Profile viewByUsername(@PathVariable String username) {
        return profileService.findProfileByUsername(username);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void saveProfile(@RequestBody Profile profile) {
        profileService.save(profile);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteProfile(@PathVariable String id) {
        Profile profieToDelete = profileService.findOne(id);
        if(profieToDelete == null) {
            throw new RuntimeException("Profile dengan id "+ id +" tidak ditemukan");
        }
        
        profileService.delete(profieToDelete);
    }
}
