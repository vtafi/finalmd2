package entity;

public class MobileXT extends Mobile {
    private String country;
    private String status;

    public MobileXT(){
    }
    public MobileXT(int id, String name, int price, int number, String production, String country,String status) {
        super(id, name, price, number, production);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + "MobileXT{" +
                "country='" + country + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
