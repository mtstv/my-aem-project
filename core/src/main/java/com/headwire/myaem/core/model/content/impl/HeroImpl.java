package com.headwire.myaem.core.model.content.impl;

import com.adobe.cq.sightly.WCMUsePojo;
import com.headwire.myaem.core.model.content.Hero;


public class HeroImpl extends WCMUsePojo implements Hero {

  private String text;

  @Override
  public void activate() throws Exception {
    text = getProperties().get("text", "Hero callout:");
  }

  @Override
  public String getText() {
    return this.text;
  }

}
