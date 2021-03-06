/*
 * Copyright (c) 2007, 2018 Oracle and/or its affiliates. All rights reserved.
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

/*
 * $URL$ $LastChangedDate$
 */

package com.sun.ts.tests.servlet.spec.requestdispatcher;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WrapServlet extends HttpServlet {

  ServletContext ctx = null;

  public void init(ServletConfig servletConfig) throws ServletException {
    super.init(servletConfig);
    System.out.println("WRAP INIT...");
    ctx = servletConfig.getServletContext();
  }

  public void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("IN WRAP SERVLET...");
    Object ctxRequest = ctx.getAttribute("tck.request");
    Object ctxResponse = ctx.getAttribute("tck.response");
    ctx.removeAttribute("tck.request");
    ctx.removeAttribute("tck.response");

    PrintWriter pw = response.getWriter();
    pw.println("In Wrap servlet...");
    if (ctxRequest != null && ctxResponse != null) {
      if (ctxRequest == request) {
        if (ctxResponse == response) {
          pw.println("Test PASSED");
        } else {
          pw.println("Test FAILED.  Expected the response object passed to"
              + " the target of a RequestDispatcher operation to be the same that"
              + " was passed to the RequestDispatcher.");
          pw.println("Original response: " + ctxResponse);
          pw.println("Passed responset: " + response);
        }
      } else {
        pw.println("Test FAILED.  Expected the request object passed to"
            + " the target of a RequestDispatcher operation to be the same that"
            + " was passed to the RequestDispatcher.");
        pw.println("Original request: " + ctxRequest);
        pw.println("Passed request: " + request);
      }
    } else {
      pw.println(
          "Test FAILED. Unable to find all required ServletContext values.");
      pw.println("tck.request: " + ctxRequest);
      pw.println("tck.response: " + ctxResponse);
    }
  }
}
