package com.careerit.cbook.api;

import com.careerit.cbook.dto.AppResponseMessage;
import com.careerit.cbook.dto.ContactDto;
import com.careerit.cbook.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
@RequiredArgsConstructor
public class ContactController {

  private final ContactService contactService;

  @GetMapping("/list")
  public ResponseEntity<List<ContactDto>> getContacts(){
    return ResponseEntity.ok(contactService.getContacts());
  }
  @PostMapping
  public ResponseEntity<ContactDto> addContact(@RequestBody ContactDto contactDto){
    return ResponseEntity.ok(contactService.addContact(contactDto));
  }
  @PutMapping
  public ResponseEntity<ContactDto> updateContact(@RequestBody ContactDto contactDto){
    return ResponseEntity.ok(contactService.updateContact(contactDto));
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<AppResponseMessage> removeContact(@PathVariable("id") Long id){
    boolean isDeleted = contactService.removeContact(id);
    if(isDeleted){
      return ResponseEntity.ok(AppResponseMessage.builder().message("Contact is deleted successfully").build());
    }else{
      return ResponseEntity.ok(AppResponseMessage.builder().message("Contact is not deleted").build());
    }
  }
  @GetMapping("/{id}")
  public ResponseEntity<ContactDto> getContact(@PathVariable("id") Long id){
    return ResponseEntity.ok(contactService.getContact(id));
  }
  @GetMapping("/search/{str}")
  public ResponseEntity<List<ContactDto>> search(@PathVariable("str") String str){
    return ResponseEntity.ok(contactService.search(str));
  }

}
