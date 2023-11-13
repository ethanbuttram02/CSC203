import processing.core.PImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Dude_Not_Full extends Health {

    private String id;
    private Point position;
    private double actionPeriod;
    private double animationPeriod;
    private int resouceLimit;
    private List<PImage> images;

    public Dude_Not_Full(int health, int healthLimit, Entity entity, EventScheduler scheduler, String id, Point position, double actionPeriod, double animationPeriod, int resourceLimit, List<PImage> images) {
        super(entity, scheduler, health, healthLimit);
        this.id = id;
        this.position = position;
        this.actionPeriod = actionPeriod;
        this.animationPeriod = animationPeriod;
        this.resourceLimit = resourceLimit;
        this.images = images;
    }

    public void executeActivityAction(EventScheduler scheduler) {
        this.executeDudeNotFullActivity(this.world, this.imageStore, scheduler);
    }


    public boolean moveToNotFull(WorldModel world, Entity target, EventScheduler scheduler) {
        if (this.position.adjacent(target.position)) {
            this.resourceCount += 1;
            ((Health)target).health--;
            return true;
        } else {
            Point nextPos = nextPositionDude(world, target.position);

            if (!this.position.equals(nextPos)) {
                world.moveEntity(scheduler, this, nextPos);
            }
            return false;
        }
    }

    // TODO GET THIS WORKING WITH ARRAY STUFF
    public void executeDudeNotFullActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> target = world.findNearest(this.position, new ArrayList<>(Arrays.asList(Tree, Sapling)));


        if (target.isEmpty() || !moveToNotFull(world, target.get(), scheduler) || !this.transformNotFull(world, scheduler, imageStore)) {
            scheduler.scheduleEvent(this, super.createActivityAction(this, world, imageStore), this.actionPeriod);
        }
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, this.createActivityAction(this, world, imageStore), this.actionPeriod);
        scheduler.scheduleEvent(this, this.createAnimationAction(this, 0), getAnimationPeriod());
    }

    public boolean transformNotFull(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.resourceCount >= this.resourceLimit) {
            Entity dude = new Dude_Full(this.health, this.healthLimit, this.entity, this.scheduler, this.id, this.position, this.actionPeriod, this.animationPeriod, this.resourceLimit, this.images);

            world.removeEntity(scheduler, this);
            scheduler.unscheduleAllEvents(this);

            world.addEntity(dude);
            ((Dude_Full) dude).scheduleActions(scheduler, world, imageStore);

            return true;
        }

        return false;
    }

    public double getAnimationPeriod() { return this.animationPeriod; }

    public Point nextPositionDude(WorldModel world, Point destPos) {
        int horiz = Integer.signum(destPos.getX() - this.position.getX());
        Point newPos = new Point(this.position.getX() + horiz, this.position.getY());

        if (horiz == 0 || world.isOccupied(newPos) && !(world.getOccupancyCell(newPos) instanceof Stump)) {
            int vert = Integer.signum(destPos.getY() - this.position.getY());
            newPos = new Point(this.position.getX(), this.position.getY() + vert);

            if (vert == 0 || world.isOccupied(newPos) && !(world.getOccupancyCell(newPos) instanceof Stump)) {
                newPos = this.position;
            }
        }

        return newPos;
    }
}
