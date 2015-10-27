package io.github.jimmyrengga.cv;

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
    public List<Profile> viewAll() {
        return profileService.getAllProfile();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{username}")
    public Profile viewByUsername(@PathVariable String username) {
        return profileService.getProfileByUsername(username);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void saveProfile(@RequestBody Profile profile) {
        profileService.saveProfile(profile);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{username}")
    public void deleteProfile(@PathVariable String username) {
        Profile profieToDelete = profileService.getProfileByUsername(username);
        
        profileService.deleteProfile(profieToDelete);
    }
}
