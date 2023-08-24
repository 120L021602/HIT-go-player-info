package com.kyu.hitgoplayerinfobackend.service.queryplayer;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.controller.queryplayer.response.QueryPlayerResponse;
import com.kyu.hitgoplayerinfobackend.dao.PlayerRepository;
import com.kyu.hitgoplayerinfobackend.entity.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QueryPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public QueryPlayerResponse queryPlayerInfo(String name){

//        Optional<Player> player = playerRepository.findByName(name);

        List<Player> playerList = playerRepository.findAllByName(name);

        if(playerList.isEmpty()){
            return new QueryPlayerResponse("查无此人");
        }

        QueryPlayerResponse queryPlayerResponse = new QueryPlayerResponse();
        queryPlayerResponse.setPlayerList(playerList);

        return queryPlayerResponse;
    }
}
