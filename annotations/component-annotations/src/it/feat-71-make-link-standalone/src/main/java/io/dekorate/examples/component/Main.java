/**
 * Copyright 2018 The original authors.
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

package io.dekorate.examples.component;

import io.dekorate.component.annotation.Link;
import io.dekorate.component.annotation.ComponentApplication;
import io.dekorate.component.model.DeploymentMode;
import io.dekorate.kubernetes.annotation.Env;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.Port;

@KubernetesApplication(ports = @Port(name = "http", containerPort = 8080))
@ComponentApplication(name = "hello-world", deploymentMode = DeploymentMode.build, exposeService = true, envs = @Env(name = "key1", value = "val1"))
@Link(name = "hello-world", componentName = "target", envs = @Env(name = "key1", value = "val1"))
public class Main {

  public static void main(String[] args) {
  }

}

