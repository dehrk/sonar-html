/*
 * SonarSource HTML analyzer :: Sonar Plugin
 * Copyright (c) 2010-2021 SonarSource SA and Matthijs Galesloot
 * sonarqube@googlegroups.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sonar.plugins.html.checks.sonar;

import org.sonar.check.Rule;
import org.sonar.plugins.html.checks.AbstractPageCheck;
import org.sonar.plugins.html.node.TagNode;

@Rule(key = "FrameWithoutTitleCheck")
public class FrameWithoutTitleCheck extends AbstractPageCheck {

  @Override
  public void startElement(TagNode node) {
    if (isFrame(node) && !node.hasProperty("TITLE")) {
      createViolation(node, "Add a \"title\" attribute to this <" + node.getNodeName() + "> tag.");
    }
  }

  private static boolean isFrame(TagNode node) {
    return "FRAME".equalsIgnoreCase(node.getNodeName()) ||
      "IFRAME".equalsIgnoreCase(node.getNodeName());
  }

}
