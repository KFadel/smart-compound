package com.ntgclarity.smartcompound.portal.exceptionhandling;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ntgclarity.smartcompound.common.exception.SmartCompoundException;
import com.ntgclarity.smartcompound.portal.base.BaseBean;

import java.util.Iterator;

/**
 * 
 * @author Mai
 */
public class CustomExceptionHandler extends ExceptionHandlerWrapper {

	static final Logger logger = LogManager
			.getLogger(CustomExceptionHandler.class.getName());

	private ExceptionHandler exceptionHandler;
	private BaseBean baseBean = new BaseBean();

	public CustomExceptionHandler(ExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}

	@Override
	public ExceptionHandler getWrapped() {
		return exceptionHandler;
	}

	@Override
	public void handle() throws FacesException {
		logger.entry();
		for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents()
				.iterator(); i.hasNext();) {
			ExceptionQueuedEvent event = i.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event
					.getSource();
			Throwable t = getRootCause(context.getException());
			//context.getException().printStackTrace();
			try {
				if (t instanceof SmartCompoundException) {
					baseBean.addInfoMessage(((SmartCompoundException) t)
							.getMessageKey());
				}
			} finally {
				i.remove();
			}

		}
		getWrapped().handle();
	}

}