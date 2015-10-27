package io.github.jimmyrengga.cv.service;

import io.github.jimmyrengga.cv.domain.Profile;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author jimmy
 */
public interface ProfileService extends PagingAndSortingRepository<Profile, Serializable>  {

    Profile findProfileByUsername(String username);
    
}
