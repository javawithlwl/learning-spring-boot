package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Primary
@Repository
@RequiredArgsConstructor
public class ContactDaoJpaImpl implements  ContactDao{

  private final ContactRepo contactRepo;
  @Override
  public Contact insertContact(Contact contact) {
    return contactRepo.save(contact);
  }

  @Override
  public Contact updateContact(Contact contact) {
    return contactRepo.save(contact);
  }

  @Override
  public boolean deleteContact(Long id) {
    contactRepo.findById(id).ifPresent(contact -> contactRepo.delete(contact));
    return true;
  }

  @Override
  public Contact selectContact(Long id) {
      return contactRepo.findById(id).orElseThrow(()-> new RuntimeException("Contact with id :"+id+" is not found"));
  }

  @Override
  public List<Contact> selectContacts() {
    return contactRepo.findAll();
  }

  @Override
  public List<Contact> search(String str) {
    return contactRepo.search(str);
  }

  @Override
  public int deleteContacts() {
    long count = contactRepo.count();
    contactRepo.deleteAll();
    return (int)count;
  }

  @Override
  public List<Contact> insertContacts(List<Contact> contacts) {
    return contactRepo.saveAll(contacts);
  }

  @Override
  public Optional<Contact> findByMobile(String mobile) {
    return contactRepo.findByMobile(mobile);
  }
}
