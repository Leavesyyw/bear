package com.example.demo.service;

import com.example.demo.model.InformationModel;
import com.example.demo.model.PunchCardModel;
import com.example.demo.model.SignModel;
import com.example.demo.repository.InformationRepository;
import com.example.demo.repository.PunchCardRepository;
import com.example.demo.repository.SignRepository;
import com.example.demo.util.Daycompare;
import com.example.demo.util.InfUtils;
import com.example.demo.util.result.ErrorResult;
import com.example.demo.util.result.Result;
import com.example.demo.util.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PunchCardService {
    @Autowired
    PunchCardRepository punchCardRepository;
    @Autowired
    InformationRepository informationRepository;
    @Autowired
    SignRepository signRepository;

    //查询
    public Result search
    (String username) {
        try {
            System.out.println(username);
            if (signRepository.findByUsername(username) != null) {
                List<PunchCardModel> punchCardModelList = punchCardRepository.findByUsername(username);
                if (!punchCardModelList.isEmpty()) {
                    int n = punchCardModelList.size();
                    int count = 1;
                    System.out.println(n);
                    for (int i = n - 1; i >= 0; i--) {
                        if (Daycompare.getDaysBetween(punchCardModelList.get(i).getCalendar(), punchCardModelList.get(i).getCalendar()) == 1) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    InformationModel informationModel = informationRepository.findByUsername(username);
                    int icestatue,goldamount,count1;
                    icestatue=informationModel.getIcestatue();
                    goldamount=informationModel.getGoldamount();
                    informationModel.setCount(count);
                    count1=count;
                    int [] a = new int[3];
                    a[0]=icestatue;
                    a[1]=goldamount;
                    a[2]=count1;
                    return new SuccessResult(a);
                } else {
                    return new ErrorResult("还没有打过卡");
                }
            } else {
                return new ErrorResult("没有该用户");
            }
        } catch (Exception e) {
            //System.out.println(username);
            e.printStackTrace();
            return new ErrorResult();
        }

    }


    //打卡
    public Result punchcard(String username) {
        try {
            if (signRepository.findByUsername(username) != null) {
                Calendar calendar = Calendar.getInstance();
                List<PunchCardModel> punchCardModelList = punchCardRepository.findByUsername(username);
                if (!punchCardModelList.isEmpty()) {
                    int n = punchCardModelList.size();
                    if (Daycompare.getDaysBetween(calendar, punchCardModelList.get(n - 1).getCalendar()) < 1) {
                        return new ErrorResult("打过卡");
                    } else {
                        PunchCardModel punchCardModel = new PunchCardModel();
                        punchCardModel.setUsername(username);
                        Calendar cal = Calendar.getInstance();
                        punchCardModel.setCalendar(cal);
                        punchCardRepository.save(punchCardModel);
                        InformationModel informationModel = informationRepository.findByUsername(username);
                        if (informationModel.getIcestatue() == 5) {
                            informationModel.setGoldamount();
                            informationModel.setIcestatue(1);
                            informationRepository.save(informationModel);
                        } else {
                            informationModel.setIcestatue();
                            informationRepository.save(informationModel);
                        }
                        return new SuccessResult("打卡成功");
                    }
                } else {
                    PunchCardModel punchCardModel = new PunchCardModel();
                    punchCardModel.setUsername(username);
                    Calendar cal = Calendar.getInstance();
                    punchCardModel.setCalendar(cal);
                    punchCardRepository.save(punchCardModel);
                    InformationModel informationModel = new InformationModel();
                    informationModel.setUsername(username);
                    informationRepository.save(informationModel);
                    return new SuccessResult("打卡成功");
                }
            } else {
                System.out.println();
                return new ErrorResult("没有该用户");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResult();
        }

    }
}
