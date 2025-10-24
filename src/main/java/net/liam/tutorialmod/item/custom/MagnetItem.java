package net.liam.tutorialmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MagnetItem extends Item {
    public MagnetItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {



        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.isMobOrPlayer()) {

            double dx = target.getX() - attacker.getX();
            double dz = target.getZ() - attacker.getZ();
            double y = 0.25;

            double strength = 1.0;

            dx = dx / Math.sqrt(dx*dx + dz*dz) * strength;
            dz = dz / Math.sqrt(dx*dx + dz*dz) * strength;

            target.addVelocity(dx, y, dz);
            target.velocityModified = true;
        }
        return super.postHit(stack, target, attacker);
    }
}