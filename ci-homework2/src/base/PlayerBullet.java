package base;

import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {

    public PlayerBullet (){
        this.position = new Vector2D(0, 0);
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/player-bullets/a/0.png",
                "assets/images/player-bullets/a/1.png",
                "assets/images/player-bullets/a/2.png",
                "assets/images/player-bullets/a/3.png"
        );

        // renderer = image
        this.renderer = new AnimationRenderer(images);
    }

    public PlayerBullet (int x, int y ){
        this.position = new Vector2D(x, y);

        // images ko cần gọi new vì trong loadImage đã có hàm khởi tạo
        // load image thay cho bước khởi tạo mảng và add địa chỉ ảnh vào mảng
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/player-bullets/a/0.png",
                "assets/images/player-bullets/a/1.png",
                "assets/images/player-bullets/a/2.png",
                "assets/images/player-bullets/a/3.png"
                );
        this.renderer = new AnimationRenderer(images);

    }

    public void move(int x, int y){
        position.addThis(x, y);
    }

    @Override
    public void run(){
        this.move(0,-5);
    }
}
