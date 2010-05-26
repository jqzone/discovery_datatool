package com.t11e.discovery.datatool;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class SqlTemplate
{
  private Set<String> filter;
  private String action;
  private String query;
  private String idColumn;
  private String idPrefix;
  private String idSuffix;
  private Set<String> jsonColumnNames;
  private boolean useLowerCaseColumnNames;

  public Set<String> getFilter()
  {
    return filter;
  }
  public void setFilter(final Set<String> filter)
  {
    this.filter = filter;
  }
  public void setFilter(final String filters)
  {
    final String[] tokens = StringUtils.split(filters, ", ");
    if (tokens == null)
    {
      this.filter = Collections.emptySet();
    }
    else
    {
      this.filter = new HashSet<String>(Arrays.asList(tokens));
    }
  }
  public String getAction()
  {
    return action;
  }
  public void setAction(final String action)
  {
    this.action = action;
  }
  public String getQuery()
  {
    return query;
  }
  public void setQuery(final String query)
  {
    this.query = query;
  }
  public void setIdColumn(final String idColumn)
  {
    this.idColumn = idColumn;
  }
  public String getIdColumn()
  {
    return idColumn;
  }
  public String getIdPrefix()
  {
    return idPrefix;
  }
  public void setIdPrefix(final String idPrefix)
  {
    this.idPrefix = idPrefix;
  }
  public String getIdSuffix()
  {
    return idSuffix;
  }
  public void setIdSuffix(final String idSuffix)
  {
    this.idSuffix = idSuffix;
  }
  public Set<String> getJsonColumnNames()
  {
    return jsonColumnNames;
  }
  public void setJsonColumnNames(final String jsonColumnNames)
  {
    this.jsonColumnNames = new HashSet<String>(
        Arrays.asList(StringUtils.split(jsonColumnNames, ", ")));
  }
  public void setJsonColumnNames(final Set<String> jsonColumnNames)
  {
    this.jsonColumnNames = jsonColumnNames;
  }
  public boolean isUseLowerCaseColumnNames()
  {
    return useLowerCaseColumnNames;
  }
  public void setUseLowerCaseColumnNames(final boolean useLowerCaseColumnNames)
  {
    this.useLowerCaseColumnNames = useLowerCaseColumnNames;
  }
}