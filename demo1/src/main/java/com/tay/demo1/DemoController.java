/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @author  Aiyun Tang
 * @mail aiyun.tang@gmail.com
 */
package com.tay.demo1;

import com.tay.redislimiter.RateLimiter;
import com.tay.redislimiter.dynamic.DynamicRateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    @RateLimiter(base = "#Headers['userid']", permits = 2, timeUnit = TimeUnit.MINUTES)
    public String test() {
        return "test!";
    }

    @GetMapping("/dynamictest")
    @DynamicRateLimiter(base = "#Headers['userid']", permits = 5, timeUnit = TimeUnit.MINUTES)
    public String dynamicTest() {
        return "dynamictest!";
    }

}
