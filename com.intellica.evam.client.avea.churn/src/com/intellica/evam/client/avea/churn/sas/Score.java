package com.intellica.evam.client.avea.churn.sas;

/*-----------------------------------------------------------
 Copyright (C) 2001 SAS Institute, Inc. All rights reserved.

 Notice:
 The following permissions are granted provided that the
 above copyright and this notice appear in the code and
 any related documentation. Permission to copy, modify and
 distribute code generated using or distributed with
 SAS Enterprise Miner J*Score software and any executables
 derived from such source code is limited to customers of
 SAS Institute with a valid license for SAS Enterprise Miner
 J*Score software. Any distribution of such code in any form
 shall be on an "AS IS" basis without warranty of any kind.
 SAS and all other SAS Institute Inc. product and service
 names are registered trademarks or trademarks of SAS 
 Institute Inc. in the USA and other countries. Except as 
 contained in this notice, the name of SAS Institute, SAS 
 Enterprise Miner and SAS Enterprise Miner J*Score software 
 shall not be used in the advertising or promotion of 
 products or services without prior written authorization 
 from SAS Institute Inc.
 ------------------------------------------------------------*/

import java.util.Map;
import java.util.HashMap;
import com.sas.ds.*;
import com.sas.analytics.eminer.jscore.util.*;

import eminer.user.Score.DS;




/**
 * The Score class encapsulates data step scoring code generated by the SAS
 * Enterprise Miner Java Scoring Component.
 * 
 * @since 1.0
 * @version Jscore 1.2
 * @author SAS Enterprise Miner Java Scoring Component
 * @see com.sas.analytics.eminer.jscore.util.Jscore
 */

public class Score implements Jscore {
	private boolean dataModified;
	public boolean reuseOutputMap;
	private DS dscode;

	/**
	 * A map of the (key) name, (value) reference pair for every variable
	 * modified by the score method. This is provided primarily for optional
	 * advanced development.
	 */
	protected Map outputVariables;

	public Score() {
		DSFormats formatLib = new JscoreUserFormats();
		dataModified = false;
		reuseOutputMap = false;
		dscode = new DS(formatLib);
	}

	/**
	 * Executes the scoring code and returns an output Map. By default a new
	 * instance of the output map is allocated the method is invoked. To modify
	 * this behavior set the public field reuseOutputMap to true. This will
	 * cause only one output map to be allocated, subsequent calls will reuse
	 * the same map. Note this will cause the content of the map to be over
	 * written at each time this method is invoked.
	 * 
	 * @param a
	 *            reference to a Map object that contains the (key) name String,
	 *            (value) pair, for the input variables to be used in the
	 *            "scoring" code.
	 * @return a Map of the (key) name, (value) reference pair for all variables
	 *         modified in the "scoring" code.
	 * @throws com.sas.analytics.eminer.jscore.util.JscoreException
	 *             Invalid input data type for String \"variableName\".
	 * @throws com.sas.analytics.eminer.jscore.util.JscoreException
	 *             Invalid input data type for Double \"variableName\".
	 */
	public Map score(Map indata) throws JscoreException {
		Object tmpVar;

		dscode.initialize();
		if (reuseOutputMap == false || outputVariables == null)
			outputVariables = new HashMap(28, .75F);

		tmpVar = indata.get("AVG_CC_REVENUE");
		if (tmpVar != null) {
			try {
				dscode.AVG_CC_REVENUE = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"AVG_CC_REVENUE\".");
			}
		} else
			dscode.AVG_CC_REVENUE = Double.NaN;

		tmpVar = indata.get("AVG_PACK_SMS_REVENUE");
		if (tmpVar != null) {
			try {
				dscode.AVG_PACK_SMS_REVENUE = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"AVG_PACK_SMS_REVENUE\".");
			}
		} else
			dscode.AVG_PACK_SMS_REVENUE = Double.NaN;

		tmpVar = indata.get("AVG_TOTALMF_REVENUE");
		if (tmpVar != null) {
			try {
				dscode.AVG_TOTALMF_REVENUE = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"AVG_TOTALMF_REVENUE\".");
			}
		} else
			dscode.AVG_TOTALMF_REVENUE = Double.NaN;

		tmpVar = indata.get("AVG_WOPACK_DATA_REVENUE");
		if (tmpVar != null) {
			try {
				dscode.AVG_WOPACK_DATA_REVENUE = ((Double) tmpVar)
						.doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"AVG_WOPACK_DATA_REVENUE\".");
			}
		} else
			dscode.AVG_WOPACK_DATA_REVENUE = Double.NaN;

		tmpVar = indata.get("B_CC_INV");
		if (tmpVar != null) {
			try {
				dscode.B_CC_INV = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"B_CC_INV\".");
			}
		} else
			dscode.B_CC_INV = Double.NaN;

		tmpVar = indata.get("B_CROSS_PORT");
		if (tmpVar != null) {
			try {
				dscode.B_CROSS_PORT = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"B_CROSS_PORT\".");
			}
		} else
			dscode.B_CROSS_PORT = Double.NaN;

		tmpVar = indata.get("B_EXT_ELIGIBLE");
		if (tmpVar != null) {
			try {
				dscode.B_EXT_ELIGIBLE = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"B_EXT_ELIGIBLE\".");
			}
		} else
			dscode.B_EXT_ELIGIBLE = Double.NaN;

		tmpVar = indata.get("B_LAST_ACT_PORTIN");
		if (tmpVar != null) {
			try {
				dscode.B_LAST_ACT_PORTIN = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"B_LAST_ACT_PORTIN\".");
			}
		} else
			dscode.B_LAST_ACT_PORTIN = Double.NaN;

		tmpVar = indata.get("B_MNP_ATTACK_L3M");
		if (tmpVar != null) {
			try {
				dscode.B_MNP_ATTACK_L3M = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"B_MNP_ATTACK_L3M\".");
			}
		} else
			dscode.B_MNP_ATTACK_L3M = Double.NaN;

		tmpVar = indata.get("B_TARIFFDATA_3M");
		if (tmpVar != null) {
			try {
				dscode.B_TARIFFDATA_3M = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"B_TARIFFDATA_3M\".");
			}
		} else
			dscode.B_TARIFFDATA_3M = Double.NaN;

		tmpVar = indata.get("G_INV_INC_AMT_AVG");
		if (tmpVar != null) {
			try {
				dscode.G_INV_INC_AMT_AVG = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"G_INV_INC_AMT_AVG\".");
			}
		} else
			dscode.G_INV_INC_AMT_AVG = Double.NaN;

		tmpVar = indata.get("G_RPM_AMT");
		if (tmpVar != null) {
			try {
				dscode.G_RPM_AMT = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"G_RPM_AMT\".");
			}
		} else
			dscode.G_RPM_AMT = Double.NaN;

		tmpVar = indata.get("G_TENURE");
		if (tmpVar != null) {
			try {
				dscode.G_TENURE = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"G_TENURE\".");
			}
		} else
			dscode.G_TENURE = Double.NaN;

		tmpVar = indata.get("G_WTP_ASIM_3M");
		if (tmpVar != null) {
			try {
				dscode.G_WTP_ASIM_3M = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"G_WTP_ASIM_3M\".");
			}
		} else
			dscode.G_WTP_ASIM_3M = Double.NaN;

		tmpVar = indata.get("SEGMENT");
		if (tmpVar != null) {
			try {
				dscode.SEGMENT = (String) tmpVar;
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for String \"SEGMENT\".");
			}
		} else
			dscode.SEGMENT = " ";

		tmpVar = indata.get("TOTAL_GROSS_REVENUE_M1");
		if (tmpVar != null) {
			try {
				dscode.TOTAL_GROSS_REVENUE_M1 = ((Double) tmpVar).doubleValue();
			} catch (Exception ex) {
				throw new JscoreException(
						"Invalid input data type for Double \"TOTAL_GROSS_REVENUE_M1\".");
			}
		} else
			dscode.TOTAL_GROSS_REVENUE_M1 = Double.NaN;

		dscode.run();

		outputVariables.put("D_TARGET", ((Object) dscode.D_TARGET));
		outputVariables.put("EM_CLASSIFICATION",
				((Object) dscode.EM_CLASSIFICATION));
		outputVariables.put("EM_EVENTPROBABILITY", ((Object) new Double(
				dscode.EM_EVENTPROBABILITY)));
		outputVariables.put("EM_PROBABILITY", ((Object) new Double(
				dscode.EM_PROBABILITY)));
		outputVariables.put("EM_SEGMENT", ((Object) dscode.EM_SEGMENT));
		outputVariables.put("EP_TARGET",
				((Object) new Double(dscode.EP_TARGET)));
		outputVariables.put("I_TARGET", ((Object) dscode.I_TARGET));
		outputVariables.put("LOG_AVG_CC_REVENUE", ((Object) new Double(
				dscode.LOG_AVG_CC_REVENUE)));
		outputVariables.put("LOG_AVG_PACK_SMS_REVENUE", ((Object) new Double(
				dscode.LOG_AVG_PACK_SMS_REVENUE)));
		outputVariables.put("LOG_TOTAL_GROSS_REVENUE_M1", ((Object) new Double(
				dscode.LOG_TOTAL_GROSS_REVENUE_M1)));
		outputVariables.put("PWR_AVG_WOPACK_DATA_REVENUE",
				((Object) new Double(dscode.PWR_AVG_WOPACK_DATA_REVENUE)));
		outputVariables.put("P_TARGET0",
				((Object) new Double(dscode.P_TARGET0)));
		outputVariables.put("P_TARGET1",
				((Object) new Double(dscode.P_TARGET1)));
		outputVariables.put("SQRT_AVG_TOTALMF_REVENUE", ((Object) new Double(
				dscode.SQRT_AVG_TOTALMF_REVENUE)));
		outputVariables.put("U_TARGET", ((Object) new Double(dscode.U_TARGET)));
		outputVariables.put("_WARN_", ((Object) dscode._WARN_));
		return outputVariables;
	}

} // end class Score

