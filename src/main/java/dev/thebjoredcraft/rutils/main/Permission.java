package dev.thebjoredcraft.rutils.main;


public enum Permission {
    ATTACK_PLAYER("rutils.event.can.attack"),
    ATTACKED_BY_PLAYER("rutils.event.can.attacked"),
    BUILD("rutils.event.can.build"),
    DESTROY("rutils.event.can.destroy");

    private final String msg;

    Permission(String perm) {
        this.msg = perm;
    }

    public String get() {
        return this.msg;
    }
}
