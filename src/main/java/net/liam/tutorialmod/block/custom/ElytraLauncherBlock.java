package net.liam.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class ElytraLauncherBlock extends Block {
    public ElytraLauncherBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        if (!world.isClient && entity instanceof PlayerEntity player) {

            int hunger = player.getHungerManager().getFoodLevel();

            ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);
            double durability = chest.getMaxDamage() - chest.getDamage();

            if (hunger > 7 && chest.isOf(Items.ELYTRA) && durability > 20 && !player.isSneaking()) {

                double dy = Math.min(durability/5, 2);
                double speed = 2.0;
                double yaw = Math.toRadians(player.getYaw());
                entity.addVelocity(-Math.sin(yaw) * speed, dy, Math.cos(yaw) * speed);
                entity.velocityModified = true;

                player.getHungerManager().add(-5, 0.0f);

            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {

        tooltip.add(Text.translatable("tooltip.tutorialmod.ElytraLauncherBlock.tooltip.1"));

        super.appendTooltip(stack, context, tooltip, options);
    }
}