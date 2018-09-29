package base;

import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    BufferedImage image;
    //kiểu dữ liệu vector
    public Vector2D position;
    // render là 1 dạng đa hình
    Renderer renderer;

    public GameObject(){

    }

    public GameObject(BufferedImage image){
        this.image = image;
        this.position = new Vector2D(0,0);
    }

    //render : g.draw
    public  void render (Graphics g){
            if(this.renderer != null) {
                this.renderer.render(g,this);
            }
    }

    public void run (){

    }

}
