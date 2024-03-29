/*
 * This file is part of NeptuneLib, licensed under the MIT License (MIT).
 *
 * Copyright (c) Jamie Mansfield <https://github.com/jamierocks>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.neptunepowered.lib.ban;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

/**
 * Represents the possible types of bans.
 */
public enum BanType {

    /**
     * A ban made on a player
     */
    PLAYER,

    /**
     * A ban made on an IP
     */
    IP;

    private static BiMap<BanType, net.canarymod.bansystem.BanType> map =
            ImmutableBiMap.<BanType, net.canarymod.bansystem.BanType>builder()
                    .put(BanType.PLAYER, net.canarymod.bansystem.BanType.UUID)
                    .put(BanType.IP, net.canarymod.bansystem.BanType.IP)
                    .build();

    public net.canarymod.bansystem.BanType getCanaryType() {
        return map.get(this);
    }

    public static BanType fromCanaryType(net.canarymod.bansystem.BanType banType) {
        return map.inverse().get(banType);
    }
}
