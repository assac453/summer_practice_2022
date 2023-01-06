package GUI.Backend.Toys;

public class Toys {
    private int id;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name; //наименование
    private long articul; // артикул
    private String manufacture; // производитель
    private String dateCome; // дата поступления
    private String dateSell; // дата продажи
    private String type; // тип изделия

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getArticul() {
        return articul;
    }

    public void setArticul(long articul) {
        this.articul = articul;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getDateCome() {
        return dateCome;
    }

    public void setDateCome(String dateCome) {
        this.dateCome = dateCome;
    }

    public String getDateSell() {
        return dateSell;
    }

    public void setDateSell(String dateSell) {
        this.dateSell = dateSell;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Toys(int id, String name, long articul, String manufacture, String dateCome, String dateSell, String type, double price) {
        this.id = id;
        this.name = name;
        this.articul = articul;
        this.manufacture = manufacture;
        this.dateCome = dateCome;
        this.dateSell = dateSell;
        this.type = type;
        this.price = price;
    }
    public void showAll(){
        System.out.print(this.id + "\t");
        System.out.print(this.name + "\t");
        System.out.print(this.articul + "\t");
        System.out.print(this.manufacture + "\t");
        System.out.print(this.dateCome + "\t");
        System.out.print(this.dateSell + "\t");
        System.out.print(this.type + "\t");
        System.out.print(this.price + "\t");
        System.out.println();

    }
    public Toys(){}
}
