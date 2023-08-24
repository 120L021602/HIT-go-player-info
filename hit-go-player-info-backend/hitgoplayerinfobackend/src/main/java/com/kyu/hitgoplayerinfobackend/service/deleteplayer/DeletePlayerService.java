package com.kyu.hitgoplayerinfobackend.service.deleteplayer;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.dao.PlayerRepository;
import com.kyu.hitgoplayerinfobackend.entity.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DeletePlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public SuccessMsgResponse deletePlayer(String name, String nativePlace){

        playerRepository.deleteByNameAndNativePlace(name, nativePlace);

        return new SuccessMsgResponse();
    }
}
