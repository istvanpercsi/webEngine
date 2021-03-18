package de.percsi.webEngine.persistence.iface;

import de.percsi.webEngine.persistence.model.PagePModel;
import io.vavr.control.Option;

public interface PageIf {

  Option<PagePModel> create(PagePModel pagePModel);

  Option<PagePModel> read(String pageId);

  Option<PagePModel> save(PagePModel pagePModel);

  void delete(String pageId);


}
