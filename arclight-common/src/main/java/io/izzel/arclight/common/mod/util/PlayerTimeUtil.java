package io.izzel.arclight.common.mod.util;

import net.minecraft.network.protocol.game.ClientboundSetTimePacket;

public final class PlayerTimeUtil {

    private PlayerTimeUtil() {
    }

    public static ClientboundSetTimePacket personalize(ClientboundSetTimePacket packet, long playerTime, long offset, boolean relative) {
        if (relative && offset == 0) {
            return packet;
        }
        // Negative day time encodes a stopped client clock; the constructor also handles frozen time zero.
        return new ClientboundSetTimePacket(packet.getGameTime(), playerTime, relative && packet.getDayTime() >= 0);
    }
}
