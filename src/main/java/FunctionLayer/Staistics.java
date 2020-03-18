package FunctionLayer;

public class Staistics {

    private int o_id;
    private String createdAt;
    private String email;
    private int price;
    private int amountOfCupcakes;

    public Staistics(){

    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmountOfCupcakes() {
        return amountOfCupcakes;
    }

    public void setAmountOfCupcakes(int amountOfCupcakes) {
        this.amountOfCupcakes = amountOfCupcakes;
    }

    @Override
    public String toString(){
        return o_id + " " + email + " " + price + " " + amountOfCupcakes;
    }
}
