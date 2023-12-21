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

    CANNOT_DESTROY_DE(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("CANNOT_DESTROY_DE", ""))),
    CANNOT_DESTROY_EN(MiniMessage.miniMessage().deserialize(Rutils.getInstance().getConfig().getString("CANNOT_DESTROY_EN", "")));

    private final Component msg;

     Message(Component msg) {
        this.msg = msg;
    }

    public Component get() {
        return this.msg;
    }
}
