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
package io.dekorate.component.model;

import io.dekorate.crd.annotation.CustomResource;
import io.dekorate.deps.jackson.annotation.JsonInclude;
import io.dekorate.deps.jackson.annotation.JsonPropertyOrder;
import io.dekorate.deps.kubernetes.api.model.Doneable;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.Inline;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "deploymentMode",
  "runtime",
  "version",
  "exposeService",
  "storage",
  "envs",
  "buildConfig"
})
@Buildable(editableEnabled = false, builderPackage = "io.dekorate.deps.kubernetes.api.builder", inline = @Inline(type = Doneable.class, prefix = "Doneable", value = "done"))
@VelocityTransformations({
  @VelocityTransformation(value = "/component-resource.vm"),
  @VelocityTransformation(value = "/component-resource-list.vm"),
  @VelocityTransformation(value = "/component-status.vm"),
})
@CustomResource(group = "devexp.runtime.redhat.com", version = "v1alpha2")
public class ComponentSpec {

  private DeploymentMode deploymentMode;
  private String runtime;
  private String version;
  private boolean exposeService;
  private Integer port;
  private Storage storage;
  private Env[] envs;
  private BuildConfig buildConfig;

  public ComponentSpec() {
  }

  public ComponentSpec(DeploymentMode deploymentMode, String runtime, String version, boolean exposeService, Integer port, Storage storage, Env[] envs, BuildConfig buildConfig) {
    this.deploymentMode = deploymentMode;
    this.runtime = runtime;
    this.version = version;
    this.exposeService = exposeService;
    this.port = port;
    this.storage = storage;
    this.envs = envs;
    this.buildConfig = buildConfig;
  }

  public DeploymentMode getDeploymentMode() {
    return deploymentMode;
  }

  public void setDeploymentMode(DeploymentMode deploymentMode) {
    this.deploymentMode = deploymentMode;
  }

  public String getRuntime() {
    return runtime;
  }

  public void setRuntime(String runtime) {
    this.runtime = runtime;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public boolean isExposeService() {
    return exposeService;
  }

  public void setExposeService(boolean exposeService) {
    this.exposeService = exposeService;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  public Storage getStorage() {
    return storage;
  }

  public void setStorage(Storage storage) {
    this.storage = storage;
  }

  public Env[] getEnvs() {
    return envs;
  }

  public void setEnvs(Env[] envs) {
    this.envs = envs;
  }

  public BuildConfig getBuildConfig() {
    return buildConfig;
  }

  public void setBuildConfig(BuildConfig buildConfig) {
    this.buildConfig = buildConfig;
  }
}
