package com.careerit.cbook.dao;

import com.careerit.cbook.domain.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {
  @Override
  public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
    Contact contact = new Contact();
    contact.setId(rs.getLong("id"));
    contact.setName(rs.getString("name"));
    contact.setEmail(rs.getString("email"));
    contact.setMobile(rs.getString("mobile"));
    return contact;
  }
}
