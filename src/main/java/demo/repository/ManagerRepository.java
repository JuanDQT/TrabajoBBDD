package demo.repository;

import demo.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by poo2 on 16/06/2015.
 */
public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {
    //public List<Manager> findBySurname(@Param("surname") String surname);
    //public List<Manager> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    //public List<Manager> findByDtIniBetween(@Param("start") Date start, @Param("end") Date end);
}
