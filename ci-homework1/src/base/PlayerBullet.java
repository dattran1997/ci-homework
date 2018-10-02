package base;

import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {

    public PlayerBullet (){

    }

    public PlayerBullet (int x, int y ){
        this.position = new Vector2D(x, y);
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
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
