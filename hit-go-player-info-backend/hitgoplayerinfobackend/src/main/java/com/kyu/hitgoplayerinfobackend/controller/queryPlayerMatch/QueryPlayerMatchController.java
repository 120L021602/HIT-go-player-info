package com.kyu.hitgoplayerinfobackend.controller.queryPlayerMatch;

import com.kyu.hitgoplayerinfobackend.controller.queryPlayerMatch.response.QueryPlayerMatchResponse;
import com.kyu.hitgoplayerinfobackend.controller.queryPlayerMatch.response.QueryPlayerMatchResponse;
import com.kyu.hitgoplayerinfobackend.service.queryplayermatch.QueryPlayerMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QueryPlayerMatchController {

    @Autowired
    QueryPlayerMatchService queryPlayerMatchService;

    @PostMapping("/api/query_player_match")
    public @ResponseBody QueryPlayerMatchResponse queryPlayerMatch(@RequestParam String name){

        return queryPlayerMatchService.queryPlayerMatch(name);
    }
}
