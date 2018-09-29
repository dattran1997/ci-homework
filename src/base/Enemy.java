package base;

import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends GameObject{

    public Enemy(){

    }
    public Enemy(int x, int y){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/7.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/8.png"));
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(x,y);

    }

    //tạo giá trị random gán để bot di chuyển
    Random randomX = new Random();
    Random randomY = new Random();


    // run tương đương vs vòng for vì đc đặt trong loop
    public void run (){
        position.addThis(randomX.nextInt(3+2) -2, randomY.nextInt(3+2)-2);
        this.shoot();
    }

    public void shoot(){
        EnemyBullet enemyBullet = new EnemyBullet((int)position.x, (int)position.y);
        GameCanvas.enemyBullets.add(enemyBullet);
    }
}
