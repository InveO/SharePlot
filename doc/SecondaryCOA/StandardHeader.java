package jet.amanda.util.printout.header;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.eclipse.jdt.annotation.NonNull;

import jet.container.managers.locale.interfaces.LocalizedTextContext;
import jet.container.managers.session.interfaces.Session;
import jet.framework.manager.itext.interfaces.ITextConstraints;
import jet.framework.manager.itext.interfaces.ITextConstraints.HORIZONTAL_ALIGNMENT;
import jet.framework.manager.itext.interfaces.ITextConstraints.VERTICAL_ALIGNMENT;
import jet.framework.manager.itext.interfaces.ITextElementText;
import jet.framework.manager.itext.interfaces.ITextGroup;
import jet.framework.manager.itext.interfaces.ITextManagerContext;
import jet.framework.util.manager.ManagerHelper;
import jet.framework.util.text.CharConstants;
import jet.framework.util.text.DateUtilities;
import jet.java.util.JETLocale;
import jet.util.JetVersion;
import jet.util.logger.JETLevel;
import jet.util.logger.Logger;
import jet.util.throwable.JETException;

/**
 * @author cwelle
 *
 *         Used to construct header
 */
public class StandardHeader {

    private Logger logger;
    private ITextManagerContext iTextManagerContext;
    private final SimpleDateFormat dateFormatLong = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final SimpleDateFormat dateFormatShort = new SimpleDateFormat("dd/MM/yyyy");
    private ITextGroup headerGroup;
    private LocalizedTextContext localizedTextContext;
    @NonNull
    private final JETLocale locale;
    private final JetVersion jetVersion;

    /**
     * Constructor
     *
     * @param businessUnitName Business Unit Name
     * @param periodStart
     * @param periodEnd
     * @param title Title of the printout
     * @param params params
     * @param locale
     * @param logger
     * @param version
     * @param session
     * @throws NamingException
     */
    public StandardHeader(final String businessUnitName, final Date periodStart, final Date periodEnd, final String title, final String params, @NonNull final JETLocale locale, final Logger logger, final JetVersion version, @NonNull final Session session) throws NamingException {
        this.jetVersion = version;
        this.locale = locale;

        initStandardHeader(logger);

        createHeader(businessUnitName, periodStart, periodEnd, title, params, session);
    }

    /**
     * @param businessUnitName
     * @param periodStart
     * @param periodEnd
     * @param title
     * @param localizedTitle
     * @param args
     * @param locale
     * @param logger
     * @param version
     * @param session
     * @throws NamingException
     */
    public StandardHeader(final String businessUnitName, final Date periodStart, final Date periodEnd, final String title, final String localizedTitle, final Map<String, String> args, @NonNull final JETLocale locale, final Logger logger, final JetVersion version, @NonNull final Session session) throws NamingException {
        this.jetVersion = version;
        this.locale = locale;
        initStandardHeader(logger);

        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, String> entry : args.entrySet()) {
            sb.append(entry.getKey());
            final String value = entry.getValue();
            if (value != null && value.length() > 0) {
                sb.append(" [");
                sb.append(value);
                sb.append("]; ");
            } else {
                sb.append("; ");
            }
        }
        final String params = sb.toString();
        String titleText = title;
        if (localizedTitle != null) {
            try {
                titleText = this.localizedTextContext.getText(localizedTitle, this.locale);
            } catch (final JETException e) {
                this.logger.logp(JETLevel.SEVERE, "StandardHeader", "StandardHeader", e.getMessage(), e);
            }
        }
        createHeader(businessUnitName, periodStart, periodEnd, titleText, params, session);
    }

    /**
     * @param businessUnitName
     * @param periodStart
     * @param periodEnd
     * @param title
     * @param localizedTitle
     * @param args
     * @param locale
     * @param logger
     * @param version
     * @param session
     * @throws NamingException
     */
    public StandardHeader(final String businessUnitName, final Date periodStart, final Date periodEnd, final String title, final String localizedTitle, final List<HeaderArg> args, @NonNull final JETLocale locale, final Logger logger, final JetVersion version, @NonNull final Session session) throws NamingException {
        this.jetVersion = version;
        this.locale = locale;
        initStandardHeader(logger);

        final StringBuilder sb = new StringBuilder();
        final int size = args.size();
        for (int i = 0; i < size; i++) {
            final HeaderArg headerArg = args.get(i);
            sb.append(headerArg.getKey());
            final String value = headerArg.getValue();
            if (value != null && value.length() > 0) {
                sb.append(" [");
                sb.append(value);
                sb.append("]; ");
            } else {
                sb.append("; ");
            }
        }
        final String params = sb.toString();
        String titleText = title;
        if (localizedTitle != null) {
            try {
                titleText = this.localizedTextContext.getText(localizedTitle, this.locale);
            } catch (final JETException e) {
                this.logger.logp(JETLevel.SEVERE, "StandardHeader", "StandardHeader", e.getMessage(), e);
            }
        }
        createHeader(businessUnitName, periodStart, periodEnd, titleText, params, session);
    }

    /**
     * @param businessUnitName
     * @param periodStart
     * @param periodEnd
     * @param title
     * @param localizedTitle
     * @param accountNumber
     * @param description
     * @param args
     * @param locale
     * @param logger
     * @param version
     * @param session
     * @throws NamingException
     */
    public StandardHeader(final String businessUnitName, final Date periodStart, final Date periodEnd, final String title, final String localizedTitle, final String accountNumber, final String description, final Map<String, String> args, @NonNull final JETLocale locale, final Logger logger, final JetVersion version, @NonNull final Session session) throws NamingException {
        this.jetVersion = version;
        this.locale = locale;
        initStandardHeader(logger);

        StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, String> entry : args.entrySet()) {
            sb.append(entry.getKey());
            final String value = entry.getValue();
            if (value != null && value.length() > 0) {
                sb.append(" [");
                sb.append(value);
                sb.append("]; ");
            }
        }
        final String params = sb.toString();
        String titleText = title;
        if (localizedTitle != null) {
            try {
                titleText = this.localizedTextContext.getText(localizedTitle, this.locale);
            } catch (final JETException e) {
                this.logger.logp(JETLevel.SEVERE, "StandardHeader", "StandardHeader", e.getMessage(), e);
            }
        }

        sb = new StringBuilder();
        sb.append(titleText);
        sb.append(CharConstants.WHITE_SPACE.getValue());
        sb.append(accountNumber);
        if (description != null) {
            sb.append(" : ");
            sb.append(description);
        }

        createHeader(businessUnitName, periodStart, periodEnd, sb.toString(), params, session);
    }

    /**
     * @param businessUnitName
     * @param periodStart
     * @param periodEnd
     * @param title
     * @param localizedTitle
     * @param args
     * @param endDate
     * @param isDraft
     * @param locale
     * @param logger
     * @param version
     * @param session
     * @throws NamingException
     */
    public StandardHeader(final String businessUnitName, final Date periodStart, final Date periodEnd, final String title, final String localizedTitle, final Map<String, String> args, final Date endDate, final boolean isDraft, @NonNull final JETLocale locale, final Logger logger, final JetVersion version, @NonNull final Session session) throws NamingException {
        this.jetVersion = version;
        this.locale = locale;
        initStandardHeader(logger);

        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, String> entry : args.entrySet()) {
            sb.append(entry.getKey());
            final String value = entry.getValue();
            if (value != null && value.length() > 0) {
                sb.append(" [");
                sb.append(value);
                sb.append("]; ");
            } else {
                sb.append("; ");
            }
        }

        String titleText = title;
        if (localizedTitle != null) {
            try {
                titleText = this.localizedTextContext.getText(localizedTitle, this.locale);
                sb.append('\n');
                final String endDateTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.endDate", locale);
                sb.append(endDateTitle);
                sb.append(CharConstants.WHITE_SPACE.getValue());
                sb.append(this.dateFormatShort.format(endDate));
                sb.append('\n');
                String isDraftTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.isDraft", locale);
                if (!isDraft) {
                    isDraftTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.isNotDraft", locale);
                }
                sb.append(isDraftTitle);
            } catch (final JETException e) {
                this.logger.logp(JETLevel.SEVERE, "StandardHeader", "StandardHeader", e.getMessage(), e);
            }
        }
        final String params = sb.toString();
        createHeader(businessUnitName, periodStart, periodEnd, titleText, params, session);
    }

    /**
     * @param businessUnitName
     * @param periodStart
     * @param periodEnd
     * @param title
     * @param localizedTitle
     * @param args
     * @param initialDate
     * @param endDate
     * @param isDraft
     * @param locale
     * @param logger
     * @param version
     * @param session
     * @throws NamingException
     */
    public StandardHeader(final String businessUnitName, final Date periodStart, final Date periodEnd, final String title, final String localizedTitle, final Map<String, String> args, final Date initialDate, final Date endDate, final boolean isDraft, @NonNull final JETLocale locale, final Logger logger, final JetVersion version, @NonNull final Session session) throws NamingException {
        this.jetVersion = version;
        this.locale = locale;
        initStandardHeader(logger);

        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, String> entry : args.entrySet()) {
            sb.append(entry.getKey());
            final String value = entry.getValue();
            if (value != null && value.length() > 0) {
                sb.append(" [");
                sb.append(value);
                sb.append("]; ");
            } else {
                sb.append("; ");
            }
        }

        String titleText = title;
        if (localizedTitle != null) {
            try {
                titleText = this.localizedTextContext.getText(localizedTitle, this.locale);
                sb.append('\n');
                final String initialDateTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.initialDate", locale);
                sb.append(initialDateTitle);
                sb.append(CharConstants.WHITE_SPACE.getValue());
                sb.append(this.dateFormatShort.format(initialDate));
                sb.append(CharConstants.WHITE_SPACE.getValue());
                final String endDateTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.endDate", locale);
                sb.append(endDateTitle);
                sb.append(CharConstants.WHITE_SPACE.getValue());
                sb.append(this.dateFormatShort.format(endDate));
                sb.append('\n');
                String isDraftTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.isDraft", locale);
                if (!isDraft) {
                    isDraftTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.isNotDraft", locale);
                }
                sb.append(isDraftTitle);
            } catch (final JETException e) {
                this.logger.logp(JETLevel.SEVERE, "StandardHeader", "StandardHeader", e.getMessage(), e);
            }
        }
        final String params = sb.toString();
        createHeader(businessUnitName, periodStart, periodEnd, titleText, params, session);
    }

    /**
     * @param businessUnitName
     * @param periodStart
     * @param periodEnd
     * @param title
     * @param localizedTitle
     * @param args
     * @param initialDate
     * @param endDate
     * @param isDraft
     * @param mustPrintBlankAccount
     * @param locale
     * @param logger
     * @param version
     * @param session
     * @throws NamingException
     */
    public StandardHeader(final String businessUnitName, final Date periodStart, final Date periodEnd, final String title, final String localizedTitle, final Map<String, String> args, final Date initialDate, final Date endDate, final boolean isDraft, final boolean mustPrintBlankAccount, @NonNull final JETLocale locale, final Logger logger, final JetVersion version, @NonNull final Session session) throws NamingException {
        this.jetVersion = version;
        this.locale = locale;
        initStandardHeader(logger);

        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, String> entry : args.entrySet()) {
            sb.append(entry.getKey());
            final String value = entry.getValue();
            if (value != null && value.length() > 0) {
                sb.append(" [");
                sb.append(value);
                sb.append("]; ");
            } else {
                sb.append("; ");
            }
        }

        String titleText = title;
        if (localizedTitle != null) {
            try {
                titleText = this.localizedTextContext.getText(localizedTitle, this.locale);
                sb.append('\n');
                final String initialDateTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.initialDate", locale);
                sb.append(initialDateTitle);
                sb.append(CharConstants.WHITE_SPACE.getValue());
                sb.append(this.dateFormatShort.format(initialDate));
                sb.append(CharConstants.WHITE_SPACE.getValue());
                final String endDateTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.endDate", locale);
                sb.append(endDateTitle);
                sb.append(CharConstants.WHITE_SPACE.getValue());
                sb.append(this.dateFormatShort.format(endDate));
                sb.append('\n');
                String isDraftTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.isDraft", locale);
                if (!isDraft) {
                    isDraftTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.isNotDraft", locale);
                }
                sb.append(isDraftTitle);
                String mustPrintBlankAccountTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.printBlankAccount", locale);
                if (!mustPrintBlankAccount) {
                    mustPrintBlankAccountTitle = this.localizedTextContext.getText("Amanda/properties/task/Financial/printout.notPrintBlankAccount", locale);
                }
                sb.append('\n');
                sb.append(mustPrintBlankAccountTitle);
            } catch (final JETException e) {
                this.logger.logp(JETLevel.SEVERE, "StandardHeader", "StandardHeader", e.getMessage(), e);
            }
        }
        final String params = sb.toString();
        createHeader(businessUnitName, periodStart, periodEnd, titleText, params, session);
    }

    private void initStandardHeader(final Logger logger1) throws NamingException {
        this.logger = logger1;
        try {
            this.localizedTextContext = (LocalizedTextContext) ManagerHelper.getContext(LocalizedTextContext.NAME);
        } catch (final NamingException e) {
            this.logger.logp(JETLevel.SEVERE, "StandardHeader", "initStandardHeader", e.getMessage(), e);
        }

        this.iTextManagerContext = (ITextManagerContext) ManagerHelper.getContext(ITextManagerContext.NAME);
        this.headerGroup = this.iTextManagerContext.createITextGroup();
    }

    private void createHeader(final String businessUnitName, final Date periodStart, final Date periodEnd, final String title, final String params, @NonNull final Session session) {
        // left part
        final ITextGroup leftGroup = this.iTextManagerContext.createITextGroup();
        final ITextElementText businessText = this.iTextManagerContext.createITextElementText(businessUnitName);
        businessText.setFontSize(10);
        ITextConstraints iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, 0, 1, 1);
        leftGroup.addElement(businessText, iTextConstraints);
        // sb.append("Period ");
        final StringBuilder sb = new StringBuilder();
        if (periodStart != null && periodEnd != null) {
            final String accountPeriodFrom = this.dateFormatShort.format(periodStart);
            final String accountPeriodTo = this.dateFormatShort.format(periodEnd);
            sb.append(accountPeriodFrom);
            sb.append(" - ");
            sb.append(accountPeriodTo);
        }
        final ITextElementText accountPeriodText = this.iTextManagerContext.createITextElementText(sb.toString());
        accountPeriodText.setFontSize(10);
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 1, 0, 1, 1);
        leftGroup.addElement(accountPeriodText, iTextConstraints);

        // middle part
        final ITextGroup middleGroup = this.iTextManagerContext.createITextGroup();
        final ITextElementText titleText = this.iTextManagerContext.createITextElementText(title);
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.CENTER, 0, 0, 1, 1);
        middleGroup.addElement(titleText, iTextConstraints);
        final ITextElementText paramsText = this.iTextManagerContext.createITextElementText(params);
        paramsText.setFontSize(8);
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.CENTER, 1, 0, 1, 1);
        middleGroup.addElement(paramsText, iTextConstraints);

        // right part
        final ITextGroup rightGroup = this.iTextManagerContext.createITextGroup();
        final Date date = DateUtilities.newUserDate(session);
        final String currentDate = this.dateFormatLong.format(date);
        final StringBuilder amandaver = new StringBuilder();
        amandaver.append("Amanda v.");
        amandaver.append(this.jetVersion.getVersion());
        amandaver.append(CharConstants.WHITE_SPACE.getValue());
        amandaver.append(this.jetVersion.getTime());
        final ITextElementText amandaText = this.iTextManagerContext.createITextElementText(amandaver.toString());
        amandaText.setFontSize(8);
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.RIGHT, 0, 0, 1, 1);
        rightGroup.addElement(amandaText, iTextConstraints);
        final ITextElementText dateText = this.iTextManagerContext.createITextElementText(currentDate);
        dateText.setFontSize(8);
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.RIGHT, 1, 0, 1, 1);
        rightGroup.addElement(dateText, iTextConstraints);

        // construct header
        final ITextGroup globalGroup = this.iTextManagerContext.createITextGroup();
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, 0, 1, 1);
        globalGroup.addElement(leftGroup, iTextConstraints);
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.CENTER, 0, 1, 1, 1);
        globalGroup.addElement(middleGroup, iTextConstraints);
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.RIGHT, 0, 2, 1, 1);
        globalGroup.addElement(rightGroup, iTextConstraints);
        final float[] width = { 1f, 1f, 1f };
        globalGroup.setWidthColumns(width);
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, 0, 1, 1);

        this.headerGroup.addElement(globalGroup, iTextConstraints);

        // ITextElementText titleText = this.iTextManagerContext.createITextElementText(title);
        // iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.CENTER, 1, 0, 1, 1);
        // this.headerGroup.addElement(titleText, iTextConstraints);
    }

    /**
     * @return the header group
     */
    public ITextGroup getHeader() {
        return this.headerGroup;
    }
}
