package org.tian.news.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserController {

    @ResponseBody
    @RequestMapping("login")
    public Map<String, String> login(){
        Map<String, String > map = new HashMap<>();
        map.put("token", "super_admin");
        return map;
    }

    @ResponseBody
    @RequestMapping("get_info")
    public Map<String, Object> getUserInfo(){
        /**
         *      name: 'super_admin',
         *     user_id: '1',
         *     access: ['super_admin', 'admin'],
         *     token: 'super_admin',
         *     avatar: 'https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png'
         */
        Map<String, Object > map = new HashMap<>();
        String[] sa = {"super_admin", "admin"};
        map.put("name", "super_admin");
        map.put("user_id", "1");
        map.put("access", sa);
        map.put("token", "super_admin");
        map.put("avatar", "https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png");
        return map;
    }
}
