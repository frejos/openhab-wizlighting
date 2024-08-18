/**
 * Copyright (c) 2010-2024 Contributors to the openHAB project
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
package org.openhab.binding.wizlighting.internal.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum represents the possible scene modes for fans.
 */
public enum WizLightingFanMode {
    Standard("Standard", 1),
    Breeze("Breeze", 2);

    private String fanModeName;
    private int modeId;

    private WizLightingFanMode(final String fanModeName, final int modeId) {
        this.fanModeName = fanModeName;
        this.modeId = modeId;
    }

    /**
     * Gets the fanMode name for request colorMode
     *
     * @return the fanMode name
     */
    public String getFanMode() {
        return fanModeName;
    }

    public int getModeId() {
        return modeId;
    }

    private static final Map<Integer, WizLightingFanMode> FAN_MODE_MAP_BY_ID;
    private static final Map<String, WizLightingFanMode> FAN_MODE_MAP_BY_NAME;

    static {
        FAN_MODE_MAP_BY_ID = new HashMap<Integer, WizLightingFanMode>();
        FAN_MODE_MAP_BY_NAME = new HashMap<String, WizLightingFanMode>();

        for (WizLightingFanMode v : WizLightingFanMode.values()) {
            FAN_MODE_MAP_BY_ID.put(v.modeId, v);
            FAN_MODE_MAP_BY_NAME.put(v.fanModeName.toLowerCase().replaceAll("\\W+", ""), v);
        }
    }

    public static WizLightingFanMode fromModeId(int id) {
        return FAN_MODE_MAP_BY_ID.get(id);
    }

    public static WizLightingFanMode fromModeName(String name) {
        WizLightingFanMode r = null;
        if (name != null && !"".equals(name)) {
            r = FAN_MODE_MAP_BY_NAME.get(name.toLowerCase().replaceAll("\\W+", ""));
        }
        return r;
    }
}
