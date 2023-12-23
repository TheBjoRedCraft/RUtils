package dev.thebjoredcraft.rutils.main;


public enum ServerData {
    FILLER(true);

    private final Boolean arg;

    ServerData(Boolean arg) {
        this.arg = arg;
    }

    public Boolean get() {
        return this.arg;
    }
}
