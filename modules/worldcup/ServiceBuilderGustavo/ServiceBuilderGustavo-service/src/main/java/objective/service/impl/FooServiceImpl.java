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

package objective.service.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.util.ParamUtil;
import objective.model.Foo;
import objective.service.base.FooServiceBaseImpl;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the foo remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link objective.service.FooService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FooServiceBaseImpl
 * @see objective.service.FooServiceUtil
 */

public class FooServiceImpl extends FooServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link objective.service.FooServiceUtil} to access the foo remote service.
	 *
	 *
	 */


	@JSONWebService
	public Foo addFoo(String field1, boolean field2, int field3, String field4, String field5){

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

		try {
			Date d = format.parse(field4);

			long fooId = CounterLocalServiceUtil.increment();
			Foo foo = fooPersistence.create(fooId) ;
			foo.setField1(field1);
			foo.setField2(field2);
			foo.setField3(field3);
			foo.setField4(d);
			foo.setField5(field5);

			return fooPersistence.update(foo);

		}  catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Foo> getAllFoos(int page){
		return getFooLocalService().getFoos((page - 1) * 20, 20);
	}

}