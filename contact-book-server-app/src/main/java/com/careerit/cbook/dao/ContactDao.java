package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {

  Contact insertContact(Contact contact);
  Contact updateContact(Contact contact);
  boolean deleteContact(Long id);
  Contact selectContact(Long id);
  List<Contact> selectContacts();
  List<Contact> search(String str);
  int deleteContacts();
  List<Contact> insertContacts(List<Contact> contacts);
  Optional<Contact> findByMobile(String mobile);
}
