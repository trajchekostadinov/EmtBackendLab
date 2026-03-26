package com.example.emtbackendlab.service.domain;
import com.example.emtbackendlab.model.views.BookView;

import java.util.List;

// lab2 - 4. za database view
public interface BookViewService {
    List<BookView> findAll();
}
