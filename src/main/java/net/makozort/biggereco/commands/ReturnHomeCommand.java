package net.makozort.biggereco.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.makozort.biggereco.BiggerEco;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.Player;

import java.util.Arrays;

public class ReturnHomeCommand {
    public ReturnHomeCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("home").executes((command) -> {
            return returnHome(command.getSource());
        }));
    }

    private int returnHome(CommandSourceStack source) throws CommandSyntaxException {
        Player player = source.getPlayer();
        boolean hasHomepos = player.getPersistentData().getIntArray(BiggerEco.MOD_ID + "homepos").length != 0;

        if(hasHomepos) {
            int[] playerPos = player.getPersistentData().getIntArray(BiggerEco.MOD_ID + "homepos");

            player.setPos(playerPos[0], playerPos[1], playerPos[2]);

            player.sendSystemMessage(Component.literal(Arrays.toString((playerPos))));
            return 1;
        } else {
            player.sendSystemMessage(Component.literal("not home set!"));
            return -1;
        }
    }
}