public class Tree extends Health {

    public Tree(Entity entity, EventScheduler scheduler, int health, int healthLimit) {
        super(entity, scheduler, health, healthLimit);
    }

    public void executeActivityAction(EventScheduler scheduler) {
        this.executeTreeActivity(this.world, this.imageStore, scheduler);
    }

    public boolean transformTree(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.health <= 0) {
            Entity stump = Functions.createStump(Functions.STUMP_KEY + "_" + this.id, this.position,
                    imageStore.getImageList(Functions.STUMP_KEY));
            world.removeEntity(scheduler, this);
            world.addEntity(stump);
            return true;
        }
        return false;
    }

    public boolean transformPlant(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        return transformTree(world, scheduler, imageStore);
    }

    public void executeTreeActivity( WorldModel world, ImageStore imageStore, EventScheduler scheduler) {

        if (!this.transformPlant(world, scheduler, imageStore)) {

            scheduler.scheduleEvent(this, this.createActivityAction(this, world, imageStore), this.actionPeriod);
        }
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, this.createActivityAction(this, world, imageStore), this.actionPeriod);
        scheduler.scheduleEvent(this, this.createAnimationAction(this, 0), getAnimationPeriod());
    }

    public double getAnimationPeriod() { return this.animationPeriod; }
}
