package base;

import base.counter.FrameCounter;
import base.renderer.AnimationRenderer;
import base.renderer.Renderer;
import base.renderer.SingleImageRenderer;
import game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics{
//    boolean isValidFire;
    FrameCounter fireCounter;
    PlayerBullet bullet;
    PlayerBullet bullet1;
    PlayerBullet bullet2;
    BoxCollider collider;

    public int playerHealth = 100;

    public Player(){
        super();
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
        this.collider =  new BoxCollider(30,46);
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
            this.bullet = GameObject.recycle(PlayerBullet.class);
            this.bullet1 = GameObject.recycle(PlayerBullet.class);
            this.bullet2 = GameObject.recycle(PlayerBullet.class);
            bullet.velocity.setThis((float)0, (float)-5);
            bullet1.velocity.setThis((float)-2,(float)-5);
            bullet2.velocity.setThis((float)2,(float)-5);
            bullet.position.setThis(this.position.x, this.position.y);
            bullet1.position.setThis(this.position.x, this.position.y);
            bullet2.position.setThis(this.position.x, this.position.y);
            this.fireCounter.reset();
    }

    public void loseHP(){
        if(this.playerHealth > 0){
            this.playerHealth -= 20;
        }
        else{
            this.playerHealth = 0;
        }
    }

    public void reportStatus(){
        if(this.playerHealth > 0){
            System.out.println("player HP: "+this.playerHealth);
        }
        else {
            System.out.println("you lose");
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
