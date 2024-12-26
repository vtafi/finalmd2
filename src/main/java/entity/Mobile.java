package entity;

public abstract class Mobile {
    private int id;
    private String name;
    private int price;
    private int number;
    private String production;
    private static int idCounter = 1;
    public Mobile(){

    }

    public Mobile(int id, String name, int price, int number, String production) {
        this.id=idCounter++;
        this.name = name;
        this.price = price;
        this.number = number;
        this.production = production;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", production='" + production + '\'' +
                '}';
    }
}
