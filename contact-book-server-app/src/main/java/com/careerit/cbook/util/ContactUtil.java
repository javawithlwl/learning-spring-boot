package com.careerit.cbook.util;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.dto.ContactDto;

public final class ContactUtil {
    private ContactUtil(){

    }
  public static ContactDto domainToDto(Contact contact){
    ContactDto contactDto = new ContactDto();
    contactDto.setId(contact.getId());
    contactDto.setName(contact.getName());
    contactDto.setEmail(contact.getEmail());
    contactDto.setMobile(contact.getMobile());
    return contactDto;
  }
  public static Contact dtoToDomain(ContactDto contactDto){
    Contact contact = new Contact();
    contact.setId(contactDto.getId());
    contact.setName(contactDto.getName());
    contact.setEmail(contactDto.getEmail());
    contact.setMobile(contactDto.getMobile());
    return contact;
  }
}
