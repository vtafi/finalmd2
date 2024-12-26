package service;

import entity.MobileCH;
import respon.MobileCHrespon;

import java.util.List;

public class MobileCHService implements IService<MobileCH> {
    MobileCHrespon mobileCHrespon = new MobileCHrespon();
    @Override
    public List<MobileCH> getAll() {
        return mobileCHrespon.findAll();
    }

    @Override
    public List<MobileCH> save(MobileCH mobileCH) {
        mobileCHrespon.save(mobileCH);
        return mobileCHrespon.findAll();
    }

    @Override
    public void remove(int id) {
        mobileCHrespon.remove(id);
    }

    @Override
    public List<MobileCH> findByName(String name) {
        return mobileCHrespon.findByName(name);
    }

    @Override
    public MobileCH findByID(int id) {
        return mobileCHrespon.findByID(id);
    }
}
