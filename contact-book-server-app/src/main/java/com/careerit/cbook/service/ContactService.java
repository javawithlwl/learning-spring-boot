package com.careerit.cbook.service;

import com.careerit.cbook.dto.ContactDto;

import java.util.List;

public interface ContactService {

    ContactDto addContact(ContactDto contactDto);
    ContactDto updateContact(ContactDto contactDto);
    boolean removeContact(Long id);
    ContactDto getContact(Long id);
    List<ContactDto> getContacts();
    List<ContactDto> search(String str);
}
