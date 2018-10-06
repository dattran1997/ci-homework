package base;

import base.renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    boolean isActive = true;
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

    public static <E extends GameObject > E recycle(Class<E> childclass){
        // kiểm tra có game object tm yeu cầu (go.isActive == false và instance of child class)
        //có thì dùng lại
        // ko có tạo mưới
        //return game object
        for (GameObject go : gameObjects){
            if(!go.isActive && go.getClass().isAssignableFrom(childclass)){
                go.isActive = true;
                return (E)go;
            }
        }
        return create(childclass);
    }

    //physics là đối tượng cần đc check va chạm
    public  static <E extends GameObject> E intersect(Class<E> childClass, Physics physics){
        for(GameObject go : gameObjects){
            if(go.isActive && go.getClass().isAssignableFrom(childClass) && go instanceof Physics){
                Physics physicsGo =(Physics) go;
                boolean intersected = physics.getBoxCollider().intersect(physicsGo,(GameObject) physics);
                if(intersected){
                    return (E) physicsGo;
                }
            }
        }
        return null;
    }

    public static void runAll(){
//        for(GameObject go : gameObjects){
//            go.run();
//        }

        for(int i=0; i<gameObjects.size();i++){
            GameObject go = gameObjects.get(i);
            if (go.isActive){
                go.run();
            }
        }
//        System.out.println(gameObjects.size());
    }

    public static void renderAll (Graphics g){
        for (GameObject go : gameObjects){
            if (go.isActive){
                go.render(g);
            }
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
        this.isActive = true;
    }

    public GameObject(BufferedImage image){
        this.isActive = true;
        this.image = image;
        this.position = new Vector2D(0,0);
    }

    //render : g.draw
    public  void render (Graphics g){
            if(this.renderer != null) {
                this.renderer.render(g,this);
            }
    }

    public void destroy (){
        this.isActive = false;
    }


    public void run (){

    }

}
