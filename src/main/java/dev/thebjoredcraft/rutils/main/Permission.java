package dev.thebjoredcraft.rutils.main;


public enum Permission {
    ATTACK_PLAYER("rutils.event.can.attack"),
    ATTACKED_BY_PLAYER("rutils.event.can.attacked"),
    BUILD("rutils.event.can.build"),
    DESTROY("rutils.event.can.destroy"),
    GAMEMODE_SELF_CREATIVE("rutils.command.gamemode.self.creative"),
    GAMEMODE_SELF_SPECTATOR("rutils.command.gamemode.self.spectator"),
    GAMEMODE_SELF_SURVIVAL("rutils.command.gamemode.self.survival"),
    GAMEMODE_SELF_ADVENTURE("rutils.command.gamemode.self.adventure"),
    GAMEMODE_OTHER_CREATIVE("rutils.command.gamemode.other.creative"),
    GAMEMODE_OTHER_SPECTATOR("rutils.command.gamemode.other.spectator"),
    GAMEMODE_OTHER_SURVIVAL("rutils.command.gamemode.other.survival"),
    GAMEMODE_OTHER_ADVENTURE("rutils.command.gamemode.other.adventure");

    private final String msg;

    Permission(String perm) {
        this.msg = perm;
    }

    public String get() {
        return this.msg;
    }
}
