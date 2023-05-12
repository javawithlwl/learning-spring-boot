package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ContactRepo extends JpaRepository<Contact, Long>  {
  @Query("select c from Contact c where c.name like %?1% or c.email like %?1% or c.mobile like %?1%")
  List<Contact> search(String str);

  Optional<Contact> findByMobile(String mobile);
}
