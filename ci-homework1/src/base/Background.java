package base;

import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class Background extends GameObject {


    public Background (){
        this.image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.renderer = new SingleImageRenderer( image);
        this.position = new Vector2D(); // vẫn phải gọi do ở lớp cha mới có biến chưa có gtrị

        // do điểm bắt đầu vẽ luôn là góc trái trên của ảnh nên phải kéo ngược lên trên để bg đi xuống
        position.x = 0;
        position.y = -(image.getHeight() - 600);
    }

    //overrider hàm run để thêm thay đổi của lớp con
    @Override
    public void run(){

        if(position.y > 0){
            return;
        }
        else{
//            y += 1;
            position.addThis(0,1);
        }

    }


}
