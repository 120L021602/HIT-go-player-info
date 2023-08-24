package com.kyu.hitgoplayerinfobackend.service.addplayer;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.dao.PlayerRepository;
import com.kyu.hitgoplayerinfobackend.entity.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class AddPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public SuccessMsgResponse addPlayer(
            String name,
            String gender,
            String yearOfBirth,
            String school,
            String department,
            String major,
            String level,
            String nativePlace,
            String yhAccount,
            String comment){

        Player player = new Player();

        Optional<Player> player1 = playerRepository.findByName(name);

        player.setName(name);
        player.setYearOfBirth(yearOfBirth);
        player.setGender(gender);
        player.setLevel(level);
        player.setDepartment(department);
        player.setSchool(school);
        player.setNativePlace(nativePlace);
        player.setMajor(major);
        player.setYhAccount(yhAccount);
        player.setComment(comment);

        playerRepository.save(player);

        return new SuccessMsgResponse();
    }
}
