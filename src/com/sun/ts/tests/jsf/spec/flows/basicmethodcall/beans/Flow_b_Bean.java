/*
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */

package com.sun.ts.tests.jsf.spec.flows.basicmethodcall.beans;

import javax.faces.flow.FlowScoped;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@FlowScoped(value = "flow-b")
public class Flow_b_Bean implements Serializable {

  public String getName() {
    return "Flow_B_Bean";
  }

  public String getReturnValue() {
    return "/return1";
  }

  public String methodWithOutcome(String strParam, Integer intParam) {
    if (!strParam.equals("param1Value")) {
      throw new IllegalArgumentException();
    }
    if (!intParam.equals(getInteger())) {
      throw new IllegalArgumentException();
    }

    return "next_b";
  }

  public void voidMethod() {
    FacesContext context = FacesContext.getCurrentInstance();
    context.getExternalContext().getRequestMap().put("message",
        "voidMethod called in flow-b");

  }

  public Integer getInteger() {
    return Integer.valueOf(Integer.MAX_VALUE);
  }
}
