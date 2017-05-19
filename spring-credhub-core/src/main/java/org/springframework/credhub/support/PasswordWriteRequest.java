/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.credhub.support;

import org.springframework.util.Assert;

import static org.springframework.credhub.support.ValueType.PASSWORD;

/**
 * The details of a request to write a new or update an existing password credential in CredHub.
 *
 * @author Scott Frederick
 */
public class PasswordWriteRequest extends WriteRequest<PasswordCredential> {
	/**
	 * Create a builder that provides a fluent API for providing the values required
	 * to construct a {@link PasswordWriteRequest}.
	 *
	 * @return a builder
	 */
	public static PasswordWriteRequestBuilder builder() {
		return new PasswordWriteRequestBuilder();
	}

	/**
	 * A builder that provides a fluent API for constructing {@link PasswordWriteRequest}s.
	 */
	public static class PasswordWriteRequestBuilder
			extends WriteRequestBuilder<PasswordCredential, PasswordWriteRequest, PasswordWriteRequestBuilder> {
		@Override
		protected PasswordWriteRequest createTarget() {
			return new PasswordWriteRequest();
		}

		@Override
		protected PasswordWriteRequestBuilder createBuilder() {
			return this;
		}

		/**
		 * Set the value of a password credential. A password credential consists of
		 * a single string value. The type of the credential is set to {@link ValueType#PASSWORD}.
		 *
		 * @param value the credential value; must not be {@literal null}
		 * @return the builder
		 */
		public PasswordWriteRequestBuilder value(PasswordCredential value) {
			Assert.notNull(value, "value must not be null");
			targetObj.setType(PASSWORD);
			targetObj.setValue(value);
			return this;
		}
	}

}
