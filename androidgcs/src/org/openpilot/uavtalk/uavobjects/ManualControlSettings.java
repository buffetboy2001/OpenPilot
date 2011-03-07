/**
 ******************************************************************************
 *
 * @file       uavobjecttemplate.cpp
 * @author     The OpenPilot Team, http://www.openpilot.org Copyright (C) 2010.
 * @brief      Template for an uavobject in java
 *             This is a autogenerated file!! Do not modify and expect a result.
 *             Settings to indicate how to decode receiver input by @ref ManualControlModule.
 *
 * @see        The GNU Public License (GPL) Version 3
 *
 *****************************************************************************/
/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package org.openpilot.uavtalk.uavobjects;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.openpilot.uavtalk.UAVObjectManager;
import org.openpilot.uavtalk.UAVObject;
import org.openpilot.uavtalk.UAVDataObject;
import org.openpilot.uavtalk.UAVObjectField;

/**
Settings to indicate how to decode receiver input by @ref ManualControlModule.

generated from manualcontrolsettings.xml
 **/
public class ManualControlSettings extends UAVDataObject {

	public ManualControlSettings() {
		super(OBJID, ISSINGLEINST, ISSETTINGS, NAME);
		
		List<UAVObjectField> fields = new ArrayList<UAVObjectField>();
		

		List<String> InputModeElemNames = new ArrayList<String>();
		InputModeElemNames.add("0");
		List<String> InputModeEnumOptions = new ArrayList<String>();
		InputModeEnumOptions.add("PWM");
		InputModeEnumOptions.add("PPM");
		InputModeEnumOptions.add("Spektrum");
		fields.add( new UAVObjectField("InputMode", "", UAVObjectField.FieldType.ENUM, InputModeElemNames, InputModeEnumOptions) );

		List<String> RollElemNames = new ArrayList<String>();
		RollElemNames.add("0");
		List<String> RollEnumOptions = new ArrayList<String>();
		RollEnumOptions.add("Channel1");
		RollEnumOptions.add("Channel2");
		RollEnumOptions.add("Channel3");
		RollEnumOptions.add("Channel4");
		RollEnumOptions.add("Channel5");
		RollEnumOptions.add("Channel6");
		RollEnumOptions.add("Channel7");
		RollEnumOptions.add("Channel8");
		RollEnumOptions.add("None");
		fields.add( new UAVObjectField("Roll", "channel", UAVObjectField.FieldType.ENUM, RollElemNames, RollEnumOptions) );

		List<String> PitchElemNames = new ArrayList<String>();
		PitchElemNames.add("0");
		List<String> PitchEnumOptions = new ArrayList<String>();
		PitchEnumOptions.add("Channel1");
		PitchEnumOptions.add("Channel2");
		PitchEnumOptions.add("Channel3");
		PitchEnumOptions.add("Channel4");
		PitchEnumOptions.add("Channel5");
		PitchEnumOptions.add("Channel6");
		PitchEnumOptions.add("Channel7");
		PitchEnumOptions.add("Channel8");
		PitchEnumOptions.add("None");
		fields.add( new UAVObjectField("Pitch", "channel", UAVObjectField.FieldType.ENUM, PitchElemNames, PitchEnumOptions) );

		List<String> YawElemNames = new ArrayList<String>();
		YawElemNames.add("0");
		List<String> YawEnumOptions = new ArrayList<String>();
		YawEnumOptions.add("Channel1");
		YawEnumOptions.add("Channel2");
		YawEnumOptions.add("Channel3");
		YawEnumOptions.add("Channel4");
		YawEnumOptions.add("Channel5");
		YawEnumOptions.add("Channel6");
		YawEnumOptions.add("Channel7");
		YawEnumOptions.add("Channel8");
		YawEnumOptions.add("None");
		fields.add( new UAVObjectField("Yaw", "channel", UAVObjectField.FieldType.ENUM, YawElemNames, YawEnumOptions) );

		List<String> ThrottleElemNames = new ArrayList<String>();
		ThrottleElemNames.add("0");
		List<String> ThrottleEnumOptions = new ArrayList<String>();
		ThrottleEnumOptions.add("Channel1");
		ThrottleEnumOptions.add("Channel2");
		ThrottleEnumOptions.add("Channel3");
		ThrottleEnumOptions.add("Channel4");
		ThrottleEnumOptions.add("Channel5");
		ThrottleEnumOptions.add("Channel6");
		ThrottleEnumOptions.add("Channel7");
		ThrottleEnumOptions.add("Channel8");
		ThrottleEnumOptions.add("None");
		fields.add( new UAVObjectField("Throttle", "channel", UAVObjectField.FieldType.ENUM, ThrottleElemNames, ThrottleEnumOptions) );

		List<String> FlightModeElemNames = new ArrayList<String>();
		FlightModeElemNames.add("0");
		List<String> FlightModeEnumOptions = new ArrayList<String>();
		FlightModeEnumOptions.add("Channel1");
		FlightModeEnumOptions.add("Channel2");
		FlightModeEnumOptions.add("Channel3");
		FlightModeEnumOptions.add("Channel4");
		FlightModeEnumOptions.add("Channel5");
		FlightModeEnumOptions.add("Channel6");
		FlightModeEnumOptions.add("Channel7");
		FlightModeEnumOptions.add("Channel8");
		FlightModeEnumOptions.add("None");
		fields.add( new UAVObjectField("FlightMode", "channel", UAVObjectField.FieldType.ENUM, FlightModeElemNames, FlightModeEnumOptions) );

		List<String> Accessory1ElemNames = new ArrayList<String>();
		Accessory1ElemNames.add("0");
		List<String> Accessory1EnumOptions = new ArrayList<String>();
		Accessory1EnumOptions.add("Channel1");
		Accessory1EnumOptions.add("Channel2");
		Accessory1EnumOptions.add("Channel3");
		Accessory1EnumOptions.add("Channel4");
		Accessory1EnumOptions.add("Channel5");
		Accessory1EnumOptions.add("Channel6");
		Accessory1EnumOptions.add("Channel7");
		Accessory1EnumOptions.add("Channel8");
		Accessory1EnumOptions.add("None");
		fields.add( new UAVObjectField("Accessory1", "channel", UAVObjectField.FieldType.ENUM, Accessory1ElemNames, Accessory1EnumOptions) );

		List<String> Accessory2ElemNames = new ArrayList<String>();
		Accessory2ElemNames.add("0");
		List<String> Accessory2EnumOptions = new ArrayList<String>();
		Accessory2EnumOptions.add("Channel1");
		Accessory2EnumOptions.add("Channel2");
		Accessory2EnumOptions.add("Channel3");
		Accessory2EnumOptions.add("Channel4");
		Accessory2EnumOptions.add("Channel5");
		Accessory2EnumOptions.add("Channel6");
		Accessory2EnumOptions.add("Channel7");
		Accessory2EnumOptions.add("Channel8");
		Accessory2EnumOptions.add("None");
		fields.add( new UAVObjectField("Accessory2", "channel", UAVObjectField.FieldType.ENUM, Accessory2ElemNames, Accessory2EnumOptions) );

		List<String> Accessory3ElemNames = new ArrayList<String>();
		Accessory3ElemNames.add("0");
		List<String> Accessory3EnumOptions = new ArrayList<String>();
		Accessory3EnumOptions.add("Channel1");
		Accessory3EnumOptions.add("Channel2");
		Accessory3EnumOptions.add("Channel3");
		Accessory3EnumOptions.add("Channel4");
		Accessory3EnumOptions.add("Channel5");
		Accessory3EnumOptions.add("Channel6");
		Accessory3EnumOptions.add("Channel7");
		Accessory3EnumOptions.add("Channel8");
		Accessory3EnumOptions.add("None");
		fields.add( new UAVObjectField("Accessory3", "channel", UAVObjectField.FieldType.ENUM, Accessory3ElemNames, Accessory3EnumOptions) );

		List<String> ArmingElemNames = new ArrayList<String>();
		ArmingElemNames.add("0");
		List<String> ArmingEnumOptions = new ArrayList<String>();
		ArmingEnumOptions.add("Always Disarmed");
		ArmingEnumOptions.add("Always Armed");
		ArmingEnumOptions.add("Roll Left");
		ArmingEnumOptions.add("Roll Right");
		ArmingEnumOptions.add("Pitch Forward");
		ArmingEnumOptions.add("Pitch Aft");
		ArmingEnumOptions.add("Yaw Left");
		ArmingEnumOptions.add("Yaw Right");
		fields.add( new UAVObjectField("Arming", "", UAVObjectField.FieldType.ENUM, ArmingElemNames, ArmingEnumOptions) );

		List<String> Stabilization1SettingsElemNames = new ArrayList<String>();
		Stabilization1SettingsElemNames.add("Roll");
		Stabilization1SettingsElemNames.add("Pitch");
		Stabilization1SettingsElemNames.add("Yaw");
		List<String> Stabilization1SettingsEnumOptions = new ArrayList<String>();
		Stabilization1SettingsEnumOptions.add("None");
		Stabilization1SettingsEnumOptions.add("Rate");
		Stabilization1SettingsEnumOptions.add("Attitude");
		fields.add( new UAVObjectField("Stabilization1Settings", "", UAVObjectField.FieldType.ENUM, Stabilization1SettingsElemNames, Stabilization1SettingsEnumOptions) );

		List<String> Stabilization2SettingsElemNames = new ArrayList<String>();
		Stabilization2SettingsElemNames.add("Roll");
		Stabilization2SettingsElemNames.add("Pitch");
		Stabilization2SettingsElemNames.add("Yaw");
		List<String> Stabilization2SettingsEnumOptions = new ArrayList<String>();
		Stabilization2SettingsEnumOptions.add("None");
		Stabilization2SettingsEnumOptions.add("Rate");
		Stabilization2SettingsEnumOptions.add("Attitude");
		fields.add( new UAVObjectField("Stabilization2Settings", "", UAVObjectField.FieldType.ENUM, Stabilization2SettingsElemNames, Stabilization2SettingsEnumOptions) );

		List<String> Stabilization3SettingsElemNames = new ArrayList<String>();
		Stabilization3SettingsElemNames.add("Roll");
		Stabilization3SettingsElemNames.add("Pitch");
		Stabilization3SettingsElemNames.add("Yaw");
		List<String> Stabilization3SettingsEnumOptions = new ArrayList<String>();
		Stabilization3SettingsEnumOptions.add("None");
		Stabilization3SettingsEnumOptions.add("Rate");
		Stabilization3SettingsEnumOptions.add("Attitude");
		fields.add( new UAVObjectField("Stabilization3Settings", "", UAVObjectField.FieldType.ENUM, Stabilization3SettingsElemNames, Stabilization3SettingsEnumOptions) );

		List<String> FlightModePositionElemNames = new ArrayList<String>();
		FlightModePositionElemNames.add("0");
		FlightModePositionElemNames.add("1");
		FlightModePositionElemNames.add("2");
		List<String> FlightModePositionEnumOptions = new ArrayList<String>();
		FlightModePositionEnumOptions.add("Manual");
		FlightModePositionEnumOptions.add("Stabilized1");
		FlightModePositionEnumOptions.add("Stabilized2");
		FlightModePositionEnumOptions.add("Stabilized3");
		FlightModePositionEnumOptions.add("VelocityControl");
		FlightModePositionEnumOptions.add("PositionHold");
		fields.add( new UAVObjectField("FlightModePosition", "", UAVObjectField.FieldType.ENUM, FlightModePositionElemNames, FlightModePositionEnumOptions) );

		List<String> ChannelMaxElemNames = new ArrayList<String>();
		ChannelMaxElemNames.add("0");
		ChannelMaxElemNames.add("1");
		ChannelMaxElemNames.add("2");
		ChannelMaxElemNames.add("3");
		ChannelMaxElemNames.add("4");
		ChannelMaxElemNames.add("5");
		ChannelMaxElemNames.add("6");
		ChannelMaxElemNames.add("7");
		fields.add( new UAVObjectField("ChannelMax", "us", UAVObjectField.FieldType.INT16, ChannelMaxElemNames, null) );

		List<String> ChannelNeutralElemNames = new ArrayList<String>();
		ChannelNeutralElemNames.add("0");
		ChannelNeutralElemNames.add("1");
		ChannelNeutralElemNames.add("2");
		ChannelNeutralElemNames.add("3");
		ChannelNeutralElemNames.add("4");
		ChannelNeutralElemNames.add("5");
		ChannelNeutralElemNames.add("6");
		ChannelNeutralElemNames.add("7");
		fields.add( new UAVObjectField("ChannelNeutral", "us", UAVObjectField.FieldType.INT16, ChannelNeutralElemNames, null) );

		List<String> ChannelMinElemNames = new ArrayList<String>();
		ChannelMinElemNames.add("0");
		ChannelMinElemNames.add("1");
		ChannelMinElemNames.add("2");
		ChannelMinElemNames.add("3");
		ChannelMinElemNames.add("4");
		ChannelMinElemNames.add("5");
		ChannelMinElemNames.add("6");
		ChannelMinElemNames.add("7");
		fields.add( new UAVObjectField("ChannelMin", "us", UAVObjectField.FieldType.INT16, ChannelMinElemNames, null) );

		List<String> ArmedTimeoutElemNames = new ArrayList<String>();
		ArmedTimeoutElemNames.add("0");
		fields.add( new UAVObjectField("ArmedTimeout", "ms", UAVObjectField.FieldType.UINT16, ArmedTimeoutElemNames, null) );


		// Compute the number of bytes for this object
		int numBytes = 0;
		ListIterator<UAVObjectField> li = fields.listIterator();
		while(li.hasNext()) {
			numBytes += li.next().getNumBytes();
		}
		NUMBYTES = numBytes;

		// Initialize object
		initializeFields(fields, ByteBuffer.allocate(NUMBYTES), NUMBYTES);
		// Set the default field values
		setDefaultFieldValues();
		// Set the object description
		setDescription(DESCRIPTION);
	}

	/**
	 * Create a Metadata object filled with default values for this object
	 * @return Metadata object with default values
	 */
	public Metadata getDefaultMetadata() {
		UAVObject.Metadata metadata = new UAVObject.Metadata();
		metadata.gcsAccess = UAVObject.AccessMode.ACCESS_READWRITE;
		metadata.gcsTelemetryAcked = UAVObject.Acked.TRUE;
		metadata.gcsTelemetryUpdateMode = UAVObject.UpdateMode.UPDATEMODE_ONCHANGE;
		metadata.gcsTelemetryUpdatePeriod = 0;

		metadata.flightAccess = UAVObject.AccessMode.ACCESS_READWRITE;
		metadata.flightTelemetryAcked = UAVObject.Acked.TRUE;
		metadata.flightTelemetryUpdateMode = UAVObject.UpdateMode.UPDATEMODE_ONCHANGE;
		metadata.flightTelemetryUpdatePeriod = 0;

		metadata.loggingUpdateMode = UAVObject.UpdateMode.UPDATEMODE_NEVER;
		metadata.loggingUpdatePeriod = 0;
		return metadata;
	}

	/**
	 * Initialize object fields with the default values.
	 * If a default value is not specified the object fields
	 * will be initialized to zero.
	 */
	public void setDefaultFieldValues()
	{
		getField("InputMode").setValue("PWM");
		getField("Roll").setValue("Channel1");
		getField("Pitch").setValue("Channel2");
		getField("Yaw").setValue("Channel3");
		getField("Throttle").setValue("Channel4");
		getField("FlightMode").setValue("Channel5");
		getField("Accessory1").setValue("None");
		getField("Accessory2").setValue("None");
		getField("Accessory3").setValue("None");
		getField("Arming").setValue("Always Disarmed");
		getField("Stabilization1Settings").setValue("Attitude",0);
		getField("Stabilization1Settings").setValue("Attitude",1);
		getField("Stabilization1Settings").setValue("Attitude",2);
		getField("Stabilization2Settings").setValue("Attitude",0);
		getField("Stabilization2Settings").setValue("Attitude",1);
		getField("Stabilization2Settings").setValue("Attitude",2);
		getField("Stabilization3Settings").setValue("Attitude",0);
		getField("Stabilization3Settings").setValue("Attitude",1);
		getField("Stabilization3Settings").setValue("Attitude",2);
		getField("FlightModePosition").setValue("Manual",0);
		getField("FlightModePosition").setValue("Manual",1);
		getField("FlightModePosition").setValue("Manual",2);
		getField("ChannelMax").setValue(2000,0);
		getField("ChannelMax").setValue(2000,1);
		getField("ChannelMax").setValue(2000,2);
		getField("ChannelMax").setValue(2000,3);
		getField("ChannelMax").setValue(2000,4);
		getField("ChannelMax").setValue(2000,5);
		getField("ChannelMax").setValue(2000,6);
		getField("ChannelMax").setValue(2000,7);
		getField("ChannelNeutral").setValue(1500,0);
		getField("ChannelNeutral").setValue(1500,1);
		getField("ChannelNeutral").setValue(1500,2);
		getField("ChannelNeutral").setValue(1500,3);
		getField("ChannelNeutral").setValue(1500,4);
		getField("ChannelNeutral").setValue(1500,5);
		getField("ChannelNeutral").setValue(1500,6);
		getField("ChannelNeutral").setValue(1500,7);
		getField("ChannelMin").setValue(1000,0);
		getField("ChannelMin").setValue(1000,1);
		getField("ChannelMin").setValue(1000,2);
		getField("ChannelMin").setValue(1000,3);
		getField("ChannelMin").setValue(1000,4);
		getField("ChannelMin").setValue(1000,5);
		getField("ChannelMin").setValue(1000,6);
		getField("ChannelMin").setValue(1000,7);
		getField("ArmedTimeout").setValue(30000);

	}

	/**
	 * Create a clone of this object, a new instance ID must be specified.
	 * Do not use this function directly to create new instances, the
	 * UAVObjectManager should be used instead.
	 */
	public UAVDataObject clone(int instID) {
		// TODO: Need to get specific instance to clone
		try {
			ManualControlSettings obj = new ManualControlSettings();
			obj.initialize(instID, this.getMetaObject());
			return obj;
		} catch  (Exception e) {
			return null;
		}
	}

	/**
	 * Static function to retrieve an instance of the object.
	 */
	public ManualControlSettings GetInstance(UAVObjectManager objMngr, int instID)
	{
	    return (ManualControlSettings)(objMngr.getObject(ManualControlSettings.OBJID, instID));
	}

	// Constants
	protected static final int OBJID = 0x2B82102;
	protected static final String NAME = "ManualControlSettings";
	protected static String DESCRIPTION = "Settings to indicate how to decode receiver input by @ref ManualControlModule.";
	protected static final boolean ISSINGLEINST = 1 == 1;
	protected static final boolean ISSETTINGS = 1 == 1;
	protected static int NUMBYTES = 0;


}