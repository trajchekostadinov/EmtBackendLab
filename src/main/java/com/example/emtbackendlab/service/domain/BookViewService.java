package com.example.emtbackendlab.service.domain;
import com.example.emtbackendlab.model.views.BookView;

import java.util.List;

public interface BookViewService {
    List<BookView> findAll();
}
