/**
 ******************************************************************************
 *
 * @file       uavobjecttemplate.cpp
 * @author     The OpenPilot Team, http://www.openpilot.org Copyright (C) 2010.
 * @brief      Template for an uavobject in java
 *             This is a autogenerated file!! Do not modify and expect a result.
 *             Settings for the @ref AHRSCommsModule to control the algorithm and what is updated
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
Settings for the @ref AHRSCommsModule to control the algorithm and what is updated

generated from ahrssettings.xml
 **/
public class AHRSSettings extends UAVDataObject {

	public AHRSSettings() {
		super(OBJID, ISSINGLEINST, ISSETTINGS, NAME);
		
		List<UAVObjectField> fields = new ArrayList<UAVObjectField>();
		

		List<String> AlgorithmElemNames = new ArrayList<String>();
		AlgorithmElemNames.add("0");
		List<String> AlgorithmEnumOptions = new ArrayList<String>();
		AlgorithmEnumOptions.add("SIMPLE");
		AlgorithmEnumOptions.add("INSGPS_INDOOR_NOMAG");
		AlgorithmEnumOptions.add("INSGPS_INDOOR");
		AlgorithmEnumOptions.add("INSGPS_OUTDOOR");
		fields.add( new UAVObjectField("Algorithm", "", UAVObjectField.FieldType.ENUM, AlgorithmElemNames, AlgorithmEnumOptions) );

		List<String> DownsamplingElemNames = new ArrayList<String>();
		DownsamplingElemNames.add("0");
		fields.add( new UAVObjectField("Downsampling", "", UAVObjectField.FieldType.UINT8, DownsamplingElemNames, null) );

		List<String> UpdatePeriodElemNames = new ArrayList<String>();
		UpdatePeriodElemNames.add("0");
		fields.add( new UAVObjectField("UpdatePeriod", "ms", UAVObjectField.FieldType.UINT8, UpdatePeriodElemNames, null) );

		List<String> BiasCorrectedRawElemNames = new ArrayList<String>();
		BiasCorrectedRawElemNames.add("0");
		List<String> BiasCorrectedRawEnumOptions = new ArrayList<String>();
		BiasCorrectedRawEnumOptions.add("TRUE");
		BiasCorrectedRawEnumOptions.add("FALSE");
		fields.add( new UAVObjectField("BiasCorrectedRaw", "", UAVObjectField.FieldType.ENUM, BiasCorrectedRawElemNames, BiasCorrectedRawEnumOptions) );

		List<String> YawBiasElemNames = new ArrayList<String>();
		YawBiasElemNames.add("0");
		fields.add( new UAVObjectField("YawBias", "", UAVObjectField.FieldType.FLOAT32, YawBiasElemNames, null) );

		List<String> PitchBiasElemNames = new ArrayList<String>();
		PitchBiasElemNames.add("0");
		fields.add( new UAVObjectField("PitchBias", "", UAVObjectField.FieldType.FLOAT32, PitchBiasElemNames, null) );

		List<String> RollBiasElemNames = new ArrayList<String>();
		RollBiasElemNames.add("0");
		fields.add( new UAVObjectField("RollBias", "", UAVObjectField.FieldType.FLOAT32, RollBiasElemNames, null) );


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
		getField("Algorithm").setValue("INSGPS_INDOOR_NOMAG");
		getField("Downsampling").setValue(20);
		getField("UpdatePeriod").setValue(1);
		getField("BiasCorrectedRaw").setValue("TRUE");
		getField("YawBias").setValue(0);
		getField("PitchBias").setValue(0);
		getField("RollBias").setValue(0);

	}

	/**
	 * Create a clone of this object, a new instance ID must be specified.
	 * Do not use this function directly to create new instances, the
	 * UAVObjectManager should be used instead.
	 */
	public UAVDataObject clone(int instID) {
		// TODO: Need to get specific instance to clone
		try {
			AHRSSettings obj = new AHRSSettings();
			obj.initialize(instID, this.getMetaObject());
			return obj;
		} catch  (Exception e) {
			return null;
		}
	}

	/**
	 * Static function to retrieve an instance of the object.
	 */
	public AHRSSettings GetInstance(UAVObjectManager objMngr, int instID)
	{
	    return (AHRSSettings)(objMngr.getObject(AHRSSettings.OBJID, instID));
	}

	// Constants
	protected static final int OBJID = 0xDEFC5548;
	protected static final String NAME = "AHRSSettings";
	protected static String DESCRIPTION = "Settings for the @ref AHRSCommsModule to control the algorithm and what is updated";
	protected static final boolean ISSINGLEINST = 1 == 1;
	protected static final boolean ISSETTINGS = 1 == 1;
	protected static int NUMBYTES = 0;


}