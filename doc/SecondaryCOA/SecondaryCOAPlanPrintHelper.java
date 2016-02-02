package jet.amanda.ac.printout.listing;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import jet.amanda.ac.bo.businessunit.BusinessUnit;
import jet.amanda.ac.bo.exercise.Exercise;
import jet.amanda.ac.bo.exercise.ExerciseBOApplicationComponent;
import jet.amanda.ac.financial.FinancialACConstants;
import jet.amanda.persistence.pojo.AccountPlanItem;
import jet.amanda.ui.task.financial.secondaryCOA.AccountBalanceConstants;
import jet.amanda.util.printout.header.StandardHeader;
import jet.container.managers.file.interfaces.FileManagerContext;
import jet.container.managers.locale.interfaces.LocalizedTextContext;
import jet.container.managers.session.interfaces.Session;
import jet.container.managers.ui.interfaces.UIContext;
import jet.framework.manager.itext.interfaces.ITextCommons.BORDER_LINE;
import jet.framework.manager.itext.interfaces.ITextConstraints;
import jet.framework.manager.itext.interfaces.ITextConstraints.HORIZONTAL_ALIGNMENT;
import jet.framework.manager.itext.interfaces.ITextConstraints.VERTICAL_ALIGNMENT;
import jet.framework.manager.itext.interfaces.ITextDocument;
import jet.framework.manager.itext.interfaces.ITextDocument.DOCUMENT_ORIENTATION;
import jet.framework.manager.itext.interfaces.ITextElement;
import jet.framework.manager.itext.interfaces.ITextElementImage;
import jet.framework.manager.itext.interfaces.ITextElementText;
import jet.framework.manager.itext.interfaces.ITextElementText.FONT_FAMILY;
import jet.framework.manager.itext.interfaces.ITextElementText.FONT_STYLE;
import jet.framework.manager.itext.interfaces.ITextGroup;
import jet.framework.manager.itext.interfaces.ITextManagerContext;
import jet.framework.manager.itext.interfaces.ITextPageNumber;
import jet.framework.ui.utils.CommonDisplayModelConstants;
import jet.framework.ui.utils.treetable.ListTreeTableContentProvider;
import jet.framework.ui.utils.treetable.ListTreeTableRendererProvider;
import jet.framework.util.manager.ManagerHelper;
import jet.framework.util.models.ModelHelper;
import jet.java.util.JETLocale;
import jet.util.JetVersion;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.models.interfaces.Displayable;
import jet.util.models.interfaces.Model;
import jet.util.models.interfaces.ModelList;
import jet.util.throwable.JETException;

/**
 * Secondary COA printout.
 *
 * @author cwelle
 *
 */
public class SecondaryCOAPlanPrintHelper {
    private static final String TITLE_ACCOUNT_NODE = "jet.amanda.ui.task.financial.SecondaryAccountPlanNut.TITLE_ACCOUNT_NODE";

    private ITextManagerContext iTextManagerContext;
    @NonNull
    private final BusinessUnit currentBusinessUnit;
    private final ListTreeTableContentProvider listTreeTableContentProvider;
    @NonNull
    private final JETLocale locale;
    @NonNull
    private final Session session;
    private final ITextDocument invoice;
    private int nextRow = 0;
    private ITextGroup iTextGroupDetails;
    private byte[] iconAccount;
    private byte[] iconTitleAccount;
    private final Logger logger;
    private final Comparator<Model> comparator;
    private final List<Model> columnList = new ArrayList<Model>();
    private final boolean isDraft;
    private final Date endDate;
    private LocalizedTextContext localizedTextContext;
    private final String localizedTitle;
    private final String title;
    private final JetVersion version;
    private final Map<String, String> substitutionMap;

    private final NumberFormat numberFormat;

    /**
     * Create a show invoice printout.
     *
     * @param currentBusinessUnit
     * @param listTreeContentProvider
     * @param listTreeRenderProvider
     * @param comparator
     * @param locale
     * @param session
     * @param applicationName
     * @param isDraft
     * @param endDate
     * @param localizedTitle
     * @param title
     * @param substitutionMap
     */
    public SecondaryCOAPlanPrintHelper(@NonNull final BusinessUnit currentBusinessUnit, final ListTreeTableContentProvider listTreeContentProvider, final ListTreeTableRendererProvider listTreeRenderProvider, final Model listDisplayModel, final Comparator<Model> comparator, @NonNull final JETLocale locale, @NonNull final Session session, final String applicationName, final Date endDate, final boolean isDraft, final String title, final String localizedTitle, final JetVersion version,
            @Nullable final Map<String, String> substitutionMap) {
        this.version = version;
        this.locale = locale;
        this.substitutionMap = substitutionMap;
        this.logger = JETLoggerManager.getJETLoggerManager().getLogger("jet.amanda.ac.printout.listing");
        // this.totalDebitCreditCellProvider = totalDebitCreditCellProvider;
        try {
            this.iTextManagerContext = (ITextManagerContext) ManagerHelper.getContext(ITextManagerContext.NAME);
            this.localizedTextContext = (LocalizedTextContext) ManagerHelper.getContext(LocalizedTextContext.NAME);

            final FileManagerContext fileCtxt = (FileManagerContext) ManagerHelper.getContext(FileManagerContext.NAME);

            final InputStream is = fileCtxt.getInputStream(applicationName, FinancialACConstants.ICON_ACCOUNT);
            final InputStream is2 = fileCtxt.getInputStream(applicationName, FinancialACConstants.ICON_TITLE_ACCOUNT);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            final byte[] bytes = new byte[2048];
            int read = is.read(bytes);
            while (read != -1) {
                bos.write(bytes, 0, read);
                read = is.read(bytes);
            }

            this.iconAccount = bos.toByteArray();

            bos = new ByteArrayOutputStream();
            read = is2.read(bytes);
            while (read != -1) {
                bos.write(bytes, 0, read);
                read = is2.read(bytes);
            }

            this.iconTitleAccount = bos.toByteArray();
        } catch (final NamingException e) {
            this.logger.logp(JETLevel.SEVERE, "SecondaryCOAPlanPrintHelper", "SecondaryCOAPlanPrintHelper", e.getMessage(), e);
        } catch (final IOException e) {
            this.logger.logp(JETLevel.SEVERE, "SecondaryCOAPlanPrintHelper", "SecondaryCOAPlanPrintHelper", e.getMessage(), e);
        } catch (final JETException e) {
            this.logger.logp(JETLevel.SEVERE, "SecondaryCOAPlanPrintHelper", "SecondaryCOAPlanPrintHelper", e.getMessage(), e);
        }

        final ModelList ml = listDisplayModel.getChildrenByTagName("COLUMN");
        while (ml.hasNext()) {
            this.columnList.add(ml.next());
        }

        this.invoice = this.iTextManagerContext.createITextDocument(FONT_FAMILY.HELVETICA, 10);
        this.invoice.setDocOrientation(DOCUMENT_ORIENTATION.LANDSCAPE);
        this.invoice.setLeftMargin(10);
        this.invoice.setRightMargin(10);

        this.currentBusinessUnit = currentBusinessUnit;
        this.listTreeTableContentProvider = listTreeContentProvider;
        this.comparator = comparator;
        this.session = session;
        if (endDate == null) {
            this.endDate = null;
        } else {
            this.endDate = (Date) endDate.clone();
        }
        this.isDraft = isDraft;
        this.title = title;
        this.localizedTitle = localizedTitle;

        this.nextRow = constructHeaderTable();

        this.numberFormat = NumberFormat.getNumberInstance(this.locale.getLocale());
        this.numberFormat.setMinimumFractionDigits(0);
        this.numberFormat.setMaximumFractionDigits(6);
    }

    /**
     * @return pdf
     * @throws JETException
     * @throws NamingException
     */
    public byte[] buildDocument() throws JETException, NamingException {
        // header
        final Map<String, String> args = new HashMap<String, String>();
        args.put("Locale", this.locale.getLanguage());
        args.put("BusinessUnit", this.currentBusinessUnit.getIdBusinessUnit().toString());

        final ExerciseBOApplicationComponent exerciseAC = ExerciseBOApplicationComponent.getInstance(this.session);
        final Exercise exercice = exerciseAC.getCurrentExercise();
        assert exercice != null : "Impossible to get to a printout if there is no exercise in the BusinessUnit";

        final StandardHeader standardHeader = new StandardHeader(this.currentBusinessUnit.getName(), exercice.getFromDate(), exercice.getToDate(), this.title, this.localizedTitle, args, this.endDate, this.isDraft, this.locale, this.logger, this.version, this.session);
        ITextConstraints iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, 0, 1, 1);
        this.invoice.addHeaderElement(standardHeader.getHeader(), iTextConstraints);

        // body
        final Model root = this.listTreeTableContentProvider.getRoot();
        try {
            createBody(root, 0);
        } catch (final IOException e) {
            this.logger.logp(JETLevel.SEVERE, "SecondaryCOAPlanPrintHelper", "buildDocument", e.getMessage(), e);
        }
        if (this.iTextGroupDetails.getNumberRows() == 2) {
            // empty sheet
            this.iTextGroupDetails.setHeaderRows(0);
        }

        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, 0, 1, 1);

        iTextConstraints.setBorder(BORDER_LINE.THIN);
        iTextConstraints.setBorderColor(Color.BLACK);
        final float[] widths = { 10f, 5f, 10f, 3f, 3f, 3f, 4f, 4f, 4f };
        this.iTextGroupDetails.setWidthColumns(widths);

        this.invoice.addBodyElement(this.iTextGroupDetails, iTextConstraints);

        final ITextPageNumber pageNumber = this.iTextManagerContext.createITextPageNumber();
        iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.RIGHT, 0, 0, 1, 1);
        this.invoice.addFooterElement(pageNumber, iTextConstraints);
        return this.invoice.buildDocument();
    }

    /**
     * Construct header table.
     *
     * @return the number of rows.
     */
    private int constructHeaderTable() {
        this.iTextGroupDetails = this.iTextManagerContext.createITextGroup();
        ITextConstraints iTextConstraints;
        ITextElementText iTextElementText;

        final int size = this.columnList.size();
        // add column name
        for (int i = 0; i < size; i++) {
            iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, i, 1, 1);
            final String text = getColumnName(i);
            iTextElementText = this.iTextManagerContext.createITextElementText(text);
            iTextElementText.setFontStyle(FONT_STYLE.BOLD);
            iTextConstraints.setLeftBorder(BORDER_LINE.THIN);
            iTextConstraints.setTopBorder(BORDER_LINE.THIN);
            if (i == this.columnList.size() - 1) {
                iTextConstraints.setRightBorder(BORDER_LINE.THIN);
            }
            iTextElementText.setRightIndentation(3f);
            this.iTextGroupDetails.addElement(iTextElementText, iTextConstraints);
        }

        // add a blank line
        for (int i = 0; i < size; i++) {
            iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 1, i, 1, 1);
            iTextElementText = this.iTextManagerContext.createITextElementText("\n");
            iTextElementText.setFontStyle(FONT_STYLE.BOLD);
            iTextConstraints.setLeftBorder(BORDER_LINE.THIN);
            iTextConstraints.setBottomBorder(BORDER_LINE.THIN);
            if (i == this.columnList.size() - 1) {
                iTextConstraints.setRightBorder(BORDER_LINE.THIN);
            }
            iTextElementText.setRightIndentation(3f);
            this.iTextGroupDetails.addElement(iTextElementText, iTextConstraints);
        }

        this.iTextGroupDetails.setHeaderRows(2);
        return this.iTextGroupDetails.getNumberRows();
    }

    private void createBody(final Model root, final int niveau) throws JETException, IOException, NamingException {
        final int nbColumn = this.columnList.size();

        final ModelList mlTemp = root.getChildNodes();

        final Model[] ml = sortModel(mlTemp);

        final ITextElementImage titleAccountIcon = this.iTextManagerContext.createITextElementImage(this.iconTitleAccount);
        final ITextElementImage accountIcon = this.iTextManagerContext.createITextElementImage(this.iconAccount);
        ITextConstraints iTextConstraints;
        final int level = niveau + 1;
        for (final Model childModel : ml) {
            final ITextGroup treeGroup = this.iTextManagerContext.createITextGroup();
            final float leftIndet = (level - 1) * 15;
            final Model dataModel = this.listTreeTableContentProvider.getNodeDataModel(childModel);
            assert dataModel != null;

            if (isTitleAccount(childModel)) {
                iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, 0, 1, 1);
                iTextConstraints.setLeftPadding(leftIndet);
                treeGroup.addElement(titleAccountIcon, iTextConstraints);
            } else {
                iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, 0, 1, 1);
                iTextConstraints.setLeftPadding(leftIndet);
                treeGroup.addElement(accountIcon, iTextConstraints);
            }

            final AccountPlanItem accountPlanItem = new AccountPlanItem(dataModel);
            ITextElementText iTextElementText = this.iTextManagerContext.createITextElementText(accountPlanItem.getNumber());
            iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, 0, 1, 1, 1);
            treeGroup.addElement(iTextElementText, iTextConstraints);
            iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, this.nextRow, 0, 1, 1);
            iTextConstraints.setLeftBorder(BORDER_LINE.THIN);
            iTextConstraints.setBottomBorder(BORDER_LINE.THIN);
            iTextElementText.setRightIndentation(3f);
            final float leftWidth = (leftIndet + 15) - (level * 3) - (level - 1);
            final float total = 100f - leftWidth;
            final float[] test = { leftWidth, total };
            treeGroup.setWidthColumns(test);
            this.iTextGroupDetails.addElement(treeGroup, iTextConstraints);

            final String accountName = ModelHelper.getChildNodeValueAsString(dataModel, AccountBalanceConstants.NAME_NODE);
            iTextElementText = this.iTextManagerContext.createITextElementText(accountName);
            iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, this.nextRow, 1, 1, 1);
            iTextConstraints.setLeftBorder(BORDER_LINE.THIN);
            iTextConstraints.setBottomBorder(BORDER_LINE.THIN);
            iTextElementText.setRightIndentation(3f);
            this.iTextGroupDetails.addElement(iTextElementText, iTextConstraints);

            for (int j = 2; j < nbColumn; j++) {
                final String nodeName = getNodeName(j);
                final Model columnValue = ModelHelper.getChild(dataModel, nodeName);
                final String type = (String) this.columnList.get(j).getAttribute(CommonDisplayModelConstants.ATTRIBUTE_TYPE2);
                String cellule = "";
                iTextConstraints = this.iTextManagerContext.createITextConstraints(VERTICAL_ALIGNMENT.TOP, HORIZONTAL_ALIGNMENT.LEFT, this.nextRow, j, 1, 1);
                iTextConstraints.setLeftBorder(BORDER_LINE.THIN);
                iTextConstraints.setBottomBorder(BORDER_LINE.THIN);
                if (j == nbColumn - 1) {
                    iTextConstraints.setRightBorder(BORDER_LINE.THIN);
                }
                iTextElementText.setRightIndentation(3f);
                if (columnValue.getNodeValue() == null) {
                    // test combobox
                    if (columnValue.getNumberOfChildren() > 0) {
                        final Model child = columnValue.getChildAtIndex(0);
                        final Object nv = child.getNodeValue();
                        if (nv instanceof Displayable) {
                            final Displayable disp = (Displayable) nv;
                            cellule = disp.getDisplayableString(this.locale);
                        } else if (nv instanceof String) {
                            cellule = (String) nv;
                        }
                    }
                    final ITextElement iTextElement = this.iTextManagerContext.createITextElementText(cellule);
                    this.iTextGroupDetails.addElement(iTextElement, iTextConstraints);
                } else {
                    if ("DATE".equals(type)) {
                        final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); // NOPMD - no locale in constructor for this moment
                        cellule = sdf.format((Date) columnValue.getNodeValue());
                        final ITextElement iTextElement = this.iTextManagerContext.createITextElementText(cellule);
                        this.iTextGroupDetails.addElement(iTextElement, iTextConstraints);
                    } else if ("CHECKBOX".equals(type)) {
                        final Boolean value = (Boolean) columnValue.getNodeValue();
                        if (value != null && value.booleanValue()) {
                            cellule = "V";
                        }
                        final ITextElement iTextElement = this.iTextManagerContext.createITextElementText(cellule);
                        this.iTextGroupDetails.addElement(iTextElement, iTextConstraints);
                    } else if ("INTEGER".equals(type)) {
                        final Object nodeValue = columnValue.getNodeValue();
                        if (nodeValue != null) {
                            final Number number = (Number) nodeValue;
                            cellule = this.numberFormat.format(BigDecimal.valueOf(number.longValue()));
                        }
                        final ITextElement iTextElement = this.iTextManagerContext.createITextElementText(cellule);
                        this.iTextGroupDetails.addElement(iTextElement, iTextConstraints);
                    } else if ("NUMBER".equals(type) || "DOUBLE".equals(type) || "MONEY".equals(type)) {
                        final Object nodeValue = columnValue.getNodeValue();
                        if (nodeValue != null) {
                            final Number number = (Number) nodeValue;
                            cellule = this.numberFormat.format(BigDecimal.valueOf(number.doubleValue()));
                        }
                        final ITextElement iTextElement = this.iTextManagerContext.createITextElementText(cellule);
                        this.iTextGroupDetails.addElement(iTextElement, iTextConstraints);
                    } else if ("ICON".equals(type)) {
                        final String nodeValue = (String) columnValue.getNodeValue();
                        final UIContext myUIContext = (UIContext) ManagerHelper.getContext(UIContext.NAME);
                        final InputStream inputStream = myUIContext.getImage(nodeValue);
                        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        final byte[] bytes = new byte[2048];
                        int read = inputStream.read(bytes);
                        while (read != -1) {
                            bos.write(bytes, 0, read);
                            read = inputStream.read(bytes);
                        }

                        final ITextElementImage iTextElement = this.iTextManagerContext.createITextElementImage(bos.toByteArray());
                        this.iTextGroupDetails.addElement(iTextElement, iTextConstraints);
                    } else if ("BUTTON".equals(type)) {
                        final ITextElement iTextElement = this.iTextManagerContext.createITextElementText("");
                        this.iTextGroupDetails.addElement(iTextElement, iTextConstraints);
                    } else {
                        final Object nodeValue = columnValue.getNodeValue();
                        if (nodeValue != null) {
                            cellule = nodeValue.toString();
                        }
                        final ITextElement iTextElement = this.iTextManagerContext.createITextElementText(cellule);
                        this.iTextGroupDetails.addElement(iTextElement, iTextConstraints);
                    }
                }
            }
            this.nextRow++;
            createBody(childModel, level);
        }
    }

    private Model[] sortModel(final ModelList mlTemp) {
        final int nbOfChildren = mlTemp.getSize();
        final Model[] children = new Model[nbOfChildren];
        for (int i = 0; i < nbOfChildren; i++) {
            children[i] = mlTemp.get(i);
        }
        Arrays.sort(children, this.comparator);
        return children;
    }

    private boolean isTitleAccount(final Model treeNode) {
        final Boolean isTitleAccount = (Boolean) treeNode.getAttribute(TITLE_ACCOUNT_NODE);
        return Boolean.TRUE.equals(isTitleAccount);
    }

    private String getColumnName(final int columnIndex) {
        final Model column = this.columnList.get(columnIndex);

        final String localizedText = (String) column.getAttribute("localizedlabel");
        if (localizedText != null) {
            return getLocalized(localizedText);
        }
        return (String) column.getAttribute("label");
    }

    private String getNodeName(final int columnIndex) {
        final Model column = this.columnList.get(columnIndex);

        final String nodeName = (String) column.getAttribute("datamodelfield");

        return nodeName;
    }

    private String getLocalized(final String localizedText) {
        if (localizedText != null) {
            try {
                return this.localizedTextContext.getText(localizedText, this.locale);
            } catch (final JETException e) {
                this.logger.logp(JETLevel.SEVERE, "SecondaryCOAPlanPrintHelper", "getLocalized", e.getMessage(), e);
            }
        }

        return "";
    }

}
