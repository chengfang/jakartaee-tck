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

// This class was generated by the JAXRPC RI, do not edit.
// Contents subject to change without notice.
// JAX-RPC Reference Implementation (1.1, build EA-R13)

package com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest;

public interface HolderTest extends java.rmi.Remote {
  public void echoInOutSimpleTypes(javax.xml.rpc.holders.StringHolder varString,
      javax.xml.rpc.holders.BigIntegerHolder varInteger,
      javax.xml.rpc.holders.IntHolder varInt,
      javax.xml.rpc.holders.LongHolder varLong,
      javax.xml.rpc.holders.ShortHolder varShort,
      javax.xml.rpc.holders.BigDecimalHolder varDecimal,
      javax.xml.rpc.holders.FloatHolder varFloat,
      javax.xml.rpc.holders.DoubleHolder varDouble,
      javax.xml.rpc.holders.BooleanHolder varBoolean,
      javax.xml.rpc.holders.ByteHolder varByte,
      javax.xml.rpc.holders.QNameHolder varQName,
      javax.xml.rpc.holders.CalendarHolder varDateTime)
      throws java.rmi.RemoteException;

  public void echoInOutSimpleTypesArray(
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfstringHolder varString,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfintegerHolder varInteger,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfintHolder varInt,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOflongHolder varLong,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfshortHolder varShort,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfdecimalHolder varDecimal,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOffloatHolder varFloat,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfdoubleHolder varDouble,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfbooleanHolder varBoolean,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfbyteHolder varByte,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfQNameHolder varQName,
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfdateTimeHolder varDateTime)
      throws java.rmi.RemoteException;

  public void echoInOutBook(
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.BookHolder varBook)
      throws java.rmi.RemoteException;

  public void echoInOutBookArray(
      com.sun.ts.tests.jaxrpc.ee.wsi.rpc.literal.holdertest.holders.ArrayOfBookHolder varBook)
      throws java.rmi.RemoteException;
}
