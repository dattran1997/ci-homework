package game;

import base.KeyEventPress;
import base.Setting;
import game.GameCanvas;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    // khai báo biến ngoài để dùng chung
    // window là frame
    GameCanvas canvas ;



    public GameWindow(){
        //setup window
        this.setSize(Setting.SCREEN_WIDTH,Setting.SCREEN_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setupEventListtener();
        //init game
        this.canvas = new GameCanvas();
        this.add(canvas);
        this.setVisible(true);
    }

    private void setupEventListtener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyEventPress.isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyEventPress.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyEventPress.isRightPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyEventPress.isSpacePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isSpacePress = false;
                }
            }
        });
    }

    public void gameLoop(){
        long delay = 1000/60;
        long lastTime = 0;
        while (true){
            // nếu thời gian hiện tại cách thời gian chạy cuối cùng 1 khoảng bằng delay thì vẽ hình ( thời gian hiện tại luôn tăng)
            long currentTime= System.currentTimeMillis();
            if(currentTime - lastTime > delay){
            //logic
            canvas.run();
//            canvas.shoot();
            this.repaint(); //hàm repain gọi từ pain component
            // mỗi lần chạy xong thì gán t/g hiện tại băng t/g cuối
            lastTime = currentTime;
            }
        }
    }

}
