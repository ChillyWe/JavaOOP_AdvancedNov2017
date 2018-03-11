package generics.Problem11;

/**
 * Created by Chilly on 23.11.2017 г..
 */
public class Threeuple<A, B, C>  {
    private A item1;
    private B item2;
    private C item3;

    public Threeuple(A item1, B item2, C item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    public A getItem1() {
        return this.item1;
    }

    public B getItem2() {
        return this.item2;
    }

    public C getItem3() {
        return this.item3;
    }

    private void setItem1(A item1) {
        this.item1 = item1;
    }

    private void setItem2(B item2) {
        this.item2 = item2;
    }

    private void setItem3(C item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.getItem1(), this.getItem2(), this.getItem3());
    }
}