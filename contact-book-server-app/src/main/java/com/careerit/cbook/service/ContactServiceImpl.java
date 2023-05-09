package com.careerit.cbook.service;

import com.careerit.cbook.dao.ContactDao;
import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.service.exception.ContactException;
import com.careerit.cbook.util.ContactUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

  private final ContactDao contactDao;

  @Override
  public ContactDto addContact(ContactDto contactDto) {
    Assert.notNull(contactDto.getName(), "Name can't be empty");
    Assert.notNull(contactDto.getEmail(), "Email can't be empty");
    Assert.notNull(contactDto.getMobile(), "Mobile can't be empty");
    if (contactDao.findByMobile(contactDto.getMobile()).isPresent()) {
      log.error("Contact with mobile number : {} already exists", contactDto.getMobile());
      throw new ContactException("Mobile number already exists");
    }
    Contact contact = ContactUtil.dtoToDomain(contactDto);
    contact = contactDao.insertContact(contact);
    contactDto = ContactUtil.domainToDto(contact);
    log.info("Contact with id : {} is added successfully", contactDto.getId());
    return contactDto;
  }

  @Override
  public ContactDto updateContact(ContactDto contactDto) {
    return null;
  }

  @Override
  public ContactDto removeContact(Long id) {
    return null;
  }

  @Override
  public ContactDto getContact(Long id) {
    return null;
  }

  @Override
  public List<ContactDto> getContacts() {
    List<Contact> contacts = contactDao.selectContacts();
    List<ContactDto> contactList = contacts.stream().map(ContactUtil::domainToDto).toList();
    log.info("Total contacts found : {}", contactList.size());
    return contactList;
  }

  @Override
  public List<ContactDto> search(String str) {
    return null;
  }
}
