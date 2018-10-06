package base;

import base.counter.FrameCounter;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Enemy extends GameObject implements Physics {
    EnemyBullet enemyBullet;
    FrameCounter frameCounter;
    BoxCollider collider;

    public Enemy() {
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/level0/black/0.png",
                "assets/images/enemies/level0/black/0.png",
                "assets/images/enemies/level0/black/1.png",
                "assets/images/enemies/level0/black/2.png",
                "assets/images/enemies/level0/black/4.png",
                "assets/images/enemies/level0/black/5.png",
                "assets/images/enemies/level0/black/6.png",
                "assets/images/enemies/level0/black/7.png",
                "assets/images/enemies/level0/black/8.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0, 0);
        this.frameCounter = new FrameCounter(10);
        this.collider = new BoxCollider(32,48);
    }

    public Enemy(int x, int y) {

        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/level0/black/0.png",
                "assets/images/enemies/level0/black/0.png",
                "assets/images/enemies/level0/black/1.png",
                "assets/images/enemies/level0/black/2.png",
                "assets/images/enemies/level0/black/4.png",
                "assets/images/enemies/level0/black/5.png",
                "assets/images/enemies/level0/black/6.png",
                "assets/images/enemies/level0/black/7.png",
                "assets/images/enemies/level0/black/8.png"
        );

        // max count la khoang delay giua cac anh render
        this.renderer = new AnimationRenderer(images, 2);
        this.position = new Vector2D(x, y);

    }

    //tạo giá trị random gán để bot di chuyển
    Random randomX = new Random();
    Random randomY = new Random();


    // run tương đương vs vòng for vì đc đặt trong loop
    public void run() {
        position.addThis(randomX.nextInt(3 + 2) - 2, randomY.nextInt(3 + 2) - 2);
        if (this.frameCounter.run()) {
            this.shoot();
            this.frameCounter.reset();
        }
    }

    public void shoot() {

//        this.enemyBullet = GameObject.create(EnemyBullet.class);
        this.enemyBullet = GameObject.recycle(EnemyBullet.class);

        enemyBullet.position.setThis(this.position.x, this.position.y);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
