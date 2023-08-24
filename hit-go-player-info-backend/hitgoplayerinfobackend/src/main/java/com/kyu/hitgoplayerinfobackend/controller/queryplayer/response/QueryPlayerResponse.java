package com.kyu.hitgoplayerinfobackend.controller.queryplayer.response;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.entity.player.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class QueryPlayerResponse extends SuccessMsgResponse{

    private List<Player> playerList;

    public QueryPlayerResponse() { super(); }

    public QueryPlayerResponse(String msg) { super(msg); }
}
