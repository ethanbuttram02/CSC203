import java.util.*;

import processing.core.PImage;

/**
 * An entity that exists in the world. See EntityKind for the
 * different kinds of entities that exist.
 */
public class Entity {
    public WorldModel world;
    public ImageStore imageStore;
    public int repeatCount;
    protected String id;
    protected Point position;
    protected List<PImage> images;
    protected int imageIndex;

    public Entity(WorldModel world, ImageStore imageStore, int repeatCount, String id, Point position, List<PImage> images) {
        this.world = world;
        this.imageStore = imageStore;
        this.repeatCount = repeatCount;
        this.id = id;
        this.position = position;
        this.images = images;
        this.imageIndex = 0;
    }

    public int getImageIndex() {  return imageIndex;  }

    public String getId() {  return id; }

    public Point getPosition() { return position; }

    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * Helper method for testing. Preserve this functionality while refactoring.
     */
    public String log(){
        return this.id.isEmpty() ? null :
                String.format("%s %d %d %d", this.id, this.position.getX(),
                        this.position.getY(), this.imageIndex);
    }
}
