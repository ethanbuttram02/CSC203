import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Fairy extends AnimatedEntity {

    public Fairy(Entity entity, int repeatCount, EventScheduler scheduler) {
        super(entity, repeatCount, scheduler);
    }

    public void executeActivityAction(EventScheduler scheduler) {
        this.executeFairyActivity(this.world, this.imageStore, scheduler);
    }

    // TODO MAKE THE THING WORK TO CHECK WHERE STUMPS ARE
    public void executeFairyActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<AnimatedEntity> fairyTarget = world.findNearest(this.position, );

        if (fairyTarget.isPresent()) {
            Point tgtPos = fairyTarget.get().position;

            if (moveToFairy(world, fairyTarget.get(), scheduler)) {

                Entity sapling = Functions.createSapling(Functions.SAPLING_KEY + "_" + fairyTarget.get().id, tgtPos,
                        imageStore.getImageList(Functions.SAPLING_KEY), 0);

                Entity sapling = new Sapling(this.entity, this.scheduler, this.health, this.healthLimit);
                ((Sapling) sapling).scheduleActions(scheduler, world, imageStore);
            }
        }
    }

    public boolean moveToFairy(WorldModel world, Entity target, EventScheduler scheduler) {
        if (this.position.adjacent(target.position)) {
            world.removeEntity(scheduler, target);
            return true;
        } else {
            Point nextPos = nextPositionFairy(world, target.position);

            if (!this.position.equals(nextPos)) {
                world.moveEntity(scheduler, this, nextPos);
            }
            return false;
        }
    }

    public Point nextPositionFairy(WorldModel world, Point destPos) {
        int horiz = Integer.signum(destPos.getX() - this.position.getX());
        Point newPos = new Point(this.position.getX() + horiz, this.position.getY());

        if (horiz == 0 || world.isOccupied(newPos)) {
            int vert = Integer.signum(destPos.getY() - this.position.getY());
            newPos = new Point(this.position.getX(), this.position.getY() + vert);

            if (vert == 0 || world.isOccupied(newPos)) {
                newPos = this.position;
            }
        }
        return newPos;
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, this.createActivityAction(this, world, imageStore), this.actionPeriod);
        scheduler.scheduleEvent(this, this.createAnimationAction(this, 0), getAnimationPeriod());
    }

    public double getAnimationPeriod() { return this.animationPeriod; }
}
