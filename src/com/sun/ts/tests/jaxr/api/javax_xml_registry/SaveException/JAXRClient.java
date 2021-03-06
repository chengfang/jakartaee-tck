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
 * @(#)JAXRClient.java	1.15 03/05/16
 */
package com.sun.ts.tests.jaxr.api.javax_xml_registry.SaveException;

import com.sun.ts.lib.util.*;
import com.sun.ts.lib.porting.*;
import com.sun.ts.lib.harness.*;
import com.sun.ts.tests.jaxr.common.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.*;
import com.sun.javatest.Status;

import javax.xml.registry.*;
import javax.xml.registry.infomodel.*;
import java.net.PasswordAuthentication;

public class JAXRClient extends JAXRCommonClient {

  // ================================================
  com.sun.ts.tests.jaxr.common.JAXR_Util util = null;

  public static void main(String[] args) {
    JAXRClient theTests = new JAXRClient();
    Status s = theTests.run(args, System.out, System.err);
    s.exit();
  }

  /* Test setup */
  /*
   * @class.setup_props: jaxrPassword; jaxrUser; jaxrPassword2; jaxrUser2;
   * registryURL; queryManagerURL; authenticationMethod; providerCapability;
   * jaxrConnectionFactoryLookup; jaxrSecurityCredentialType; jaxrJNDIResource;
   * jaxrAlias; jaxrAlias2; jaxrAliasPassword; jaxrAlias2Password;
   */
  public void setup(String[] args, Properties p) throws Fault {
    try {
      super.setup(args, p);

    } catch (Exception e) {
      throw new Fault("setup failed:", e);
    }
  }

  public void cleanup() throws Fault {
    try {
      super.cleanup(); // close connection
    } catch (Exception e) {
      TestUtil.logErr("Cleanup error: " + e.toString());
      TestUtil.printStackTrace(e);
    } finally {
      // print out messages
      if (debug != null)
        TestUtil.logTrace(debug.toString());
    }
  }

  /*
   * @testName: saveException_ConstructorTest1
   *
   *
   * @assertion_ids: JAXR:JAVADOC:9;
   *
   * @assertion: SaveException- Constructs a JAXRException object with no reason
   * or embedded Throwable
   *
   * @test_Strategy: Create and verify SaveException.
   *
   */
  public void saveException_ConstructorTest1() throws Fault {
    String testName = "saveException_ConstructorTest1()";
    try {
      debug.add("Create and verify a SaveException instance\n");
      SaveException e = new SaveException();
      if (!(e instanceof SaveException))
        throw new Fault(testName + "failed to create SaveException instance");
      else
        debug.add("SaveException created successfully\n");
    } catch (Exception ue) {
      TestUtil.logErr("Caught unexpected exception: " + ue.getMessage());
      TestUtil.printStackTrace(ue);
      throw new Fault(testName + "failed", ue);
    }
  } // end of test method

  /*
   * @testName: saveException_ConstructorTest2
   *
   *
   * @assertion_ids: JAXR:JAVADOC:10;
   *
   * @assertion: SaveException(reason) - Constructs a JAXRException object with
   * the given String as the reason for the exception being thrown
   *
   * @test_Strategy: Create and verify SaveException, verify reason.
   *
   */
  public void saveException_ConstructorTest2() throws Fault {
    String testName = "saveException_ConstructorTest2";
    String reason = "test reason";
    boolean pass = true;
    try {
      debug.add("Create and verify a SaveException(reason)\n");
      SaveException e = new SaveException(reason);
      if (!(e instanceof SaveException)) {
        pass = false;
        debug.add(testName + " failed to create SaveException instance\n");
      } else
        debug.add("SaveException created successfully\n");

      if (!(e.getMessage().equals(reason))) {
        pass = false;
        debug.add(testName + " failed to return correct reason\n");
      } else
        debug.add("SaveException returned reason successfully\n");

    } catch (Exception ue) {
      TestUtil.logErr("Caught unexpected exception: " + ue.getMessage());
      TestUtil.printStackTrace(ue);
      throw new Fault(testName + "failed", ue);
    }
    if (!pass)
      throw new Fault(testName + " failed");
  } // end of test method

  /*
   * @testName: saveException_ConstructorTest3
   *
   *
   * @assertion_ids: JAXR:JAVADOC:11;
   *
   * @assertion: SaveException(reason, cause) - Constructs a JAXRException
   * object with the given String as the reason for the exception being thrown
   * and the given Throwable object as an embedded Throwable.
   *
   * @test_Strategy: Create and verify SaveException, verify reason and cause.
   *
   */
  public void saveException_ConstructorTest3() throws Fault {
    String testName = "saveException_ConstructorTest3()";
    String reason = "test reason";
    String cause = "test cause";
    boolean pass = true;
    try {
      Throwable tCause = new Throwable(cause);
      debug.add("Create and verify a SaveException(reason,cause)\n");
      SaveException e = new SaveException(reason, tCause);
      if (!(e instanceof SaveException)) {
        pass = false;
        debug.add(testName + " failed to create SaveException instance\n");
      } else
        debug.add("SaveException created successfully\n");
      if (!(e.getMessage().equals(reason))) {
        pass = false;
        debug.add(testName + " failed to return correct reason\n");
      } else
        debug.add("SaveException returned reason successfully\n");
      Throwable t = e.getCause();
      debug.add("Cause is: " + t.getMessage() + "\n");
      if (!(t.getMessage().equals(cause))) {
        pass = false;
        debug.add(testName + " failed to return valid Throwable\n");
      }
    } catch (Exception ue) {
      TestUtil.logErr("Caught unexpected exception: " + ue.getMessage());
      TestUtil.printStackTrace(ue);
      throw new Fault(testName + " failed", ue);
    }
    if (!pass)
      throw new Fault(testName + " failed");

  } // end of test method

  /*
   * @testName: saveException_ConstructorTest4
   *
   *
   * @assertion_ids: JAXR:JAVADOC:12;
   *
   * @assertion: SaveException(cause) - Constructs a JAXRException object
   * initialized with the given Exception object.
   *
   * @test_Strategy: Create and verify SaveException, verify cause.
   *
   */
  public void saveException_ConstructorTest4() throws Fault {
    String testName = "saveException_ConstructorTest4";
    String cause = "test cause";
    boolean pass = true;
    try {
      Throwable tCause = new Throwable(cause);
      debug.add("Create and verify a SaveException(cause)\n");
      SaveException e = new SaveException(tCause);
      if (!(e instanceof SaveException)) {
        pass = false;
        debug.add(testName + "failed to create  SaveException instance\n");
      } else
        debug.add("SaveException created successfully\n");

      Throwable t = e.getCause();
      debug.add("Cause is: " + t.getMessage() + "\n");
      if (!(t.getMessage().equals(cause))) {
        pass = false;
        debug.add(testName + " failed to return valid Throwable\n");
      }
    } catch (Exception ue) {
      TestUtil.logErr("Caught unexpected exception: " + ue.getMessage());
      TestUtil.printStackTrace(ue);
      throw new Fault(testName + "failed", ue);
    }
    if (!pass)
      throw new Fault(testName + " failed");

  } // end of test method

  /*
   * @testName: saveException_setGetErrorObjectKeyTest
   *
   *
   * @assertion_ids: JAXR:JAVADOC:17; JAXR:JAVADOC:19;
   *
   * @assertion: Key getErrorObjectKey - setErrorObjectKey(Key)
   *
   * @test_Strategy: Set ErrorObjectKey and verify with getErrorObjectKey.
   *
   */
  public void saveException_setGetErrorObjectKeyTest() throws Fault {
    String testName = "saveException_setGetErrorObjectKeyTest";
    String keyId = "uuid:C0B9FE13-179F-413D-8A5B-5004DB8E5BB2";
    boolean pass = true;
    try {
      debug.add("Set ErrorObjectKey and verify with getErrorObjectKey\n");
      Key key = blm.createKey(keyId);
      SaveException e = new SaveException();
      if (!(e instanceof SaveException)) {
        pass = false;
        debug.add(testName + "failed to create SaveException instance\n");
      } else
        debug.add("SaveException created successfully\n");
      e.setErrorObjectKey(key);
      if (!(e.getErrorObjectKey().getId().equals(keyId))) {
        pass = false;
        debug.add(testName + "failed to return ErrorObjectKey\n");
      } else
        debug.add("ErrorObjectKey returned successfully\n");

    } catch (Exception ue) {
      TestUtil.logErr("Caught unexpected exception: " + ue.getMessage());
      TestUtil.printStackTrace(ue);
      throw new Fault(testName + "failed", ue);
    }
    if (!pass)
      throw new Fault(testName + " failed");

  } // end of test method

} // end of class
