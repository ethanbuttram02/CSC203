import processing.core.PImage;

public class AnimatedEntity extends EntityActivity {

    protected int repeatCount;
    protected double actionPeriod;
    protected double animationPeriod;

    public AnimatedEntity(Entity entity, int repeatCount, EventScheduler scheduler) {
        super(entity, entity.world, entity.imageStore, scheduler);
        this.repeatCount = repeatCount;
    }

    public Animation createAnimationAction(Entity entity, int repeatCount) {
        return new Animation(entity, null, null,  Math.max(repeatCount - 1, 0), scheduler);
    }

    public void executeAnimationAction(EventScheduler scheduler) {
        this.nextImage();

        if (this.repeatCount != 1) {
            scheduler.scheduleEvent(this.entity, createAnimationAction(this.entity, this.repeatCount), this.getAnimationPeriod());
        }
    }

    public void executeAnimation(EventScheduler scheduler) {
        this.executeAnimationAction(scheduler);
    }

    public void nextImage() {
        this.imageIndex = this.imageIndex + 1;
    }

    public PImage getCurrentImage() {
        return this.images.get(this.imageIndex % this.images.size());
    }

    public double getAnimationPeriod() { return animationPeriod; }

    public void executeActivity(EventScheduler scheduler) {
        super.executeActivityAction(scheduler);
    }
}
