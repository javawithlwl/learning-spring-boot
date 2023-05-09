package com.careerit.cbook.dto;

import com.careerit.cbook.domain.Contact;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {

    private Long id;
    private String name;
    private String email;
    private String mobile;


}
