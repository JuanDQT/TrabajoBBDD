package demo.repository;

import demo.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by poo2 on 16/06/2015.
 */
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

}

