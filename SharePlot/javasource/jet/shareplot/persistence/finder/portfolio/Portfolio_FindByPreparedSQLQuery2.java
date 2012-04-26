package jet.shareplot.persistence.finder.portfolio;

import java.util.HashMap;
import java.util.Map;

import jet.framework.nuts.select.FinderMethod;

/**
 * Class for the findByPreparedSQLQuery FinderMethod object for the Portfolio component.
 *
 * Generated by JetTools, do not edit this file directly.
 */
public class Portfolio_FindByPreparedSQLQuery2 implements FinderMethod {
    String sqlWhereClause = null;
    Object[] sqlArguments = null;

    /**
     * Set sqlWhereClause argument value
     * @param sqlWhereClause argument value
     */
    public void setSqlWhereClause(final String sqlWhereClause) {
        this.sqlWhereClause = sqlWhereClause;
    }

    /**
     * Set sqlArguments argument value
     * @param sqlArguments argument value
     */
    public void setSqlArguments(final Object[] sqlArguments) {
        this.sqlArguments = new Object[sqlArguments.length];
        System.arraycopy(sqlArguments, 0, this.sqlArguments, 0, sqlArguments.length);
    }

    @Override
    public String getFinderName() {
        return "findByPreparedSQLQuery";
    }

    @Override
    public Map<String, Object> getArguments() {
        final Map<String, Object> args = new HashMap<String, Object>();
        args.put("sqlWhereClause", this.sqlWhereClause);
        args.put("sqlArguments", this.sqlArguments);
        return args;
    }
}