package model;

public class Samsung extends Phone{
    private int quantity;
    public Samsung() {

    }
        public Samsung(String id, String name, String trademark, double price, int quantity) {
        super(id, name, trademark, price);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return this.quantity * getPrice();
    }

    @Override
    public String toString() {
        return "Samsung [" +
                "Mã Sản phẩm = "+ getId() +
                "  Tên sản phẩm = " + getName() +
                "  Tên thương hiệu = " + getTrademark() +
                "  Giá bán = " + getPrice() +
                "  Số lượng = " + quantity +
                ']';
    }

}
