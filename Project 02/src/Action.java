/**
 * An action that can be taken by an entity
 */
public interface Action {

    Action createAnimationAction(Entity entity, int repeatCount);

    Action createActivityAction(Entity entity, WorldModel world, ImageStore imageStore);

    void executeAction(EventScheduler scheduler);

    void executeAnimationAction(EventScheduler scheduler);

    void executeActivityAction(EventScheduler scheduler); /*{
        switch (this.entity.getKind()) {
            case SAPLING:
                this.entity.executeSaplingActivity(this.world, this.imageStore, scheduler);
                break;
            case TREE:
                this.entity.executeTreeActivity( this.world, this.imageStore, scheduler);
                break;
            case FAIRY:
                this.entity.executeFairyActivity(this.world, this.imageStore, scheduler);
                break;
            case DUDE_NOT_FULL:
                this.entity.executeDudeNotFullActivity(this.world, this.imageStore, scheduler);
                break;
            case DUDE_FULL:
                this.entity.executeDudeFullActivity( this.world, this.imageStore, scheduler);
                break;
            default:
                throw new UnsupportedOperationException(String.format("executeActivityAction not supported for %s",
                        this.entity.getKind()));
        }
    }*/
}
