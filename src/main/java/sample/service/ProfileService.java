package sample.service;

import java.util.ArrayList;
import java.util.List;
import sample.domain.Profile;

/**
 *
 * @author jimmy
 */
public class ProfileService {

    private final List<Profile> profileList = new ArrayList<Profile>();
    
    public List<Profile> getAllProfile() {
        return profileList;
    }
    
    public Profile getProfileByUsername(String username) {
        Profile selectedProfile = null;
        for (Profile profile : profileList) {
            if(profile.getUsername().equals(username)) {
                selectedProfile = profile;
            }
        }
        
        return selectedProfile;
    }
    
    public void saveProfile(Profile profile) {
        if(profile == null) {
            throw new RuntimeException("Profile must not be null");
        }
        
        profileList.add(profile);
    }
    
    public void deleteProfile(Profile profile) {
        if(profile == null) {
            throw new RuntimeException("Profile must not be null");
        }
        
        profileList.remove(profile);
    }
    
}
