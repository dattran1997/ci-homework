package base.physics;

import base.GameObject;

public class BoxCollider {
    public int width;
    public int height;

    public BoxCollider(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int top(GameObject master) {
        return (int) master.position.y;
    }

    public int bot(GameObject master) {
        return (int) (master.position.y + this.height);
    }

    public int left(GameObject master) {
        return (int) master.position.x;
    }

    public int right(GameObject master) {
        return (int) (master.position.x + this.width);
    }

    public boolean intersect(Physics other, GameObject master) {
        //oM == other Master
        //oB == other BoxCollider
        GameObject oM = (GameObject) other;
        BoxCollider oB = other.getBoxCollider();

        boolean yIntersect = (this.top(master) >= oB.top(oM) && this.top(master) < oB.bot(oM))
                || (this.bot(master) >= oB.top(oM) && this.bot(master) < oB.bot(oM));
        boolean xIntersect = (this.right(master) >= oB.left(oM) && this.right(master) < oB.right(oM))
                || (this.left(master) >= oB.left(oM) && this.left(master) < oB.right(oM));
        return yIntersect && xIntersect;
    }

//    public static void main(String[] args) {
//        PlayerBullet b1 = new PlayerBullet();
//        PlayerBullet b2 = new PlayerBullet();
//        PlayerBullet b3 = new PlayerBullet();
//        b1.collider = new BoxCollider(5, 5);
//        b2.collider = new BoxCollider(5, 5);
//        b3.collider = new BoxCollider(5, 5);
//        b1.position.setThis((float)5, (float)5);
//        b2.position.setThis((float)8, (float)8);
//        b3.position.setThis((float)11, (float)5);
//        System.out.println(b1.collider.intersect(b2, b1)); // true
//        System.out.println(b2.collider.intersect(b3, b2)); // true
//        System.out.println(b1.collider.intersect(b3, b1)); // false
//    }
}
