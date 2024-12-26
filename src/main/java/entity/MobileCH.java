package entity;

public class MobileCH extends Mobile {
    private int dateBh;
    private String pvBh;

    public MobileCH(){
    }

    public MobileCH(int id, String name, int price, int number, String production, int dateBh, String pvBh) {
        super(id, name, price, number, production);
        this.dateBh = dateBh;
        this.pvBh = pvBh;
    }

    public int getDateBh() {
        return dateBh;
    }

    public void setDateBh(int dateBh) {
        this.dateBh = dateBh;
    }

    public String getPvBh() {
        return pvBh;
    }

    public void setPvBh(String pvBh) {
        this.pvBh = pvBh;
    }

    @Override
    public String toString() {
        return super.toString() + "MobileCH{" +
                "dateBh=" + dateBh +
                ", pvBh='" + pvBh + '\'' +
                '}';
    }
}
