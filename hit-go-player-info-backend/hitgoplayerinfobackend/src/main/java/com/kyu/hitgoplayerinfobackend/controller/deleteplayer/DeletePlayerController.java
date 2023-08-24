package com.kyu.hitgoplayerinfobackend.controller.deleteplayer;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.service.deleteplayer.DeletePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DeletePlayerController {

    @Autowired
    DeletePlayerService deletePlayerService;
    @PostMapping(path = "/api/delete_player")
    public @ResponseBody SuccessMsgResponse deletePlayer(
            @RequestParam String name,
            @RequestParam String nativePlace
    ){
        return deletePlayerService.deletePlayer(name, nativePlace);
    }
}
