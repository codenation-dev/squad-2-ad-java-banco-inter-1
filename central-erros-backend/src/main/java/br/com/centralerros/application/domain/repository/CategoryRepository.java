package br.com.centralerros.application.domain.repository;

import br.com.centralerros.application.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Transactional
    @Query(value = "SELECT c.* FROM category c WHERE c.name like :category_name ", nativeQuery = true)
    Category findByName(@Param("category_name") String categoryName);


    @Transactional
    @Query(value = "SELECT c.* FROM category c WHERE c.name like :category_name AND application_id = :application_id", nativeQuery = true)
    Category findByNameEApplication(@Param("category_name") String categoryName, @Param("application_id") Long applicationId);

    @Override
    Optional<Category> findById(Long aLong);

    @Transactional
    @Query(value = "SELECT c.* FROM category c WHERE c.id like :id AND application_id = :application_id ", nativeQuery = true)
    Category findByIdEApplication(@Param("id") Long aLong, @Param("application_id") Long applicationId);

    @Override
    <S extends Category> S save(S s);
}
