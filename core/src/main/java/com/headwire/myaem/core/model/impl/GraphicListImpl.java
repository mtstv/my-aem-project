package com.headwire.myaem.core.model.impl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.headwire.myaem.core.model.GraphicList;

@Model(adaptables = Resource.class, adapters = GraphicList.class)
public class GraphicListImpl implements GraphicList {

  @Inject
  private String text;

  /**
   * This is called after all the injection has occurred
   */
  @PostConstruct
  private void postConstructMethod() {
  }

  @Override
  public String getText() {
    return this.text;
  }
}
