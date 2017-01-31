package springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springboot.model.Contact;

import java.util.List;

/**
 * @author NikoBelic
 * @create 31/01/2017 01:32
 */
@Repository
public class ContactDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Contact> findAll()
    {
        return jdbcTemplate.query("select * from tb_contact", (rs, rowNum) -> {
            Contact contact = new Contact();
            contact.setId(rs.getLong(1));
            contact.setFirstName(rs.getString(2));
            contact.setLastName(rs.getString(3));
            contact.setPhoneNumber(rs.getString(4));
            contact.setEmailAddress(rs.getString(5));
            return contact;
        });
    }

    public void save(Contact contact)
    {
        jdbcTemplate.update("insert into tb_contact(firstName,lastName,phoneNumber,emailAddress) values(?,?,?,?)",
                contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress());
    }

}
