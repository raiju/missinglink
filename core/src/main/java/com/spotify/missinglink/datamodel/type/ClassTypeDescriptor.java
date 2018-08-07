/*
 * Copyright (c) 2015 Spotify AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.spotify.missinglink.datamodel.type;

import com.google.common.base.Preconditions;
import java.util.InputMismatchException;

public class ClassTypeDescriptor implements TypeDescriptor {

  private final String className;

  ClassTypeDescriptor(String className) {
    this.className = Preconditions.checkNotNull(className).replace('/', '.');
    if (className.endsWith(";")) {
      throw new InputMismatchException(
          "Got a signature where a class name was expected: " + className);
    }
  }

  public String getClassName() {
    return className;
  }

  @Override
  public String pretty() {
    return className;
  }

  @Override
  public String toString() {
    return pretty();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ClassTypeDescriptor that = (ClassTypeDescriptor) o;

    if (!className.equals(that.className)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return className.hashCode();
  }
}
