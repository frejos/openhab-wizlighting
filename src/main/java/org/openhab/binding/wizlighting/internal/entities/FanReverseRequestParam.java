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
 * This POJO represents Fan Reverse ({@code fanRevrs}) Request Param
 *
 * The outgoing JSON should look like this:
 *
 * {"id": 23, "method": "setPilot", "params": {"fanState": 1,"fanRevrs": 1}}
 *
 * extends {@link FanStateRequestParam} to always set {@code fanState}, similar to {@link DimmingRequestParam} and usual
 * fan remote behavior
 */
@NonNullByDefault
public class FanReverseRequestParam extends FanStateRequestParam {

    @Expose(serialize = true, deserialize = true)
    private int fanRevrs; // true = 1, false = 0

    public FanReverseRequestParam(int fanRevrs) {
        super(1); // fanState = 1
        this.fanRevrs = fanRevrs;
    }

    public int getFanRevrs() {
        return fanRevrs;
    }

    public void setFanRevrs(int fanRevrs) {
        this.fanRevrs = fanRevrs;
    }
}
