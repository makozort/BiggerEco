package net.makozort.biggereco.events;
import net.makozort.biggereco.BiggerEco;
import net.makozort.biggereco.commands.ReturnHomeCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.makozort.biggereco.commands.SetHomeCommand;
import net.minecraftforge.server.command.ConfigCommand;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = BiggerEco.MOD_ID)
    public class ForgeEvents {

        @SubscribeEvent
        public static void onCommandRegister(RegisterCommandsEvent event) {
            new SetHomeCommand(event.getDispatcher());
            new ReturnHomeCommand(event.getDispatcher());




            ConfigCommand.register(event.getDispatcher());
        }
    }











}