package com.careerit.springdata.repo;

import com.careerit.springdata.domain.BaseEntity;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@NoRepositoryBean
public interface BaseEntityCurdRepository<T extends BaseEntity,ID> extends JpaRepository<T, ID> {


      @Query("select e from #{#entityName} e where e.deleted=false")
      List<T> findAll();

      @Transactional
      @Modifying
      @Query("update #{#entityName} e set e.deleted=true where e.id=:id")
      void deleteById(ID id);

      default void softDelete(T entity){
          deleteById((ID)entity.getId());
      }

}
