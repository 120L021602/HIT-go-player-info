package com.kyu.hitgoplayerinfobackend.controller.admingeneral;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.dao.AdminRepository;
import com.kyu.hitgoplayerinfobackend.service.admingeneralservice.AdminGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AdminGeneralController {

    @Autowired
    AdminGeneralService adminGeneralService;

    @PostMapping(path = "/api/admin/login")
    public @ResponseBody SuccessMsgResponse adminLogIn(
            @RequestParam String username,
            @RequestParam String password
    ){
        return adminGeneralService.logIn(username, password);
    }

    @PostMapping(path = "/api/admin/create")
    public @ResponseBody SuccessMsgResponse adminCreate(@RequestParam String username, @RequestParam String password){
        return adminGeneralService.createAdmin(username, password);
    }

    @PostMapping(path = "/api/admin/change_pw")
    public @ResponseBody SuccessMsgResponse changePw(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String newPassword
    ){
        return adminGeneralService.changePw(username, password, newPassword);
    }

}
