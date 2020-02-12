package ru.otus.spring.library.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class LookupValue {
    private String lookupType;
    private String language;
    private String lookupCode;
    private String meaning;
    private String description;
    private char enabledFlag;
    private Date startDateActive;
    private Date endDateActive;

    public LookupValue(String lookupType, String language, String lookupCode, String meaning, String description, char enabledFlag, Date startDateActive, Date endDateActive) {
        this.lookupType = lookupType;
        this.language = language;
        this.lookupCode = lookupCode;
        this.meaning = meaning;
        this.description = description;
        this.enabledFlag = enabledFlag;
        // Избавляемся от времени
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.startDateActive = (startDateActive == null)? new Date() : formatter.parse(formatter.format(startDateActive));
            this.endDateActive = (endDateActive == null)? new Date() : formatter.parse(formatter.format(endDateActive));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getLookupType() {
        return lookupType;
    }

    public String getLanguage() {
        return language;
    }

    public String getLookupCode() {
        return lookupCode;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getDescription() {
        return description;
    }

    public char getEnabledFlag() {
        return enabledFlag;
    }

    public Date getStartDateActive() {
        return startDateActive;
    }

    public Date getEndDateActive() {
        return endDateActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LookupValue)) return false;
        LookupValue that = (LookupValue) o;
        return enabledFlag == that.enabledFlag &&
                lookupType.equals(that.lookupType) &&
                language.equals(that.language) &&
                lookupCode.equals(that.lookupCode) &&
                Objects.equals(meaning, that.meaning) &&
                Objects.equals(description, that.description) &&
                Objects.equals(startDateActive, that.startDateActive) &&
                Objects.equals(endDateActive, that.endDateActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lookupType, language, lookupCode, meaning, description, enabledFlag, startDateActive, endDateActive);
    }
}
