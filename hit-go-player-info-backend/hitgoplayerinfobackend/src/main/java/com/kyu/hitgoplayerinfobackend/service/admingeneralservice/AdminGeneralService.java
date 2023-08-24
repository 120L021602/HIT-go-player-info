package com.kyu.hitgoplayerinfobackend.service.admingeneralservice;

import com.kyu.hitgoplayerinfobackend.controller.admingeneral.response.AdminLoginResponse;
import com.kyu.hitgoplayerinfobackend.controller.common.response.SuccessMsgResponse;
import com.kyu.hitgoplayerinfobackend.dao.AdminRepository;
import com.kyu.hitgoplayerinfobackend.dao.SpecialListRepository;
import com.kyu.hitgoplayerinfobackend.entity.admin.Admin;
import com.kyu.hitgoplayerinfobackend.entity.speciallist.SpecialList;
import com.kyu.hitgoplayerinfobackend.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;
import java.util.Random;

@Service
public class AdminGeneralService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private SpecialListRepository specialListRepository;

    public boolean checkPw(Admin admin, String password){
        return HashUtil.checkBCrypt(password, admin.getPwHashed());
    }

    public AdminLoginResponse logIn(String username, String password){

        Optional<Admin> admin = adminRepository.findByUsername(username);

        if(!admin.isPresent()){
            return new AdminLoginResponse("用户名不存在");
        }

        if(checkPw(admin.get(), password)){
            adminRepository.save(admin.get());
        }
        else{
            return new AdminLoginResponse("密码错误");
        }

        return new AdminLoginResponse();
    }

    public SuccessMsgResponse createAdmin(String username, String password){

        Optional<SpecialList> specialList = specialListRepository.findByName(username);

        if(!specialList.isPresent()){
            return new SuccessMsgResponse("没有权限");
        }

        Admin admin = new Admin();

        admin.setUsername(username);
        admin.setPwHashed(HashUtil.hashBCrypt(password));

        adminRepository.save(admin);

        return new SuccessMsgResponse();
    }

    public SuccessMsgResponse changePw(String username, String password, String newPassword){

        Optional<Admin> admin = adminRepository.findByUsername(username);

        if(admin.isPresent()){
            if(checkPw(admin.get(), password)){
                admin.get().setPwHashed(HashUtil.hashBCrypt(newPassword));
                adminRepository.save(admin.get());
                return new SuccessMsgResponse();
            }
            else{
                return new SuccessMsgResponse("原密码错误");
            }
        }
        else{
            return new SuccessMsgResponse("用户名不存在");
        }
    }

    private String getRandomString(String account){
        byte[] randomBytes=new byte[64];

        new Random().nextBytes(randomBytes);

        return account+ Base64.getEncoder().encodeToString(randomBytes);
    }


}


