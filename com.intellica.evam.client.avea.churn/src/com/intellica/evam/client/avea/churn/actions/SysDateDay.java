package com.intellica.evam.client.avea.churn.actions;

import java.util.ArrayList;
import java.util.Calendar;

import com.intellica.evam.sdk.outputaction.AbstractOutputAction;
import com.intellica.evam.sdk.outputaction.IOMParameter;
import com.intellica.evam.sdk.outputaction.OutputActionContext;

public class SysDateDay extends AbstractOutputAction{
	public Object retObj;

	@Override
	public int execute(OutputActionContext ctx) throws Exception {
		Calendar cal = Calendar.getInstance();
		this.retObj = Integer.valueOf(cal.get(5))%2;
		return 0;
	}

	@Override
	protected ArrayList<IOMParameter> getParameters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "0.9";
	}
	
	  public boolean isReturnable()
	  {
	    return true;
	  }

	  public Object getRetObj()
	  {
	    return this.retObj;
	  }
}
