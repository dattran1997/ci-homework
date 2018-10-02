package base;

import base.counter.FrameCounter;
import base.renderer.AnimationRenderer;
import base.renderer.Renderer;
import base.renderer.SingleImageRenderer;
import game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
//    boolean isValidFire;
    FrameCounter fireCounter;
    PlayerBullet bullet;
    PlayerBulletLeft bulletLeft;
    PlayerBulletRight bulletRight;

    public Player(){

        // load image thay cho tạo mảng và add ảnh
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png"
        );
        this.renderer = new AnimationRenderer(images); // renderer là 1 dạng của đa hình vì là kiểu Renderer nhưng gọi new theo AnimationRender
        this.position = new Vector2D();
        position.x = Setting.START_PLAYER_POSITION_X;
        position.y = Setting.START_PLAYER_POSITION_Y;

        this.fireCounter = new FrameCounter(10);

    }

    public void move (int x, int y){
        position.addThis(x,y);
    }

    @Override
    public  void run (){
        if (KeyEventPress.isUpPress){
            this.move(0,-2);
        }
        if (KeyEventPress.isDownPress){
            this.move(0,2);
        }
        if (KeyEventPress.isRightPress){
            this.move(2,0);
        }
        if (KeyEventPress.isLeftPress){
            this.move(-2, 0);
        }
        boolean fireCounterRun = this.fireCounter.run();
        if (KeyEventPress.isSpacePress && fireCounterRun){
            this.shoot();
        }
    }



    public void shoot (){

        //khởi tạo đạn và add đạn vào mảng gameObjects
            this.bullet = GameObject.create(PlayerBullet.class);
            this.bulletLeft = GameObject.create(PlayerBulletLeft.class);
            this.bulletRight = GameObject.create(PlayerBulletRight.class);
            bullet.position.setThis(this.position.x, this.position.y);
            bulletLeft.position.setThis(this.position.x, this.position.y);
            bulletRight.position.setThis(this.position.x , this.position.y);

            this.fireCounter.reset();

    }
}
