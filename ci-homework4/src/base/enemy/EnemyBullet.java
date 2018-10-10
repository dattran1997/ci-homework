package base.enemy;

import base.*;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.player.Player;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider collider;
    int damage;

    public EnemyBullet(){
        super();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/bullets/blue.png",
                "assets/images/enemies/bullets/cyan.png",
                "assets/images/enemies/bullets/green.png",
                "assets/images/enemies/bullets/pink.png",
                "assets/images/enemies/bullets/red.png",
                "assets/images/enemies/bullets/white.png",
                "assets/images/enemies/bullets/yellow.png"
        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0, 0);
        this.collider = new BoxCollider(14,14);
        this.damage = 20;
    }

    public EnemyBullet(int x, int y){

        // load image: tạo mảng và add ảnh vào
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/bullets/blue.png",
                "assets/images/enemies/bullets/cyan.png",
                "assets/images/enemies/bullets/green.png",
                "assets/images/enemies/bullets/pink.png",
                "assets/images/enemies/bullets/red.png",
                "assets/images/enemies/bullets/white.png",
                "assets/images/enemies/bullets/yellow.png"
        );
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
        // check nếu có va chạm giữa player vs ebullet thì gán vào biến player
        Player player = GameObject.intersect(Player.class,this);
        if (player != null){
            // player khi bị va chạm sẽ đc lấy từ gameObjects gán vào biến để thay đổi thông số
            if(player.playerHealth > 0){
                player.takeDamage(damage);
                this.destroy();
            }
            else if (player.playerHealth == 0){
                player.reportStatus();
                this.destroy();
            }
        }
        else {
            if(this.position.y > Setting.SCREEN_WIDTH){
                this.destroy();
            }
        }
        this.move(0,2);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
