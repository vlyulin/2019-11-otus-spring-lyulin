package ru.otus.spring.library.dao;

import ru.otus.spring.library.domain.LookupValue;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LookupValueDao {

    void insert(LookupValue lookupValue);

    LookupValue getByLookupCode(String lookupType, String lookupCode);

    LookupValue getByLookupCode(String lookupType, String lookupCode, Date onDate);

    List<LookupValue> getAll(String lookupType);
    Map<String,LookupValue> getLookupTypeValues(String lookupType);

    void deleteByLookupCode(String lookupType, String lookupCode, String language);
}
