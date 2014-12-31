package org.openl.rules.webstudio.web;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openl.message.OpenLErrorMessage;
import org.openl.message.OpenLMessage;
import org.openl.message.OpenLMessagesUtils;
import org.openl.message.OpenLWarnMessage;
import org.openl.message.Severity;
import org.openl.rules.ui.ProjectModel;
import org.openl.rules.ui.WebStudio;
import org.openl.rules.ui.tree.richfaces.TreeNode;
import org.openl.rules.webstudio.web.util.WebStudioUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Request scope managed bean providing logic for problems tree page of OpenL Studio.
 *
 * @author Andrei Astrouski
 */
@ManagedBean
@RequestScoped
public class ProblemsBean {

    public static final String ERRORS_ROOT_NAME = "Errors";
    public static final String WARNINGS_ROOT_NAME = "Warnings";

    public static final String ERROR_NODE_NAME = "error";
    public static final String WARNING_NODE_NAME = "warning";

    private static Map<Class<?>, MessageHandler> messageHandlers;

    static {
        messageHandlers = new HashMap<Class<?>, MessageHandler>();
        messageHandlers.put(OpenLErrorMessage.class, new ErrorMessageHandler());
        messageHandlers.put(OpenLWarnMessage.class, new WarningMessageHandler());
        messageHandlers.put(OpenLMessage.class, new MessageHandler());
    }

    public ProblemsBean() {
    }

    public TreeNode getTree() {
        int nodeCount = 1;

        WebStudio studio = WebStudioUtils.getWebStudio();

        if (studio.getCurrentProject() != null) {
            ProjectModel model = studio.getModel();

            List<OpenLMessage> messages = model.getModuleMessages();

            TreeNode root = new TreeNode();

            List<OpenLMessage> errorMessages = OpenLMessagesUtils.filterMessagesBySeverity(messages, Severity.ERROR);
            if (CollectionUtils.isNotEmpty(errorMessages)) {
                TreeNode errorsRoot = createMessagesRoot(ERRORS_ROOT_NAME, errorMessages.size());
                addMessageNodes(errorsRoot, ERROR_NODE_NAME, errorMessages, model);
                root.addChild(nodeCount++, errorsRoot);
            }

            List<OpenLMessage> warningMessages = OpenLMessagesUtils.filterMessagesBySeverity(messages, Severity.WARN);
            if (CollectionUtils.isNotEmpty(warningMessages)) {
                TreeNode warningsRoot = createMessagesRoot(WARNINGS_ROOT_NAME, warningMessages.size());
                addMessageNodes(warningsRoot, WARNING_NODE_NAME, warningMessages, model);
                root.addChild(nodeCount++, warningsRoot);
            }

            return root;
        }
        return null;
    }

    public boolean isHasProblems() {
        WebStudio studio = WebStudioUtils.getWebStudio();
        return studio.getCurrentProject() != null && !studio.getModel().getModuleMessages().isEmpty();
    }

    private TreeNode createMessagesRoot(String rootName, int messagesNumber) {
        return new TreeNode(rootName, rootName, null, 0, messagesNumber, rootName.toLowerCase(), true);
    }

    private void addMessageNodes(TreeNode parent, String nodeName, List<OpenLMessage> messages, ProjectModel model) {
        int nodeCount = 1;

        for (OpenLMessage message : messages) {
            String url = getNodeUrl(message, model);
            TreeNode messageNode = new TreeNode(true,
                    message.getSummary(), message.getDetails(), url, 0, 0, nodeName.toLowerCase(), true);
            parent.addChild(nodeCount++, messageNode);
        }
    }

    private String getNodeUrl(OpenLMessage message, ProjectModel model) {
        MessageHandler messageHandler = messageHandlers.get(message.getClass());

        String url = messageHandler.getSourceUrl(message, model);

        if (StringUtils.isBlank(url)) {
            url = messageHandler.getUrlForEmptySource(message);
        }

        return url;
    }

}