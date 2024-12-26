package service;

import entity.MobileXT;
import respon.MobileXTrespon;

import java.util.List;

public class MobileXTService implements IService<MobileXT> {
    MobileXTrespon mobileXTrespon = new MobileXTrespon();
    @Override
    public List<MobileXT> getAll() {
        return mobileXTrespon.findAll();
    }

    @Override
    public List<MobileXT> save(MobileXT mobileXT) {
        mobileXTrespon.save(mobileXT);
        return mobileXTrespon.findAll();
    }

    @Override
    public void remove(int id) {
        mobileXTrespon.remove(id);

    }

    @Override
    public List<MobileXT> findByName(String name) {
        return mobileXTrespon.findByName(name);
    }

    @Override
    public MobileXT findByID(int id) {
        return mobileXTrespon.findByID(id);
    }
}
