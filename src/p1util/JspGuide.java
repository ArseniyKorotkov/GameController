package p1util;

public final class JspGuide {

    private static final String jspAddress = "/WEB-INF/jsp/";

    public static String to(String pageName) {
        return jspAddress + pageName + ".jsp";
    }
}
