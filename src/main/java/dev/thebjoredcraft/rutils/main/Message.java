package dev.thebjoredcraft.rutils.main;

import dev.thebjoredcraft.rutils.Rutils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public enum Message {

    PLAYER_NOT_FOUND_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("PLAYER_NOT_FOUND_DE", ""))),
    PLAYER_NOT_FOUND_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("PLAYER_NOT_FOUND_EN", ""))),

    LANGUAGE_CHANGED_DE_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("LANGUAGE_CHANGED_DE_DE", ""))),
    LANGUAGE_CHANGED_DE_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("LANGUAGE_CHANGED_DE_EN", ""))),

    LANGUAGE_CHANGED_EN_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("LANGUAGE_CHANGED_EN_DE", ""))),
    LANGUAGE_CHANGED_EN_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("LANGUAGE_CHANGED_EN_EN", ""))),

    NOT_A_PLAYER_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("NOT_A_PLAYER_DE", ""))),
    NOT_A_PLAYER_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("NOT_A_PLAYER_EN", ""))),

    LANGUAGE_COMMAND_USAGE_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("LANGUAGE_COMMAND_USAGE_DE", ""))),
    LANGUAGE_COMMAND_USAGE_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("LANGUAGE_COMMAND_USAGE_EN", ""))),

    CANNOT_ATTACK_PLAYER_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("CANNOT_ATTACK_PLAYER_DE", ""))),
    CANNOT_ATTACK_PLAYER_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("CANNOT_ATTACK_PLAYER_EN", ""))),

    CANNOT_BUILD_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("CANNOT_BUILD_DE", ""))),
    CANNOT_BUILD_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("CANNOT_BUILD_EN", ""))),

    NUMBERFORMAT_ERROR_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("NUMBERFORMAT_ERROR_DE", ""))),
    NUMBERFORMAT_ERROR_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("NUMBERFORMAT_ERROR_EN", ""))),

    CANNOT_DESTROY_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("CANNOT_DESTROY_DE", ""))),
    CANNOT_DESTROY_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("CANNOT_DESTROY_EN", ""))),

    STOP_MESSAGE_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("STOP_MESSAGE_DE", ""))),
    STOP_MESSAGE_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("STOP_MESSAGE_EN", ""))),

    RESTART_MESSAGE_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("RESTART_MESSAGE_DE", ""))),
    RESTART_MESSAGE_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("RESTART_MESSAGE_EN", ""))),

    YOUR_GAMEMODE_CHANGED_TO_CREATIVE_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("YOUR_GAMEMODE_CHANGED_TO_CREATIVE_DE", ""))),
    YOUR_GAMEMODE_CHANGED_TO_CREATIVE_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("YOUR_GAMEMODE_CHANGED_TO_CREATIVE_EN", ""))),

    YOUR_GAMEMODE_CHANGED_TO_SURVIVAL_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("YOUR_GAMEMODE_CHANGED_TO_SURVIVAL_DE", ""))),
    YOUR_GAMEMODE_CHANGED_TO_SURVIVAL_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("YOUR_GAMEMODE_CHANGED_TO_SURVIVAL_EN", ""))),

    YOUR_GAMEMODE_CHANGED_TO_SPECTATOR_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("YOUR_GAMEMODE_CHANGED_TO_SPECTATOR_DE", ""))),
    YOUR_GAMEMODE_CHANGED_TO_SPECTATOR_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("YOUR_GAMEMODE_CHANGED_TO_SPECTATOR_EN", ""))),

    YOUR_GAMEMODE_CHANGED_TO_ADVENTURE_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("YOUR_GAMEMODE_CHANGED_TO_ADVENTURE_DE", ""))),
    YOUR_GAMEMODE_CHANGED_TO_ADVENTURE_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("YOUR_GAMEMODE_CHANGED_TO_ADVENTURE_EN", ""))),

    NO_PERMISSION_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("NO_PERMISSION_DE", ""))),
    NO_PERMISSION_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("NO_PERMISSION_EN", ""))),

    GAMEMODE_COMMAND_USAGE_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("GAMEMODE_COMMAND_USAGE_DE", ""))),
    GAMEMODE_COMMAND_USAGE_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("GAMEMODE_COMMAND_USAGE_EN", ""))),

    INVENTORY_CLEARED_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("INVENTORY_CLEARED_DE", ""))),
    INVENTORY_CLEARED_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("INVENTORY_CLEARED_EN", ""))),

    RENAME_COMMAND_USAGE_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("RENAME_COMMAND_USAGE_DE", ""))),
    RENAME_COMMAND_USAGE_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("RENAME_COMMAND_USAGE_EN", ""))),

    ITEM_RENAMED_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("ITEM_RENAMED_DE", ""))),
    ITEM_RENAMED_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("ITEM_RENAMED_EN", "")));



    private final Component msg;

     Message(Component msg) {
        this.msg = msg;
    }

    public Component get() {
        return this.msg;
    }
}
