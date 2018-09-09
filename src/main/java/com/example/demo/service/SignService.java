package com.example.demo.service;

import com.example.demo.model.InformationModel;
import com.example.demo.model.SignModel;
import com.example.demo.repository.InformationRepository;
import com.example.demo.repository.SignRepository;
import com.example.demo.util.InfUtils;
import com.example.demo.util.JwtUtils;
import com.example.demo.util.result.ErrorResult;
import com.example.demo.util.result.Result;
import com.example.demo.util.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignService {
    @Autowired
    SignRepository signRepository;
    @Autowired
    InformationRepository informationRepository;
   //注册
    public Result signup(String username,String password){
        try{
            SignModel signModel=signRepository.findByUsername(username);
            if(signModel==null){
                signModel=new SignModel();
                signModel.setUsername(username);
                signModel.setPassword(password);
                signRepository.save(signModel);
                return new SuccessResult("注册成功");
            }
            else
            {
                System.out.println(username);
                System.out.println(username+password);
                return new ErrorResult("该用户名已经注册");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorResult();
        }
    }
//登陆
    public Result signin(String username,String password){
        try{
            String arr [] = new String[4];
            if(signRepository.findByUsernameAndPassword(username,password)==null){
               return new ErrorResult("没有该用户");
            }

            else
            {
                InformationModel informationModel=informationRepository.findByUsername(username);
                if(informationModel!=null){
                Integer icestatue=informationRepository.findByUsername(username).getIcestatue();
                Integer goldamount=informationRepository.findByUsername(username).getGoldamount();
                Integer count=informationRepository.findByUsername(username).getCount();
                arr[0]="登陆成功";
                arr[1] = icestatue.toString();
                arr[2]=goldamount.toString();
                arr[3]=count.toString();
                return new SuccessResult(arr);}
                else
                {
                  arr[0]="登陆成功";
                  arr[1]="0";
                  arr[2]="0";
                  arr[3]="0";
                  return new SuccessResult(arr);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorResult();
        }

    }

}
