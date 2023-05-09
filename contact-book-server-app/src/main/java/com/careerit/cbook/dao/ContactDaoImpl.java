package com.careerit.cbook.dao;
import com.careerit.cbook.domain.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ContactDaoImpl implements ContactDao {

  private final JdbcTemplate jdbcTemplate;

  private static final String ADD_CONTACT = "insert into contact(name,email,mobile) values(?,?,?)";
  private static final String UPDATE_CONTACT = "update contact set name = ?,email = ?,mobile = ? where id = ?";
  private static final String DELETE_CONTACT = "delete from contact where id = ?";
  private static  final  String SELECT_CONTACT = "select id,name,email,mobile from contact where id = ?";
  private static  final  String SELECT_CONTACTS = "select id,name,email,mobile from contact";
  private static  final  String SEARCH_CONTACTS = "select id,name,email,mobile from contact where name like ? or email like ? or mobile like ?";
  private static final String DELETE_CONTACTS = "delete from contact";
  @Override
  public Contact insertContact(Contact contact) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(con -> {
      PreparedStatement ps = con.prepareStatement(ADD_CONTACT, new String[]{"id"});
      ps.setString(1, contact.getName());
      ps.setString(2, contact.getEmail());
      ps.setString(3, contact.getMobile());
      return ps;
    }, keyHolder);
    contact.setId(keyHolder.getKey().longValue());
    return contact;
  }

  @Override
  public Contact updateContact(Contact contact) {
    int count = jdbcTemplate.update(UPDATE_CONTACT, ps -> {
      ps.setString(1, contact.getName());
      ps.setString(2, contact.getEmail());
      ps.setString(3, contact.getMobile());
      ps.setLong(4, contact.getId());
    });
    if (count == 1) {
      return contact;
    } else {
      throw new RuntimeException("Contact with id :" + contact.getId() + " is not found");
    }

  }

  @Override
  public boolean deleteContact(Long id) {
    int count = jdbcTemplate.update(DELETE_CONTACT, ps -> {
      ps.setLong(1, id);
    });
    return count == 1;
  }

  @Override
  public Contact selectContact(Long id) {
    return jdbcTemplate.queryForObject(SELECT_CONTACT, new Object[]{id}, new ContactMapper());
  }

  @Override
  public List<Contact> selectContacts() {
    return jdbcTemplate.query(SELECT_CONTACTS, new ContactMapper());
  }

  @Override
  public List<Contact> search(String str) {
    return jdbcTemplate.query(SEARCH_CONTACTS, ps -> {
      ps.setString(1,"%"+str+"%");
      ps.setString(2,"%"+str+"%");
      ps.setString(3,"%"+str+"%");
    },new ContactMapper());
  }
  @Override
  public int deleteContacts(){
    return jdbcTemplate.update(DELETE_CONTACTS);
  }

  @Override
  public List<Contact> insertContacts(List<Contact> contacts){
    for(Contact contact:contacts){
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTemplate.update(con -> {
        PreparedStatement ps = con.prepareStatement(ADD_CONTACT, new String[]{"id"});
        ps.setString(1, contact.getName());
        ps.setString(2, contact.getEmail());
        ps.setString(3, contact.getMobile());
        return ps;
      }, keyHolder);
      contact.setId(keyHolder.getKey().longValue());
    }
    return contacts;
  }
  @Override
  public Optional<Contact> findByMobile(String mobile){
    List<Contact> contacts = jdbcTemplate.query("select id,name,email,mobile from contact where mobile = ?",ps -> {
      ps.setString(1,mobile);
    },new ContactMapper());
    if(contacts.size() == 1){
      return Optional.of(contacts.get(0));
    }else{
      return Optional.empty();
    }
  }
}
