package de.percsi.webEngine.controller.api;

import de.percsi.webEngine.controller.model.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PagesApiDelegateImpl implements PagesApiDelegate {

  @Override
  public ResponseEntity<Page> getPage(String pageId) {
    Page page = new Page();
    page.setId(1L);
    page.setPageId("introduction");
    page.setFormat(Page.FormatEnum.MD);
    page.setText("# Hello World");
    return ResponseEntity.ok(page);

  }
}
