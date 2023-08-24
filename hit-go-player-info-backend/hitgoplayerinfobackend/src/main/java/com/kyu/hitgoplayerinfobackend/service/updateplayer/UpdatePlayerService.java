package com.kyu.hitgoplayerinfobackend.service.updateplayer;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.dao.PlayerRepository;
import com.kyu.hitgoplayerinfobackend.entity.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Service
public class UpdatePlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    //用户仅填写姓名、性别、出生年份和需要修改的字段即可
    public SuccessMsgResponse updatePlayerInfo(
            String name,
            String gender,
            String yearOfBirth,
            String school,
            String department,
            String major,
            String level,
            String nativePlace,
            String yhAccount,
            String comment
    ){

        Optional<Player> player = playerRepository.findByNameAndGenderAndYearOfBirth(name, gender, yearOfBirth);

        if(!player.isPresent()){
            return new SuccessMsgResponse("查无此人，请先先添加棋手信息");
        }

        if(!school.equals("")){
            player.get().setSchool(school);
        }

        if(!department.equals("")){
            player.get().setDepartment(department);
        }

        if(!major.equals("")){
            player.get().setMajor(major);
        }

        if(!level.equals("")){
            player.get().setLevel(level);
        }

        if(!nativePlace.equals("")){
            player.get().setNativePlace(nativePlace);
        }

        if(!yhAccount.equals("")){
            player.get().setYhAccount(yhAccount);
        }

        if(!comment.equals("")){
            player.get().setComment(comment);
        }

        playerRepository.save(player.get());

        return new SuccessMsgResponse();
    }
}
