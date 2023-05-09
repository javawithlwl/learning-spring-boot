package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ContactDaoTest {

  @Autowired
  private ContactDao contactDao;

  @BeforeEach
  public  void init() {
    contactDao.deleteContacts();
  }

  @Test
  void addContactTest() {
    Contact contact = getContact();
    Contact savedContact = contactDao.insertContact(contact);
    Assertions.assertNotEquals(0, savedContact.getId());
  }

  @Test
  void updateContactTest() {
    Contact contact = getContact();
    Contact savedContact = contactDao.insertContact(contact);
    savedContact.setName("Krishna");
    savedContact.setEmail("krishna@gmail.com");
    Contact updatedContact = contactDao.updateContact(savedContact);
    Assertions.assertEquals("Krishna", updatedContact.getName());
    Assertions.assertEquals("krishna@gmail.com", updatedContact.getEmail());
  }
  @Test
  void insertContactsTest() {
    List<Contact> contacts = getContacts();
    List<Contact> savedContacts = contactDao.insertContacts(contacts);
    Assertions.assertEquals(2, savedContacts.size());
  }
  @Test
  void searchTest() {
    List<Contact> contacts = getContacts();
    List<Contact> savedContacts = contactDao.insertContacts(contacts);
    List<Contact> searchedContacts = contactDao.search("sh.t");
    Assertions.assertEquals(1, searchedContacts.size());
  }


  private List<Contact> getContacts() {
    List<Contact> list = new ArrayList<>();
    Contact contact1 = new Contact();
    contact1.setName("Krish");
    contact1.setEmail("kirsh.t@gmail.com");
    contact1.setMobile("9876543210");
    Contact contact2 = new Contact();
    contact2.setName("Manoj");
    contact2.setEmail("manoj.pvn@gmail.com");
    contact2.setMobile("9876543210");
    list.add(contact1);
    list.add(contact2);
    return list;
  }
  private Contact getContact() {
    Contact contact = new Contact();
    contact.setName("Krish");
    contact.setEmail("krish@gmail.com");
    contact.setMobile("9876543210");
    return contact;
  }
}
