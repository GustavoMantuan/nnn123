/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package objective.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FooService}.
 *
 * @author Brian Wing Shun Chan
 * @see FooService
 * @generated
 */
@ProviderType
public class FooServiceWrapper implements FooService,
	ServiceWrapper<FooService> {
	public FooServiceWrapper(FooService fooService) {
		_fooService = fooService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _fooService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<objective.model.Foo> getAllFoos(int page) {
		return _fooService.getAllFoos(page);
	}

	@Override
	public objective.model.Foo addFoo(java.lang.String field1, boolean field2,
		int field3, java.lang.String field4, java.lang.String field5) {
		return _fooService.addFoo(field1, field2, field3, field4, field5);
	}

	@Override
	public FooService getWrappedService() {
		return _fooService;
	}

	@Override
	public void setWrappedService(FooService fooService) {
		_fooService = fooService;
	}

	private FooService _fooService;
}