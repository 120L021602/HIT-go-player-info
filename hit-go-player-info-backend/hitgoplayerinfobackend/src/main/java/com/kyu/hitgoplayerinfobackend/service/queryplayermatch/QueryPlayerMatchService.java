package com.kyu.hitgoplayerinfobackend.service.queryplayermatch;

import com.kyu.hitgoplayerinfobackend.controller.queryPlayerMatch.objs.MatchNameAndRanking;
import com.kyu.hitgoplayerinfobackend.controller.queryPlayerMatch.response.QueryPlayerMatchResponse;
import com.kyu.hitgoplayerinfobackend.controller.queryPlayerMatch.response.QueryPlayerMatchResponse;
import com.kyu.hitgoplayerinfobackend.dao.SecondYdkjMatchRepository;
import com.kyu.hitgoplayerinfobackend.dao.ThirdYdkjMatchRepository;
import com.kyu.hitgoplayerinfobackend.entity.match.SecondYdkjMatch;
import com.kyu.hitgoplayerinfobackend.entity.match.ThirdYdkjMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QueryPlayerMatchService {

    @Autowired
    private ThirdYdkjMatchRepository thirdYdkjMatchRepository;

    @Autowired
    private SecondYdkjMatchRepository secondYdkjMatchRepository;

    public QueryPlayerMatchResponse queryPlayerMatch(String name){

        List<MatchNameAndRanking> playerMatchList = new ArrayList<>();

        //第三届“云度科技杯”比赛成绩
        MatchNameAndRanking matchNameAndRanking = new MatchNameAndRanking();

        Optional<ThirdYdkjMatch> player = thirdYdkjMatchRepository.findByName(name);

        if(player.isPresent()){

            matchNameAndRanking.setMatchName("第三届'云都科技杯'棋王争霸赛");

            matchNameAndRanking.setRanking((player.get().getRanking()));

            playerMatchList.add(matchNameAndRanking);
        }


//        System.out.println(playerMatchList);


        //首届届“云都科技杯”比赛成绩
        MatchNameAndRanking matchNameAndRanking2 = new MatchNameAndRanking();

        Optional<SecondYdkjMatch> secYdkjPlayer = secondYdkjMatchRepository.findByName(name);

        if(secYdkjPlayer.isPresent()){

            matchNameAndRanking2.setMatchName("首届'云都科技杯'棋王争霸赛");

            matchNameAndRanking2.setRanking(secYdkjPlayer.get().getRanking());

            playerMatchList.add(matchNameAndRanking2);
        }


//        System.out.println(playerMatchList);

        //

        QueryPlayerMatchResponse queryPlayerMatchResponse = new QueryPlayerMatchResponse();
        queryPlayerMatchResponse.setPlayerMatchList(playerMatchList);
        queryPlayerMatchResponse.setMsg("");
        queryPlayerMatchResponse.setSuccess(true);

        return queryPlayerMatchResponse;
    }
}
