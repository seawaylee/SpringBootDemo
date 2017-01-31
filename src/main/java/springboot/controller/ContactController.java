package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot.dao.ContactDao;
import springboot.model.Contact;

import java.util.List;
import java.util.Map;

/**
 * @author NikoBelic
 * @create 31/01/2017 01:31
 */
@Controller
@RequestMapping(value = "/contact")
public class ContactController
{
    @Autowired
    private ContactDao contactDao;

    /**
     * 联系人主页面,Get处理/contact/,映射到home视图
     * @Author NikoBelic
     * @Date 31/01/2017 01:36
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String,Object> model)
    {
        List<Contact> contacts = contactDao.findAll();
        model.put("contacts",contacts);
        return "home";
    }

    /**
     * 添加联系人后跳转到主页
     * @Author NikoBelic
     * @Date 31/01/2017 01:39
     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact)
    {
        contactDao.save(contact);
        return "redirect:/contact";
    }
}
