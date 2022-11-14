/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author BBBGARDEN
 */
public class DiscountBill extends GroceryBill {

    private final boolean preffered;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean preffered) {
        super(clerk);
        this.preffered = preffered;
        discountCount = 0;
        discountAmount = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        //Nếu preffered = true ( tức là khách hàng được hưởng khuyến mãi , 
        //và mặt hàng có khuyến mãi thì thêm giảm giá vào bill
        if (preffered == true && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public int getDiscountCount() {
        return discountCount;
    }
    //Tính % khuyến mãi so với tổng 
    public double getDiscountPercent() {
        return discountAmount * 100.0 / super.getTotal();
    }

    @Override
    public double getTotal() {
        return super.getTotal() - discountAmount;
    }

}
