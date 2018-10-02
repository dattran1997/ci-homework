package base;

import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    public static ArrayList<GameObject> gameObjects = new ArrayList<>();
    public static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    //create(classname) >> instance classname

    // hàm tạo đối tượng và add đối tượng vào mảng
    public static <E extends  GameObject> E create(Class<E> childClass){

        try{
            GameObject newGameObject = childClass.newInstance();
            newGameObjects.add(newGameObject);
            return (E)newGameObject;
        }catch (Exception e){
            return null;
        }
    }

    public static void runAll(){
        for(GameObject go : gameObjects){
            go.run();
        }
    }

    public static void renderAll (Graphics g){
        for (GameObject go : gameObjects){
            go.render(g);
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }

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
