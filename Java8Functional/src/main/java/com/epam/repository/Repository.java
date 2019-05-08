package com.epam.repository;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    List<T> getRepositoryItems() throws IOException;
}