package controller;

import entity.MobileCH;
import service.MobileCHService;

import java.util.List;

public class MobileCHController {
    public MobileCHService mobileCHService = new MobileCHService();
    public List<MobileCH>getAll(){
        return mobileCHService.getAll();
    }
    public void save(MobileCH mobileCH){
        mobileCHService.save(mobileCH);
    }
    public MobileCH findByID(int id){
        return mobileCHService.findByID(id);
    }
    public List<MobileCH> findByName(String name){
        return mobileCHService.findByName(name);
    }
    public void remove(int id){
        mobileCHService.remove(id);
    }
}
