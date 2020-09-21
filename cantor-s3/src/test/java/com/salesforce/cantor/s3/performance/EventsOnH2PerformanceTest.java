/*
 * Copyright (c) 2020, Salesforce.com, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.cantor.s3.performance;

import com.amazonaws.auth.*;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.salesforce.cantor.Cantor;
import com.salesforce.cantor.common.performance.AbstractBaseEventsPerformanceTest;
import com.salesforce.cantor.s3.CantorOnS3;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Scanner;

@Test(enabled = false)
public class EventsOnH2PerformanceTest extends AbstractBaseEventsPerformanceTest {
    private static final String credentialsLocation = "/path/to/creds";

    @Override
    protected Cantor getCantor() throws IOException {
        final AmazonS3 s3Client = createS3Client();
        return new CantorOnS3(s3Client, "default");
    }

    // insert real S3 client here to run integration testing
    private AmazonS3 createS3Client() throws IOException {
        final File s3File = new File(credentialsLocation);
        try (final Scanner csvReader = new Scanner(new FileInputStream(s3File))) {
            csvReader.useDelimiter(",");

            final String keyId = csvReader.next();
            final String accessKey = csvReader.next();

            final AWSCredentials sessionCredentials = new BasicAWSCredentials(keyId, accessKey);
            return AmazonS3ClientBuilder.standard().withRegion(Regions.US_WEST_2)
                    .withCredentials(new AWSStaticCredentialsProvider(sessionCredentials))
                    .build();
        }
    }

    @Override
    public void testFewLargeEvents() throws IOException {
//        super.testFewLargeEvents();
    }

    @Override
    public void testFewSmallEvents() throws IOException {
//        super.testFewSmallEvents();
    }

    @Override
    public void testManyLargeEvents() throws IOException {
//        super.testManyLargeEvents();
    }
}
