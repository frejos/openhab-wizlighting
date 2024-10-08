/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.wizlighting.internal;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ThingTypeUID;

/**
 * The {@link WizLightingBindingConstants} class defines common constants, which
 * are used across the whole binding.
 *
 * @author Sriram Balakrishnan - Initial contribution
 * @author Joshua Freeman - update version
 */
@NonNullByDefault
public class WizLightingBindingConstants {

    /**
     * The binding id.
     */
    public static final String BINDING_ID = "wizlighting";
    public static final String CURRENT_BINDING_VERSION = "v4.0.0.03";

    /**
     * List of all Thing Type UIDs.
     */
    public static final ThingTypeUID THING_TYPE_WIZ_COLOR_BULB = new ThingTypeUID(BINDING_ID, "wizColorBulb");
    public static final ThingTypeUID THING_TYPE_WIZ_TUNABLE_BULB = new ThingTypeUID(BINDING_ID, "wizTunableBulb");
    public static final ThingTypeUID THING_TYPE_WIZ_DIMMABLE_BULB = new ThingTypeUID(BINDING_ID, "wizDimmableBulb");
    public static final ThingTypeUID THING_TYPE_WIZ_SMART_PLUG = new ThingTypeUID(BINDING_ID, "wizPlug");
    public static final ThingTypeUID THING_TYPE_WIZ_CEILING_FAN = new ThingTypeUID(BINDING_ID, "wizCeilingFan");

    /**
     * The supported thing types.
     */
    public static final Set<ThingTypeUID> SUPPORTED_THING_TYPES = Stream
            .of(THING_TYPE_WIZ_COLOR_BULB, THING_TYPE_WIZ_TUNABLE_BULB, THING_TYPE_WIZ_DIMMABLE_BULB,
                    THING_TYPE_WIZ_SMART_PLUG, THING_TYPE_WIZ_CEILING_FAN)
            .collect(Collectors.toSet());

    /**
     * List of all Channel ids
     */
    public static final String CHANNEL_COLOR = "color";
    public static final String CHANNEL_TEMPERATURE = "temperature";
    public static final String CHANNEL_DIMMING = "dimming";
    public static final String CHANNEL_SWITCH_STATE = "state";
    public static final String CHANNEL_LIGHT_MODE = "lightMode";
    public static final String CHANNEL_DYNAMIC_SPEED = "speed";
    public static final String CHANNEL_RSSI = "signalstrength";
    public static final String CHANNEL_LAST_UPDATE = "lastUpdate";
    public static final String CHANNEL_FAN_STATE = "fanState";
    public static final String CHANNEL_FAN_SPEED = "fanSpeed";
    public static final String CHANNEL_FAN_MODE = "fanMode";
    public static final String CHANNEL_FAN_REVERSE = "fanRevrs";

    // -------------- Configuration arguments ----------------
    /**
     * Mac address configuration argument key.
     */
    public static final String CONFIG_MAC_ADDRESS = "bulbMacAddress";
    public static final String MISSING_INVALID_MAC_ADDRESS = "bulbMacAddress";

    /**
     * Host address configuration argument key.
     */
    public static final String CONFIG_IP_ADDRESS = "bulbIpAddress";
    public static final String MISSING_INVALID_IP_ADDRESS = "bulbIpAddress";

    /**
     * Wifi socket update interval configuration argument key.
     */
    public static final String CONFIG_UPDATE_INTERVAL = "updateInterval";
    public static final long DEFAULT_REFRESH_INTERVAL_SEC = 60;

    /**
     * Wifi socket update interval configuration argument key.
     */
    public static final String CONFIG_RECONNECT_INTERVAL = "reconnectInterval";
    public static final long DEFAULT_RECONNECT_INTERVAL_MIN = 15;

    // -------------- Default values ----------------

    /**
     * The number of refresh intervals without a response before a bulb is marked
     * offline
     */
    public static final int MARK_OFFLINE_AFTER_SEC = 5 * 60;

    /**
     * Default Wifi socket default UDP port.
     */
    public static final int DEFAULT_BULB_UDP_PORT = 38899;

    /**
     * Default listener socket default UDP port.
     */
    public static final int DEFAULT_LISTENER_UDP_PORT = 38900;

    /**
     * How long before active discovery times out.
     */
    public static final int DISCOVERY_TIMEOUT_SECONDS = 2;

    // -------------- Constants Used ----------------

    /**
     * The color temperature range of the WiZ bulbs
     */
    public static final int MIN_COLOR_TEMPERATURE = 2200;
    public static final int MAX_COLOR_TEMPERATURE = 6500;
    public static final int COLOR_TEMPERATURE_RANGE = MAX_COLOR_TEMPERATURE - MIN_COLOR_TEMPERATURE;

    // -------------- Bulb Properties ----------------

    public static final String PROPERTY_BINDING_VERSION = "bindingVersion";
    public static final String PROPERTY_IP_ADDRESS = "ipAddress";

    public static final String PROPERTY_HOME_ID = "homeId";
    public static final String PROPERTY_ROOM_ID = "roomId";
    public static final String PROPERTY_HOME_LOCK = "homeLock";
    public static final String PROPERTY_PAIRING_LOCK = "pairingLock";
    public static final String PROPERTY_TYPE_ID = "typeId";
    public static final String PROPERTY_MODULE_NAME = "moduleName";
    public static final String PROPERTY_GROUP_ID = "groupId";

    public static final String EXPECTED_MODULE_NAME = "ESP01_SHRGB1C_31";
    public static final String LAST_KNOWN_FIRMWARE_VERSION = "1.18.0";
}
