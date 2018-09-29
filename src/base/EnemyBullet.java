package base;

import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject {

    public EnemyBullet(){

    }

    public EnemyBullet(int x, int y){
        ArrayList<BufferedImage> images = new ArrayList();
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/green.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/pink.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/red.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/white.png"));
        images.add(SpriteUtils.loadImage("assets/images/enemies/bullets/yellow.png"));
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(x, y);
    }

    //có thể bỏ move khi run ko phải check even phím
    public void move(int x, int y){
        position.x += x;
        position.y += y;
    }

    @Override
    public void run (){
        this.move(0,2);
    }

}
