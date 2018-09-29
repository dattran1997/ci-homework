package base;

import base.renderer.AnimationRenderer;
import base.renderer.Renderer;
import base.renderer.SingleImageRenderer;
import game.GameCanvas;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
    PlayerBullet bullet;

    public Player(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        this.renderer = new AnimationRenderer(images); // renderer là 1 dạng của đa hình vì là kiểu Renderer nhưng gọi new theo AnimationRender
        this.position = new Vector2D();
        position.x = Setting.START_PLAYER_POSITION_X;
        position.y = Setting.START_PLAYER_POSITION_Y;

    }

    public void move (int x, int y){
        position.addThis(x,y);
    }

    @Override
    public  void run (){
        if (KeyEventPress.isUpPress){
            this.move(0,-1);
        }
        if (KeyEventPress.isDownPress){
            this.move(0,1);
        }
        if (KeyEventPress.isRightPress){
            this.move(1,0);
        }
        if (KeyEventPress.isLeftPress){
            this.move(-1, 0);
        }
        if (KeyEventPress.isSpacePress){
            this.shoot();
        }
    }

    public void shoot (){
        this.bullet = new PlayerBullet((int)position.x, (int)position.y);
        GameCanvas.playerBullets.add(bullet);
    }
}
