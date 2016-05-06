package com.ntgclarity.smartcompound.portal.converter.base;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.ntgclarity.smartcompound.common.entity.Ticket;
import com.ntgclarity.smartcompound.common.utils.Utils;

/**AUTHOR: HEBA**/

@ManagedBean
@ApplicationScoped
public class TicketConverter extends BaseConverter implements Converter {

	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String str) {
		
		if(Utils.isNotEmpty(str) && Utils.isNumericValue(str))
		{
			Ticket ticket =getSmartCompoundManagment().getTicket(new Long(str));
			return ticket;
		}
		return null;
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if(object!=null)
		{
			if(object instanceof Ticket)
			{
				Long id = ((Ticket)object).getId();
				return id+"";
			}else
			{
				throw new IllegalStateException("Object is not an instance of Ticket ");
			}
		}
		return "";
	}

}
