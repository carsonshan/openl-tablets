package org.openl.rules.webstudio.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang3.StringUtils;
import org.openl.exception.OpenLException;
import org.openl.exception.OpenLExceptionUtils;
import org.openl.main.SourceCodeURLTool;
import org.openl.message.OpenLErrorMessage;
import org.openl.message.OpenLMessage;
import org.openl.message.OpenLWarnMessage;
import org.openl.rules.lang.xls.syntax.TableUtils;
import org.openl.rules.table.xls.XlsUrlParser;
import org.openl.rules.ui.ProjectModel;
import org.openl.rules.webstudio.web.util.WebStudioUtils;
import org.openl.syntax.ISyntaxNode;
import org.richfaces.component.UIRepeat;

@ManagedBean
@RequestScoped
public class MessagesBean {

    private UIRepeat messages;

    public MessagesBean() {
    }

    public UIRepeat getMessages() {
        return messages;
    }

    public void setMessages(UIRepeat messages) {
        this.messages = messages;
    }

    public String getSummary() {
        OpenLMessage message = (OpenLMessage) messages.getRowData();
        String summary = message.getSummary();
        if (StringUtils.isNotBlank(summary)) {
            return summary.replaceAll("\\r\\n", "<br>");
        }
        return StringUtils.EMPTY;
    }

    public String[] getErrorCode() {
        OpenLMessage message = (OpenLMessage) messages.getRowData();

        if (message instanceof OpenLErrorMessage) {
            OpenLErrorMessage errorMessage = (OpenLErrorMessage) message;
            OpenLException error = errorMessage.getError();

            return OpenLExceptionUtils.getErrorCode(error);
        } else if (message instanceof OpenLWarnMessage) {
            OpenLWarnMessage warnMessage = (OpenLWarnMessage) message;
            ISyntaxNode source = warnMessage.getSource();
            return OpenLExceptionUtils.getErrorCode(source.getSourceLocation(), source.getModule());
        }

        return new String[0];
    }

    public String getTableId() {
        String errorUri = getErrorUri();

        ProjectModel model = WebStudioUtils.getProjectModel();

        return TableUtils.makeTableId(model.findTableUri(errorUri));
    }

    public String getErrorCell() {
        String errorUri = getErrorUri();

        XlsUrlParser uriParser = new XlsUrlParser();
        uriParser.parse(errorUri);

        return uriParser.cell;
    }

    private String getErrorUri() {
        String errorUri;
        Object rowData = messages.getRowData();

        if (rowData instanceof OpenLErrorMessage) {
            OpenLErrorMessage message = (OpenLErrorMessage) rowData;
            OpenLException error = message.getError();

            errorUri = SourceCodeURLTool.makeSourceLocationURL(error.getLocation(), error.getSourceModule(), "");
        } else if (rowData instanceof OpenLWarnMessage) {
            OpenLWarnMessage message = (OpenLWarnMessage) rowData;
            ISyntaxNode source = message.getSource();

            errorUri = SourceCodeURLTool.makeSourceLocationURL(source.getSourceLocation(), source.getModule(), "");
        } else {
            errorUri = null;
        }

        return errorUri;
    }

}