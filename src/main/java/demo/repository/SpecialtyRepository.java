package demo.repository;

import demo.model.Specialty;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface SpecialtyRepository extends PagingAndSortingRepository<Specialty, Long> {

}
