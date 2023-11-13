public class Sapling extends Health {

    public Sapling(Entity entity, EventScheduler scheduler, int health, int healthLimit) {
        super(entity, scheduler, health, healthLimit);
    }

    public void executeActivityAction(EventScheduler scheduler) {
        this.executeSaplingActivity(this.world, this.imageStore, scheduler);
    }

    public boolean transformSapling(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this.health <= 0) {
            Entity stump = Functions.createStump(Functions.STUMP_KEY + "_" + this.id,
                    this.position, imageStore.getImageList(Functions.STUMP_KEY));

            world.removeEntity( scheduler,this);

            world.addEntity(stump);

            return true;
        } else if (this.health >= this.healthLimit) {
            Entity tree = Functions.createTree(Functions.TREE_KEY + "_" + this.id, this.position,
                    this.position.getNumFromRange(Functions.TREE_ACTION_MAX, Functions.TREE_ACTION_MIN),
                    this.position.getNumFromRange(Functions.TREE_ANIMATION_MAX, Functions.TREE_ANIMATION_MIN),
                    this.position.getIntFromRange(Functions.TREE_HEALTH_MAX, Functions.TREE_HEALTH_MIN),
                    imageStore.getImageList(Functions.TREE_KEY));

            world.removeEntity(scheduler, this);

            world.addEntity(tree);
            ((Tree)tree).scheduleActions(scheduler, world, imageStore);

            return true;
        }

        return false;
    }

    public boolean transformPlant(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        return transformSapling( world, scheduler, imageStore);
    }

    public void executeSaplingActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        this.health++;
        if (!this.transformPlant( world, scheduler, imageStore)) {
            scheduler.scheduleEvent(this, this.createActivityAction(this, world, imageStore), this.actionPeriod);
        }
    }

    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, this.createActivityAction(this, world, imageStore), this.actionPeriod);
        scheduler.scheduleEvent(this, this.createAnimationAction(this, 0), getAnimationPeriod());
    }

    public double getAnimationPeriod() { return this.animationPeriod; }

}
