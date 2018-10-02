package game;

import base.*;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//canvas bảng vẽ - panel
public class GameCanvas extends JPanel {
    Background background;
    Player player;
    Enemy enemy;

    public  static ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();
    public static ArrayList<Enemy> enemies = new ArrayList<>();
    public static ArrayList<PlayerBullet> playerBullets = new ArrayList<>(); // truyền vào cho biến playerbullet 1 giá trị là 1 mảng kiểu PlayerBullet tránh bị null point


    public GameCanvas(){
        // khởi tạo bg
        background = new Background();

        // khởi tạo player
        player = new Player();

        // khởi tạo enemy add vào list
        this.enemy = new Enemy(100,100);
        Enemy enemy1 = new Enemy(200 ,100);
        Enemy enemy2 = new Enemy(260,100);
        enemies.add(enemy);
        enemies.add(enemy1);
        enemies.add(enemy2);
    }

    // hàm run : hàm để update even khi có thay đổi về số liệu  (x += 1)

    public void run(){
        background.run();
        player.run();

        for (EnemyBullet enemyBullet : enemyBullets){
            enemyBullet.run();
        }

        for(Enemy enemy :enemies){
            enemy.run();
        }

        for(PlayerBullet playerBullet : playerBullets){
            playerBullet.run();
        }

    }

    //render là bút vẽ sau khi số liệu đc update (g.draw)

    public void render (Graphics g){
        background.render(g);
        player.render(g);

        //vẽ đạn enemy
        int enemyDelay = 0;
        for (EnemyBullet enemyBullet : enemyBullets){
            // làm chậm nhịp vẽ đạn
            if (enemyDelay == 40){
                enemyBullet.render(g);
                enemyDelay = 0;
            }
            enemyDelay ++;
        }

        //vẽ enemy
        for (Enemy enemy : enemies){
            enemy.render(g);
        }

        //vẽ đạn player
        int second = 0;
        for(PlayerBullet playerBullet : playerBullets){
            if (second > 8 ){
                playerBullet.render(g);
                second = 0;
            }
            second ++;

        }
    }

    //painComponent : là hàm vẽ các thay đổi
    // graphics : đóng vai trò là bút vẽ, là 1 phần trong Jpanel

    @Override
    protected void paintComponent(Graphics g) {
        // gom tất cả các phần vẽ trong render để vẽ
        this.render(g);
    }
}
