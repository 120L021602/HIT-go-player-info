package com.kyu.hitgoplayerinfobackend.controller.updateplayer;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.service.updateplayer.UpdatePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UpdatePlayerController {

    @Autowired
    UpdatePlayerService updatePlayerService;

    @PostMapping(path = "/api/update_player_info")
    public @ResponseBody SuccessMsgResponse updatePlayerInfo(
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

        return updatePlayerService.updatePlayerInfo(name, gender, yearOfBirth, school,
                department, major, level, nativePlace, yhAccount, comment);

    }
}
