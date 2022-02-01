package com.patikapaycore.project.services.abstracts;


import com.patikapaycore.project.models.entities.Writer;

import java.util.List;

public interface WriterService {

    List<Writer> getAllWriter();

    Writer getByWriterId(Integer id);

    Writer addWriter(Writer writer);

    void updateWriter(Writer writer);

    boolean deleteWriter(Integer id);

}
