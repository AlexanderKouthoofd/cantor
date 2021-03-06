/*
 * Copyright (c) 2020, Salesforce.com, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.cantor.common;

import com.salesforce.cantor.Namespaceable;

import java.io.IOException;

interface NamespaceableProvider<T extends Namespaceable> {
    // default scope is empty string, so '.<namespace>' goes to the default provider
    String DEFAULT_SCOPE = "";

    default String getScope() {
        return DEFAULT_SCOPE;
    }

    T getInstance() throws IOException;
}
