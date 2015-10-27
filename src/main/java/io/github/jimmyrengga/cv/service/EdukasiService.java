package io.github.jimmyrengga.cv.service;

import io.github.jimmyrengga.cv.domain.Edukasi;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author jimmy
 */
public interface EdukasiService extends PagingAndSortingRepository<Edukasi, Serializable>{
    
}
