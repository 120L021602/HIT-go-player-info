package com.kyu.hitgoplayerinfobackend.controller.admingeneral.response;

import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdminLoginResponse extends SuccessMsgResponse {

    private boolean isAdmin = true;

    public AdminLoginResponse(){
        super();
    }

    public AdminLoginResponse(String msg){
        super(msg);
    }
}
