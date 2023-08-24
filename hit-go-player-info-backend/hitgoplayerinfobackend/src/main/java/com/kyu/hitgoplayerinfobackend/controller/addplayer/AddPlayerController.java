package com.kyu.hitgoplayerinfobackend.controller.addplayer;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.dao.PlayerRepository;
import com.kyu.hitgoplayerinfobackend.service.addplayer.AddPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class AddPlayerController {

    @Autowired
    AddPlayerService addPlayerService;

    @PostMapping(path = "/api/add_player")
    public @ResponseBody SuccessMsgResponse addPlayer(
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String yearOfBirth,
            @RequestParam String school,
            @RequestParam String department,
            @RequestParam String major,
            @RequestParam String level,
            @RequestParam String nativePlace,
            @RequestParam String yhAccount,
            @RequestParam String comment
    ){
        return addPlayerService.addPlayer(
                name, gender, yearOfBirth, school, department,
                major, level, nativePlace, yhAccount, comment);
    }


}
