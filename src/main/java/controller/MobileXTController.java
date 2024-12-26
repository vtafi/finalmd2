package controller;

import entity.MobileXT;
import service.MobileXTService;

import java.util.List;

public class MobileXTController {
    public MobileXTService mobileXTService = new MobileXTService();
    public List<MobileXT> getAll(){
        return mobileXTService.getAll();
    }
    public void save(MobileXT mobileXT){
        mobileXTService.save(mobileXT);
    }
    public MobileXT findByID(int id){
        return mobileXTService.findByID(id);
    }
    public List<MobileXT> findByName(String name){
        return mobileXTService.findByName(name);
    }
    public void remove(int id){
        mobileXTService.remove(id);
    }
}
