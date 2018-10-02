package base;

import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBulletLeft extends GameObject {

    public PlayerBulletLeft (){

        // do hàm mới tạo bên SpriteUtils nên có thể load ảnh đưa vào mảng chỉ bằng 1 câu khởi tạo
        ArrayList<BufferedImage> images = SpriteUtils.loadImages("assets/images/sphere/0.png",
                "assets/images/sphere/1.png",
                "assets/images/sphere/2.png",
                "assets/images/sphere/3.png");

        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0, 0);
    }

    public void move(int x, int y){
        this.position.x += x;
        this.position.y += y;
    }

    @Override
    public void run (){
        this.move(-1,-3);
    }
}
