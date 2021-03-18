package de.percsi.webEngine.persistence.model;

import lombok.Value;

@Value
public class PagePModel {

  Long id;

  String pageId;

  String format;

  Boolean locked;

  String title;

  String text;

}
