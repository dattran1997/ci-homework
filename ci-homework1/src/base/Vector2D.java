package base;

public class Vector2D {
    public float x;
    public float y;
    public Vector2D (){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vector2D Clone(){
        return new Vector2D(this.x, this.y);
    }

    // add sẽ tạo 1 vector mới rồi cộng , ko làm ảnh hưởng đến vector gốc
    public Vector2D add(float x,float y){
        Vector2D result = new Vector2D(this.x + x, this.y +y);
        // result là kiểu vector2D nên khi trả về sẽ ra cả x và y
        return result;
    }
    // add thẳng kq vào vector gốc
    public Vector2D addThis(float x, float y){
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D subtract(float x, float y){
        Vector2D result = new Vector2D(this.x - x, this.y - y);
        // result là kiểu vector2D nên khi trả về sẽ ra cả x và y
        return result;
    }

    public Vector2D subtractThis(float x, float y){
        this.x -= x;
        this.y -=y;
        return this;
    }
    // scale : hàm nhân
    public Vector2D scale(float x, float y){
        Vector2D result = new Vector2D(this.x * x, this.y * y);
        return result;
    }

    public Vector2D scaleThis(float x, float y){
        this.x *= x;
        this.y *=y;
        return this;
    }

    // tính đường chéo của 2 vector (2 điểm trên tọa độ )
    public float length(){
        return (float) Math.sqrt(x * x + y * y);
    }


    public void print (){
        System.out.println(x + "," + y);
    }


    @Override
    public String toString(){
        // overide để print ra kết quả của project
        return "(X:" + x + "; y :" + y + ")" ;
    }
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(10 , 10);
        v1.print();
        // toString
        System.out.println(v1);
    }
}
