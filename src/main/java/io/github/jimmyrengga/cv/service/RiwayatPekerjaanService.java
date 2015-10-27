package io.github.jimmyrengga.cv.service;

import io.github.jimmyrengga.cv.domain.RiwayatPekerjaan;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author jimmy
 */
public interface RiwayatPekerjaanService extends PagingAndSortingRepository<RiwayatPekerjaan, Serializable>{
    
}
