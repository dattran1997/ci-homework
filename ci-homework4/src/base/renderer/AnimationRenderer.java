package base.renderer;

import base.GameObject;
import base.counter.FrameCounter;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImage = 0;
    FrameCounter frameCounter;

    public AnimationRenderer (String...urls){
        ArrayList<BufferedImage>images = new ArrayList<>();
        for (String url : urls){
            BufferedImage image = SpriteUtils.loadImage(url);
            if(image != null){
                images.add(image);
            }
        }
        this.images = images;
    }

    public AnimationRenderer (ArrayList<BufferedImage> images){
        this.images = images;
        this.frameCounter = new FrameCounter(5);
    }

    // maxcount cho tùy chỉnh thời gian delay giữa các lần render ảnh
    public AnimationRenderer (ArrayList<BufferedImage> images, int maxCount){
        this.images = images;
        this.frameCounter = new FrameCounter(maxCount);
    }


//    int frameCount = 0;
    @Override
    public void render(Graphics g, GameObject master) {
        if(images.size() > 0){
            // load anh trong mang
            g.drawImage(images.get(currentImage), (int) master.position.x, (int) master.position.y, null);

            if(frameCounter.run()){
                currentImage ++;
                if(currentImage >= images.size() -1 ){  /*khi chạy quá chiều dài mảng thì gán về vị trí đầu*/
                    currentImage = 0;
                }
                frameCounter.reset();
            }
        }
    }
}
