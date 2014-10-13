package com.fr.station.component.customer.exception;

import com.fr.station.common.exception.ApplicationException;

/**
 * when card lost time can not fit 48 hours throw
 * 
 * @trace overview.exception
 * @author wenrui
 */
public class CustomerException extends ApplicationException {

	private static final long serialVersionUID = 1L;

	public CustomerException() {
		super();
	}

	public CustomerException(String message) {
		super(message);
	}
}
