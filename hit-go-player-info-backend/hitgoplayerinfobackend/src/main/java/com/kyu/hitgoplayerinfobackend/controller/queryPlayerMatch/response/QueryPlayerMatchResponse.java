package com.kyu.hitgoplayerinfobackend.controller.queryPlayerMatch.response;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.controller.queryPlayerMatch.objs.MatchNameAndRanking;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryPlayerMatchResponse extends SuccessMsgResponse {

    //返回的比赛成绩,封装在一个列表里
    private List<MatchNameAndRanking> playerMatchList;

    public QueryPlayerMatchResponse(){
        super();
    }

    public QueryPlayerMatchResponse(String msg){
        super(msg);
    }
}
