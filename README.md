![logo](https://www.wizconnected.com/content/dam/wiz/master/logo-wiz-black-navigation.svg)

This binding integrates the [WiZ Connected](https://www.wizconnected.com/en-US/) smart devices. These inexpensive devices, typically smart bulbs, are available online and in most Home Depot stores. They come in a variety of bulb shapes and sizes with options of full color with tunable white, tunable white, and dimmable white. This binding has been tested with various bulbs and switchable plugs. They are sold under the Philips brand name. (Wiz is owned by Signify (formerly Philips Lighting).) *Note* that while both are sold by Philips, WiZ bulbs are *not* part of the Hue ecosystem.

This binding operates completely within the local network - the discovery, control, and status monitoring is entirely over UDP in the local network. The binding never attempts to contact the WiZ servers in any way but does not stop them from doing so independently. It should not interfer in any way with control of the bulbs via the WiZ app or any other service integrated with the WiZ app (ie: Alexa, IFTTT, SmartThings). Any changes made to the bulb state outside of openHAB should be detected by the binding and vice-versa. Before using the binding, the bulbs must be set up using the WiZ iOS or Android app. Local control must also be enabled with-in the WiZ app in the app settings. (This is the default.)

## Supported Things
* WiZ Full Color with Tunable White Bulbs
* WiZ Tunable White Bulbs
* WiZ Dimmable single-color bulbs
* Wiz Smart Plugs

_Note_ This binding was created for and tested on the full color with tunable white bulbs, however, users have reported success with other bulb types and plugs.
## Discovery
New devices can be discovered by scanning and may also be discovered by background discovery.
All discovered devices will default to 'Full Color' bulbs if unable to automatically detect the specific device type. You may need to create devices manually if desired.

Devices must first have been set up using the WiZ iOS or Android app. If the binding cannot discover your device, try unplugging it, wait several seconds, and plug it back in.

## Binding Configuration

The binding does not require any special configuration.
You can optionally manually set the IP and MAC address of the openHAB instance; if you do not set them, the binding will use the system defaults.

## Thing Configuration

To create or configure a device manually you need its IP address and MAC address.
These can be quickly found in the ios or android app by entering the settings for device in question and clicking on the model name.
The refresh interval may also be set; if unset it defaults to 30 seconds.
If you desire instant updates, you may also enable "heart-beat" synchronization with the bulbs.
Heart-beats are not used by default.
When heart-beats are enabled, the binding will continuously re-register with the bulbs to receive sync packets on every state change and on every 5 seconds.
Enabling heart-beats causes the refresh-interval to be ignored.
If heart-beats are not enabled, the channels are only updated when polled at the set interval and thus will be slightly delayed wrt changes made to the bulb state outside of the binding (ie, via the WiZ app).

**NOTE:** While the bulb's IP address is needed for initial manual configuration, this binding _does not_ require you to use a static IP for each bulb. After initial discovery or setup, the binding will automatically search for and re-match bulbs with changed IP addresses by MAC address once every hour.

Thing parameters:

| Parameter ID | Parameter Type | Mandatory | Description | Default |
|--------------|----------------|------|------------------|-----|
| macAddress | text | true | The MAC address of the bulb |  |
| ipAddress | text | true | The IP of the bulb |  |
| updateInterval | integer | false | Update time interval in seconds to request the status of the bulb. | 60 |
| useHeartBeats | boolean | false | Whether to register for continuous 5s heart-beats | false |
| reconnectInterval | integer | false | Interval in minutes between attempts to reconnect with a bulb that is no longer responding to status queries.  When the bulb first connects to the network, it should send out a firstBeat message allowing OpenHab to immediately detect it.  This is only as a back-up to re-find the bulb. | 15 |

Example Thing:

```
Thing wizlighting:wizBulb:lamp "My Lamp" @ "Living Room" [ macAddress="accf23343cxx", ipAddress="192.168.0.xx" ]
```

## Channels

The Binding supports the following channels:

| Channel Type ID | Item Type | Description                                           | Access |
|-----------------|-----------|-------------------------------------------------------|--------|
| color           | Color     | State, intensity, and color of the LEDs               | R/W    |
| temperature     | Dimmer    | Color temperature of the bulb                         | R/W    |
| dimming         | Dimmer    | The brightness of the bulb                            | R/W    |
| state           | Switch    | Whether the bulb is on or off                         | R/W    |
| lightMode       | String    | Preset light mode name to run                         | R/W    |
| speed           | Dimmer    | Speed of the color changes in dynamic light modes     | R/W    |
| signalstrength  | system    | Quality of the bulb's WiFi connection                 | R      |
| lastUpdate      | Time      | The last time an an update was received from the bulb | R      |

## Light Modes

The Binding supports the following Light Modes

| ID | Scene Name    |
|----|---------------|
|  1 | Ocean         |
|  2 | Romance       |
|  3 | Sunset        |
|  4 | Party         |
|  5 | Fireplace     |
|  6 | Cozy White    |
|  7 | Forest        |
|  8 | Pastel Colors |
|  9 | Wakeup        |
| 10 | Bed Time      |
| 11 | Warm White    |
| 12 | Daylight      |
| 13 | Cool White    |
| 14 | Night Light   |
| 15 | Focus         |
| 16 | Relax         |
| 17 | True Colors   |
| 18 | TV Time       |
| 19 | Plant Growth  |
| 20 | Spring        |
| 21 | Summer        |
| 22 | Fall          |
| 23 | Deep Dive     |
| 24 | Jungle        |
| 25 | Mojito        |
| 26 | Club          |
| 27 | Christmas     |
| 28 | Halloween     |
| 29 | Candlelight   |
| 30 | Golden White  |
| 31 | Pulse         |
| 32 | Steampunk     |

## Bulb Limitations
- The dimming channel and state channels duplicate the same values from the color channel. This is due to the way the bulbs physically work, they do not have a concept of three separate things.
- Full-color bulbs operate in either color mode OR tunable white/color temperature mode.
The RGB LED's are NOT used to control temperature - separate warm and cool white LED's are used. Sending a command on the color channel or the temperature channel will cause the bulb to switch the relevant mode. Sending a command on either the dimming or state channel should not cause the bulb to switch modes.
- Dimmable bulbs do not dim below 10%. 
- The binding attempts to immediately retrieve the actual state from the device after each command is acknowledged, sometimes this means your settings don't 'stick' this is because the device itself did not accept the command or setting.
- Parameters can not be changed while the bulbs are off, sending any commands to change any settings will cause the bulbs to turn on.
- Power on behavior is configured in the app.
- Fade in/out times are configured in the app.
- Sending too many commands to the bulbs too quickly can cause them to stop responding for a period of time.

## Example item linked to a channel

```
Color LivingRoom_Light_Color "Living Room Lamp" (gLivingroom) {channel="wizlighting:wizColorBulb:accf23343cxx:color"}
```


## Changelog

### Version 4.0.0.03

- TODO

### Version 4.0.0.02
- 4.0.0.01 incorrectly reported it's version as 3.4.0.01, this has been fixed and updated to 4.0.0.02
- Openhab 4.0 compatability tested and confirmed

### Version 4.0.0.01
- Initial build using 4.0.0 upstream Openhab dependencies, for testing only

### Version 3.4.0.01
- Updated to build for 3.4.0 OH dependencies
- Added ability to send the light mode name to the LightMode channel in addition to the light mode scene id. Most UI components handled this mapping automatically using the metadata, however, in rules it was cumbersome to have to look up the corresponding ids. You man now send the string name to the channel. Names are standardized for case and white space before matching. All of the below are valid in JavaScript rules:
items.getItem("BulbName_LightMode").sendCommand("DayLight");
items.getItem("BulbName_LightMode").sendCommand("Day Light");
items.getItem("BulbName_LightMode").sendCommand("daylight");
items.getItem("BulbName_LightMode").sendCommand(12);
items.getItem("BulbName_LightMode").sendCommand("12");

### Version 3.3.0.04
- Corrected bug that prevented dimming to 0 from turning off the bulbs

### Version 3.3.0.03
- Restructured code to facilitate building with 3.3.0 base and prepared for community distribution.

## History and Credit
I am only the latest in a long line of individuals who have picked this binding up and helped maintain it. I have a large installation of these devices in my home and have recently restructured the code, ported it to newer releases of OH and fixed a few bugs, but all credit goes to those before me that did the heavy lifting. Here I am attempting to make this easier for users to access by including it in the community marketplace.
