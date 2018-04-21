package com.ye.web;

import com.ye.entity.User;
import com.ye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class WebController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page")
    public String page(HttpServletRequest request, ModelMap map) {
        List<User> list = userService.getAll();
        map.put("users", list);
        return "first";
    }
    @ResponseBody
    @RequestMapping(value = "/user/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }
}
