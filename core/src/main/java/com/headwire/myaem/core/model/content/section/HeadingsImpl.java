package com.headwire.myaem.core.model.content.section;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


@Model(adaptables = SlingHttpServletRequest.class)
public class HeadingsImpl implements Headings {

  private final SlingHttpServletRequest request;
  private String text;

  public HeadingsImpl(final SlingHttpServletRequest request) {
    this.request = request;
  }

  @PostConstruct
  private void setup() {
    final Resource resource = request.getResource();
    final ResourceResolver resourceResolver = resource.getResourceResolver();
    final PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
    final Page containingPage = pageManager.getContainingPage(resource);
    this.text = containingPage.getTitle();
  }

  @Override
  public String getText() {
    return this.text;
  }
}
