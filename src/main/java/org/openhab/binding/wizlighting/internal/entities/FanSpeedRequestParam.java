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
package org.openhab.binding.wizlighting.internal.entities;

import org.eclipse.jdt.annotation.NonNullByDefault;

import com.google.gson.annotations.Expose;

/**
 * This POJO represents Fan Speed Request Param
 *
 * The outgoing JSON should look like this:
 *
 * {"id": 23, "method": "setPilot", "params": {"fanState": 1,"fanSpeed": 3}}
 *
 * extends {@link FanStateRequestParam} to always set {@code fanState}, similar to {@link DimmingRequestParam} and usual
 * fan remote behavior
 */
@NonNullByDefault
public class FanSpeedRequestParam extends FanStateRequestParam {

    @Expose(serialize = true, deserialize = true)
    private int fanSpeed; // min 1

    public FanSpeedRequestParam(int fanSpeed) {
        super(1); // fanState = 1
        this.fanSpeed = fanSpeed;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }
}
