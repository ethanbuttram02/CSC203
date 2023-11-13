import processing.core.PImage;

import java.util.List;

public class Stump extends Entity {

    public Stump(WorldModel world, ImageStore imageStore, int repeatCount, String id, Point position, List<PImage> images) {
        super(world, imageStore, repeatCount, id, position, images);
    }
}
