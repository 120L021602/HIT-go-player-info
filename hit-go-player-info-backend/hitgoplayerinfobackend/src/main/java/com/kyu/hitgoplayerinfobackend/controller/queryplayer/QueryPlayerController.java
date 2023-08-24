package com.kyu.hitgoplayerinfobackend.controller.queryplayer;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.controller.queryplayer.response.QueryPlayerResponse;
import com.kyu.hitgoplayerinfobackend.service.queryplayer.QueryPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class QueryPlayerController {

    @Autowired
    QueryPlayerService queryPlayerService;

    @PostMapping(path = "/api/query_player_info")
    public @ResponseBody QueryPlayerResponse queryPlayerInfo(@RequestParam String name){

        return queryPlayerService.queryPlayerInfo(name);
    }
}
