package net.liam.tutorialmod.item.custom;

import net.liam.tutorialmod.component.ModDataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.util.math.Box;
import java.util.List;


public class MagnetItem extends Item {
    public MagnetItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient && player.isInSneakingPose()) {
            Boolean active = stack.get(ModDataComponentTypes.ACTIVE);
            if (active != null && active) {
                 stack.set(ModDataComponentTypes.ACTIVE, false);
            } else {
                stack.set(ModDataComponentTypes.ACTIVE, true);
            }

        } else {
            double radius = 20.0;
            Box box = new Box(
                    player.getX() - radius, player.getY() - radius, player.getZ() - radius,
                    player.getX() + radius, player.getY() + radius, player.getZ() + radius
            );

            List<Entity> entities = player.getWorld().getOtherEntities(
                    player, box, entity -> (entity instanceof ItemEntity)
            );
            for (Entity entity : entities) {
                double dx = player.getX() - entity.getX();
                double dy = player.getY() - entity.getY();
                double dz = player.getZ() - entity.getZ();
                double length = Math.sqrt(dx * dx + dy * dy + dz * dz);

                double pullStrength = 0.5;

                if (length != 0) {
                    dx = dx / length * pullStrength;
                    dy = dy / length * pullStrength;
                    dz = dz / length * pullStrength;
                    entity.addVelocity(dx, dy, dz);
                    entity.velocityModified = true;

                }

            }
        }

        return TypedActionResult.success(stack);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (target.isMobOrPlayer()) {

            Boolean active = stack.get(ModDataComponentTypes.ACTIVE);

            double dx, dz, y, strength;
            y = 0.125;
            if (Boolean.TRUE.equals(active)) {
                dx = target.getX() - attacker.getX();
                dz = target.getZ() - attacker.getZ();
                strength = 0.75;
            } else {
                dx = attacker.getX() - target.getX();
                dz = attacker.getZ() - target.getZ();
                strength = 1.0;
                if (attacker.isSprinting()) {
                    strength = 2.0;
                }
            }

            double norm = Math.sqrt(dx * dx + dz * dz);
            if (norm != 0) {
                dx = dx / norm * strength;
                dz = dz / norm * strength;
                target.addVelocity(dx, y, dz);
                target.velocityModified = true;
            }
        } else {

            double dx = attacker.getX() - target.getX();
            double dz = attacker.getZ() - target.getZ();
            double strength = 1.0;
            double norm = Math.sqrt(dx * dx + dz * dz);
            if (norm != 0) {
                dx = dx / norm * strength;
                dz = dz / norm * strength;
                target.addVelocity(dx, 0, dz);
                target.velocityModified = true;
            }
        }

        return super.postHit(stack, target, attacker);
    }
}