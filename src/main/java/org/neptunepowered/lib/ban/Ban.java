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

import com.google.common.base.Optional;
import net.canarymod.api.PlayerReference;

import java.net.InetAddress;
import java.util.Date;

/**
 * Represents a ban made on an object.
 */
public interface Ban {

    /**
     * Gets the type of this ban.
     *
     * @return the ban type
     */
    BanType getBanType();

    /**
     * Get the reason for the ban.
     *
     * @return the reason specified for the ban.
     */
    String getReason();

    /**
     * Gets the start date of the ban.
     *
     * @return creation date of the ban
     */
    Date getStartDate();

    /**
     * Gets the expiration date of this ban, if available.
     *
     * @return expiration date of the ban or {@link Optional#absent()}
     */
    Optional<Date> getExpirationDate();

    /**
     * Gets whether this ban is indefinitely long, e.g. has no expiration date.
     *
     * @return {@code true} if this ban has no expiration date, otherwise {@code false}
     */
    boolean isIndefinite();

    /**
     * Represents a ban made on a player.
     */
    interface Player extends Ban {

        /**
         * Gets the player this ban applies to.
         *
         * @return the player
         */
        PlayerReference getPlayer();
    }

    /**
     * Represents a ban made on an IP.
     */
    interface Ip extends Ban {

        /**
         * Gets the address this ban applies to.
         *
         * @return the address
         */
        InetAddress getAddress();
    }
}
