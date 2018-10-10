package game;

import base.*;
import base.enemy.Enemy;
import base.player.Player;

import javax.swing.*;
import java.awt.*;

//canvas bảng vẽ - panel
public class GameCanvas extends JPanel {
    Background background;
    Player player;
    Enemy enemy;
    Enemy enemy1;
    Enemy enemy2;


    //hàm khởi tạo GameCanvas
    public GameCanvas(){

        // khởi tạo bg
        // thay create = recycle
        background = GameObject.recycle(Background.class);

        // khởi tạo player
        player = GameObject.recycle(Player.class);

        // create: khởi tạo enemy add vào list
        this.enemy = GameObject.recycle(Enemy.class);
        this.enemy1 = GameObject.recycle(Enemy.class);
        this.enemy2 = GameObject.recycle(Enemy.class);

        this.enemy.position.setThis((float)100,(float)100);
        this.enemy1.position.setThis((float)200,(float)100);
        this.enemy2.position.setThis((float)260,(float)100);
    }


    // hàm run : hàm để update even khi có thay đổi về số liệu  (x += 1)
    // run phụ trách logic thay đổi dữ liệu

    public void run(){
        // run al : chạy tất cả object đc add vào list static gameObjects
        GameObject.runAll();
    }


    //render là bút vẽ sau khi số liệu đc update (g.draw)
    // chỉ phụ trách vẽ

    public void render (Graphics g){
    //tương tự như run
        GameObject.renderAll(g);
    }


    //painComponent : là hàm vẽ các thay đổi
    // graphics : đóng vai trò là bút vẽ, là 1 phần trong Jpanel

    @Override
    protected void paintComponent(Graphics g) {
        // gom tất cả các phần vẽ trong render để vẽ
        this.render(g);
    }
}
