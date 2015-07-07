package demo.repository;

import demo.model.Review;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by poo2 on 16/06/2015.
 */
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

        Review findByProjectIdAndDeveloperIdAndSpecialtyId( Long idProject, Long idDeveloper, Long idSpecialty);

}

