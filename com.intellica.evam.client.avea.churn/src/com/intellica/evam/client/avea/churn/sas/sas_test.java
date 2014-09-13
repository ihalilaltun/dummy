package com.intellica.evam.client.avea.churn.sas;

import java.util.HashMap;
import java.util.Map;

import com.sas.analytics.eminer.jscore.util.JscoreException;

public class sas_test {
	public static void main(String[] args) {
		Score a = new Score();
		Object mustafa = null;
		Map<Object,Object> inputVariables = new HashMap<Object, Object>();
		inputVariables.put("AVG_CC_REVENUE", 50.0);
		inputVariables.put("AVG_PACK_SMS_REVENUE", 300.0);
		inputVariables.put("AVG_TOTALMF_REVENUE", 1500.0);
		inputVariables.put("AVG_WOPACK_DATA_REVENUE", 3800.0);
		inputVariables.put("B_CC_INV", 1.0);
		inputVariables.put("B_CROSS_PORT", 3.0);
		inputVariables.put("B_EXT_ELIGIBLE", 0.0);
		inputVariables.put("B_LAST_ACT_PORTIN", 1.0);
		inputVariables.put("B_MNP_ATTACK_L3M", 1.0);
		inputVariables.put("B_TARIFFDATA_3M", 0.0);
		inputVariables.put("G_INV_INC_AMT_AVG",0.0);
		inputVariables.put("G_RPM_AMT",0.0);
		inputVariables.put("G_TENURE",500.0);
		inputVariables.put("G_WTP_ASIM_3M",500.0);
		inputVariables.put("SEGMENT","MVNO");
		inputVariables.put("TOTAL_GROSS_REVENUE_M1", 300.0);
		try {
			mustafa = a.score(inputVariables);
		} catch (JscoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(mustafa.toString());
	}

}
