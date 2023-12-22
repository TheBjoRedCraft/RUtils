package dev.thebjoredcraft.rutils.main;

import dev.thebjoredcraft.rutils.Rutils;

public enum RawMessage {

    RESTART_IN_DE(Rutils.getInstance().getConfig().getString("RESTART_IN_DE", "")),
    RESTART_IN_EN(Rutils.getInstance().getConfig().getString("RESTART_IN_EN", "")),

    RESTART_ACTIONBAR_DE(Rutils.getInstance().getConfig().getString("RESTART_ACTIONBAR_DE", "")),
    RESTART_ACTIONBAR_EN(Rutils.getInstance().getConfig().getString("RESTART_ACTIONBAR_EN", "")),

    STOP_IN_DE(Rutils.getInstance().getConfig().getString("STOP_IN_DE", "")),
    STOP_IN_EN(Rutils.getInstance().getConfig().getString("STOP_IN_EN", ""));

    private final String msg;

     RawMessage(String msg) {
        this.msg = msg;
    }

    public String get() {
        return this.msg;
    }
}