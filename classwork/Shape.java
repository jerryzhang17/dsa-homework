public class Shape<T extends Number> {
 
    private T width;
    private T height;

    public Shape(T width, T height){
        this.height = height;
        this.width = width;
    }

    public double getArea(){
        return width.doubleValue() * height.doubleValue();
    }
}