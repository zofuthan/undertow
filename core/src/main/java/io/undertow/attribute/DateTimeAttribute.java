/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.undertow.attribute;

import java.util.Date;

import io.undertow.server.HttpServerExchange;
import io.undertow.util.DateUtils;

/**
 * The request status code
 *
 * @author Stuart Douglas
 */
public class DateTimeAttribute implements ExchangeAttribute {

    public static final String DATE_TIME_SHORT = "%t";
    public static final String DATE_TIME = "%{DATE_TIME}";

    public static final ExchangeAttribute INSTANCE = new DateTimeAttribute();

    private DateTimeAttribute() {

    }

    @Override
    public String readAttribute(final HttpServerExchange exchange) {
        return DateUtils.toCommonLogFormat(new Date());
    }

    @Override
    public void writeAttribute(final HttpServerExchange exchange, final String newValue) throws ReadOnlyAttributeException {
        throw new ReadOnlyAttributeException("Date time", newValue);
    }

    public static final class Builder implements ExchangeAttributeBuilder {

        @Override
        public String name() {
            return "Date Time";
        }

        @Override
        public ExchangeAttribute build(final String token) {
            if (token.equals(DATE_TIME) || token.equals(DATE_TIME_SHORT)) {
                return DateTimeAttribute.INSTANCE;
            }
            return null;
        }

        @Override
        public int priority() {
            return 0;
        }
    }
}
